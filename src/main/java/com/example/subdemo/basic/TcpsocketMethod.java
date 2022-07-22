//package com.example.demo;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.googlecode.protobuf.format.JsonFormat;
//import com.zhizai.common.utils.CacheUtils;
//import com.zhizai.common.utils.Constant;
//import com.zhizai.common.utils.DateUtils;
//import com.zhizai.common.utils.SpringContextUtils;
//import com.zhizai.modules.base.service.RabbitService;
//import com.zhizai.modules.business.controller.SrsController;
//import com.zhizai.modules.business.entity.UavClusterEntity;
//import com.zhizai.modules.business.entity.UavDefaultSpeedEntity;
//import com.zhizai.modules.business.entity.UavInfoEntity;
//import com.zhizai.modules.business.entity.UavSortiesEntity;
//import com.zhizai.modules.business.entity.mongo.FlyRecord;
//import com.zhizai.modules.business.entity.vo.ClusterVO;
//import com.zhizai.modules.business.service.UavClusterService;
//import com.zhizai.modules.business.service.UavDefaultSpeedService;
//import com.zhizai.modules.business.service.UavInfoService;
//import com.zhizai.modules.business.service.UavSortiesService;
//import com.zhizai.modules.realtime.handler.TcpSocketHandler;
//import com.zhizai.modules.realtime.protocol.DataInfo;
//import com.zhizai.modules.realtime.protocol.WsVO;
//import com.zhizai.modules.sys.entity.SysUserEntity;
//import com.zhizai.modules.sys.service.SysUserService;
//import io.netty.channel.Channel;
//import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
///**
// * Created by sudeyu
// * Date 2021/7/7 13:02
// * Description tcpsocket方法
// */
//@Slf4j
//public enum TcpsocketMethod {
//
//
//    MovementType(0) {
//        @Override
//        public void run(Channel channel, DataInfo.Message msg, long requestTime) {
//            String flyNum = msg.getFlyNum();
//            DataInfo.Movement movement = msg.getMovement();
//            log.debug("tcpSocket-->无人机信息：{}", movement.toString());
//
//            //航线信息入队列
//            if(!movement.getCurrentLatitude().equals(Constant.ZERO)) {
//                try {
//                    FlyRecord flyRecordInfo = new FlyRecord(flyNum, movement.getCurrentLongitude(),
//                        movement.getCurrentLatitude(),
//                        DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN),
//                        movement.getElectricityInfoA(), movement.getElectricityInfoB(),
//                        movement.getVoltageInfoA(), movement.getVoltageInfoB(),
//                        movement.getFlyingHeight(),
//                        movement.getWindSpeed(), movement.getAngleYaw(),
//                        movement.getRtkSign() ? 1 : 0);
//                    RabbitService rabbitService = SpringContextUtils.getBean(RabbitService.class);
//                    rabbitService.sendFlyRecord(flyRecordInfo);
//                    log.debug("tcpSocket-->航线信息已入队列！！！");
//
//                } catch (Exception e) {
//                    log.error("tcpSocket-->航线信息入队列失败！！！:{}", e.getMessage(), e.getCause());
//                }
//            }
//            if (Constant.channelMap.containsKey(channel)) {
//                WsVO<HashMap> wsVO = new WsVO<>();
//                wsVO.setFlyNum(flyNum);
//                wsVO.setType(2);
//                wsVO.setMsg("无人机移动信息");
//                wsVO.setData(JSONObject.parseObject(JsonFormat.printToString(movement), HashMap.class));
//
//                Vector<Channel> webChannelVector = Constant.channelMap.get(channel);
//                for (Channel webChannel : webChannelVector) {
//                    webChannel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(wsVO))).addListener(future -> {
//                        if (future.isSuccess()) {
//                            log.debug("无人机信息movement发送成功！！！");
//                        } else {
//                            log.debug("无人机信息movement发送失败-->:{}", future.cause().getMessage(), future.cause());
//                        }
//                    });
//
//                }
//            } else {
//                log.debug("tcpSocket-->：{}", "编号" + flyNum + "无人机的webSocket尚未连接");
//
//            }
//        }
//    },
//    RegisterRequestType(5) {
//        @Override
//        public void run(Channel channel, DataInfo.Message msg, long requestTime) {
//            String flyNum = msg.getFlyNum();
//            log.info("tcp 注册 flyNum ：{}", flyNum);
//
//            UavDefaultSpeedService defaultSpeedService = SpringContextUtils.getBean(UavDefaultSpeedService.class);
//            UavDefaultSpeedEntity speedEntity = defaultSpeedService.getOne(new QueryWrapper<UavDefaultSpeedEntity>()
//                    .eq("uav_number", flyNum));
//
//            if (null == speedEntity) {
//                log.debug("tcpSocket-->编号：{}", flyNum + "非系统设备连接，通道关闭！！！");
//                DataInfo.Message.Builder builder = DataInfo.Message.newBuilder();
//                builder.setDataType(DataInfo.Message.DataType.RequestResponseType);
//                DataInfo.RequestResponse.Builder resBuilder = DataInfo.RequestResponse.newBuilder();
//                resBuilder.setResponseType(DataInfo.RequestResponse.ResponseType.OtherResponseType);
//                DataInfo.OtherResponse.Builder otherResponse = DataInfo.OtherResponse.newBuilder();
//                otherResponse.setMsg(flyNum + "非系统设备连接，通道关闭！！！");
//                resBuilder.setOther(otherResponse.build());
//                builder.setRequestResponse(resBuilder.build());
//                channel.writeAndFlush(builder.build()).addListener(future -> {
//                    if (future.isSuccess()) {
//                        log.debug("tcpSocket-->编号：{}", flyNum + "注册响应发送成功！！！");
//                    } else {
//                        log.error("tcpSocket-->编号：{}", flyNum + "注册响应发送失败！！！", future.cause());
//                    }
//                    Thread.sleep(1000);
//                    channel.close();
//                });
//
//            } else {
//                if (Constant.tcpChannelMap.containsKey(flyNum)) {
//                    Channel removeChannel = Constant.tcpChannelMap.remove(flyNum);
//                    removeChannel.close();
//
//                }
//
//                //绑定websocket
//                boolean sign = false;
//                Set<String> clusterSet = new HashSet<>();
//                Set<String> flySet = new HashSet<>();
//                Set<String> userSet = Constant.webChannelMap.keySet();
//                for (String user : userSet) {
//                    if (user.contains(Constant.webParamSign)) {
//                        flySet.add(user);
//                    } else {
//                        clusterSet.add(user);
//                    }
//                }
//
//                for (String fly : flySet) {
//                    String num = fly.substring(fly.lastIndexOf(Constant.webParamSign) + 1);
//                    if (flyNum.equals(num)) {
//                        TcpSocketHandler.tcpBindingWeb(channel, fly);
//                        sign = true;
//                    }
//                }
//
//                for (String username : clusterSet) {
//                    List<String> flyNumList = new ArrayList<>();
//                    SysUserService userService = SpringContextUtils.getBean(SysUserService.class);
//                    UavInfoService infoService = SpringContextUtils.getBean(UavInfoService.class);
//                    SysUserEntity userEntity = userService.getOne(new QueryWrapper<SysUserEntity>().eq("username", username));
//                    if (userEntity != null) {
//                        UavClusterService clusterService = SpringContextUtils.getBean(UavClusterService.class);
//                        ClusterVO cluster = clusterService.getClusterList(userEntity.getUserId());
//                        List<ClusterVO.ClusterList> clusterList = cluster.getList();
//
//                        //判断是否在集群中
//                        if (clusterList.isEmpty()) {
//                            List<UavInfoEntity> list = infoService.selectUavByUsername(username);
//                            flyNumList = Optional.ofNullable(list).map(List::stream).orElseGet(Stream::empty).map(UavInfoEntity::getNumber).collect(Collectors.toList());
//                        } else {
//                            for (ClusterVO.ClusterList v : clusterList) {
//                                flyNumList.add(v.getNumber());
//                            }
//                        }
//                    }
//
//                    if (flyNumList.contains(flyNum)) {
//                        TcpSocketHandler.tcpBindingWeb(channel, username);
//                        sign = true;
//                    }
//                }
//
//                if (sign) {
//                    log.debug("tcpSocket-->编号：{}", flyNum + "绑定websocket成功");
//                } else {
//                    log.debug("tcpSocket-->编号：{}", flyNum + "暂无websocket需要绑定");
//                }
//
//                //tcpsocket
//                Constant.tcpChannelMap.put(flyNum, channel);
//                log.debug("tcpSocket-->编号：{}", flyNum + "注册成功");
//
//                new TcpSocketHandler().registerResponseMessage(channel, flyNum, requestTime, speedEntity);
//            }
//
//            /*
//             * 注册后发送重新推流，防止是socket断线重连导致设备端推流断网死掉
//             */
//            Vector<Channel> webChannels = Constant.channelMap.get(channel);
//            if (webChannels != null && webChannels.size() > 0) {
//                WsVO<Object> wsVO = new WsVO<>();
//                wsVO.setFlyNum(flyNum);
//                wsVO.setType(3);
//                for (Channel webChannel : webChannels) {
//                    webChannel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(wsVO)))
//                        .addListener(future -> {
//                            if (future.isSuccess()) {
//                                log.info("客户端重新拉流信息发送成功！！！ flyNum: {}", flyNum);
//                            } else {
//                                log.error("客户端重新拉流信息发送失败！！！-->flyNum : :{} , {} ,{}", flyNum,
//                                    future.cause().getMessage(),
//                                    future.cause());
//                            }
//                        });
//                }
//            }
//            channel.writeAndFlush(SrsController.RESTART_LIVE).addListener(future -> {
//                if (future.isSuccess()) {
//                    log.info("发送给设备端：{} 重新推流成功 ", flyNum);
//                } else {
//                    log.info("发送给设备端：{} 重新推流失败 ", flyNum);
//                }
//            });
//
//        }
//    },
//    RequestResponseType(6) {
//        @Override
//        public void run(Channel channel, DataInfo.Message msg, long requestTime) {
//            DataInfo.RequestResponse requestResponse = msg.getRequestResponse();
//            String responseId = msg.getId();
//            if (requestResponse.getResponseType() == DataInfo.RequestResponse.ResponseType.OtherResponseType) {
//                CacheUtils.put(responseId, requestResponse.getStatus() + "&" + requestResponse.getOther().getMsg());
//                log.debug("tcpSocket-->{}", responseId + "请求响应已返回");
//
//            } else {
//                log.debug("tcpSocket-->响应类型错误，通道关闭");
//                channel.close();
//
//            }
//        }
//    },
//    SortiesType(9) {
//        @Override
//        public void run(Channel channel, DataInfo.Message msg, long requestTime) {
//            UavSortiesService sortiesService = SpringContextUtils.getBean(UavSortiesService.class);
//            UavClusterService clusterService = SpringContextUtils.getBean(UavClusterService.class);
//            DataInfo.Sorties sorties = msg.getSorties();
//            if (0 == sorties.getType()) {
//                UavSortiesEntity entity = new UavSortiesEntity();
//                entity.setUavNumber(msg.getFlyNum());
//                entity.setStartTime(new Date());
//                sortiesService.save(entity);
//
//                log.debug("架次开始，编号为：{}", msg.getFlyNum());
//            } else if (1 == sorties.getType()) {
//                boolean result = sortiesService.updateEndTime(msg.getFlyNum(), DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
//                if (result) {
//                    log.debug("架次结束，编号为：{}", msg.getFlyNum());
//                } else {
//                    log.debug("架次结束插入错误，编号为：{}", msg.getFlyNum());
//                }
//                clusterService.deleteOneUav(msg.getFlyNum());
//            } else {
//                log.debug("tcpSocket-->架次类型传输错误");
//            }
//        }
//    };
//
//    TcpsocketMethod(Integer value) {
//        this.value = value;
//    }
//
//    private final Integer value;
//
//    public Integer getValue() {
//        return value;
//    }
//
//    public abstract void run(Channel channel, DataInfo.Message msg, long requestTime);
//}


