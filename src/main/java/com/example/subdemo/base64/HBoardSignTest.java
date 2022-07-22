package com.example.subdemo.base64;

import cn.hutool.core.io.FileUtil;
import java.io.File;
import java.util.UUID;
import net.sf.json.JSONObject;
import org.bouncycastle.util.encoders.Base64;

public class HBoardSignTest {

    public static void main(String[] args) throws Exception {

        String api_key = "00000";     //平台分配的API Key
        String api_secret = "00000000";  //平台分配的API Secret

        /**
         * auto:基于后台配置的位置规则
         * position：基于位置盖章
         * keyword：基于关键字盖章
         */
        String document_no = UUID.randomUUID().toString(); //文档唯一编号

        //PDF数据，读取文件字节后转成Base64编码字符串
        String pdf = new String(Base64.encode(FileUtil.readBytes(new File("C:\\Users\\sheng.lv\\Downloads\\developer-switch.pdf"))));
		System.out.println(pdf);
//        //组织请求数据
//        JSONObject reqObj = new JSONObject();
//        reqObj.put("api_key", api_key);
//        reqObj.put("api_secret", api_secret);
//
//        //组织seal 节点
//        JSONObject dataObj = new JSONObject();
//        dataObj.put("document_no", document_no);
//        dataObj.put("pdf", pdf);
////		dataObj.put("return_url", "http://192.168.100.8:8080/TrustDocSign_WSJ/seal/callback.action");
////		dataObj.put("collection_source", "{id_card,hand_sign, fingerprint,face_photos}");
//        dataObj.put("collection_source", "{hand_sign,fingerprint,face_photos}");
//        dataObj.put("information_url", "");
//
//        JSONObject positionObj = new JSONObject();
//        positionObj.put("page", 1);  //页码
//        positionObj.put("x", "300"); //对应文档x坐标，（左下角为原点，最大850）
//        positionObj.put("y", "300"); //对应文档y坐标，（左下角为原点，最大1200）
//        //加入data节点
//        dataObj.put("position", positionObj);
//
//        dataObj.put("time", ""); //签章时间，格式为yyyyMMddHHmmss。如果不传入，则使用服务器当前时间
//
//        //将seal 节点加入请求数据
//        reqObj.put("data", dataObj);
//
//        //打印请求数据报文
//        System.out.println("请求:" + dataObj.toString());
//
//        //发送报文到接口地址
//
//        String res = HttpClientUtil.doPost("http://47.100.199.230:8080/pdfsign_hw/seal/eventSign", reqObj.toString(), "UTF-8");
//        //打印响应报文
////		System.out.println("响应:" + res);
//
//        //解析响应报文
//        JSONObject resObj = JSONObject.fromObject(res);
//        int ret_code = resObj.getInt("ret_code");
//        String ret_msg = resObj.getString("ret_msg");
//        if (ret_code == 0) {
//            //成功
//            System.out.println("ret_msg:" + ret_msg);
//            System.out.println("ret_code:" + ret_code);
//            String signUrl = resObj.getString("sign_url");
//            System.out.println("signUrl:" + signUrl);
//        } else {
//            //失败，打印失败错误描述
//            System.out.println("ret_msg:" + ret_msg);
//            System.out.println("ret_code:" + ret_code);
//        }

    }
}
