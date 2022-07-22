package com.example.subdemo.mbp.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.subdemo.mbp.bean.AreaPo;
import com.example.subdemo.mbp.mapper.AreaMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AreaServiceImpl implements AreaService {

    @Resource
    private AreaMapper areaMapper;

    public static void main(String[] args) {
//        Arrays.asList("a").stream().filter(value -> !StrUtil.equals(value, "a")).map(x -> {
//            System.out.println(x);
//            return x;
//        }).collect(Collectors.toList());

        List<Dt> dataList = new ArrayList<>();
        dataList.add(new Dt().setAddress("a"));
        dataList.add(new Dt().setName("a"));
        dataList.add(new Dt().setAddress("c"));
        Map<String, String> hashmap = new HashMap<>();
        hashmap = dataList.stream().collect(Collectors.toMap(Dt::getName, Dt::getAddress, (first, last) -> last));
//        dataList.stream().forEach(data -> hashmap.put(data.getName(), data.getAddress()));
        System.out.println(hashmap);

        Integer a = 1;
        Integer b = 1;
        System.out.println(ObjectUtil.equal(a, b));

    }

    @Override
//    @Transactional
    public void method() {
        //1. Bean中存在表中不存在的属性 则会报错
        //2. 表中存在Bean中不存在的属性  则不会报错
        //3. 综述 表中应该具备全量字段
//        AreaPo areaPo = areaMapper.selectById(1);
//        Wrappers.<AreaPo>lambdaUpdate().eq(AreaPo::getId, 1).set(AreaPo::getName, "张三");
//        log.info(areaPo.toString());
//        String whereSql = "company->>'id'={0}";
//        String orderBySql = "order by company->>'id' desc";
//        List<AreaPo> areaPoList = areaMapper.selectList(Wrappers.<AreaPo>lambdaQuery()
//                .eq(AreaPo::getName, "zhangsan")
//                .last(orderBySql));
//        System.out.println(areaPoList);
//        areaPoList.stream().forEach(areaPo -> areaPo.setId(null));
//        List<AreaPo> areaPoList2 = areaMapper.selectList(Wrappers.<AreaPo>lambdaQuery()
//                .eq(AreaPo::getName, "zhangsan")
//                .last(orderBySql));
//        System.out.println(areaPoList2);
//
//        serviceA.service();
//
//        System.out.println("A");
//
//        String apply = "1=1";
//        String apply2 = "company->>'name'='oceanus'";
//        String groupJsonSql = "group by company->>'id',company->>'name' order by company->>'id' )a limit 2 offset 0";
//
////        //不存在驼峰
//        QueryWrapper gpWrapper = Wrappers.query()
//                .select("company->>'id' as \"idName\"", "company->>'name' as name")
//                .apply(apply)
//                .apply(apply2)
//                .last(groupJsonSql);
//
//        gpWrapper.first("select * from (");
//
//        List<Map<String, Object>> areaListMap = baseMapper.selectMaps(gpWrapper);
//        System.out.println(areaListMap);
////        System.out.println(areaMapper.selectAreaPoByCompanyNameAndId());

//        System.out.println(areaMapper.selectAreaList(null, new Qc().setId(null).setName("oceanus").setLimit(2), 0, 2));

//        areaMapper.deleteById(7);
//        String[] emailList = new String[60000];
//        for (int index = 0; index < emailList.length; index++) {
//            emailList[index] = "abcdddddddddddddddddddddddddddddddddd";
//        }
//        QueryWrapper<AreaPo> queryWrapper = new QueryWrapper<>();
//        String[] destArr = new String[Short.MAX_VALUE];
//        System.arraycopy(emailList, 0, destArr, 0, Short.MAX_VALUE);
//        queryWrapper.select("age", "name");
////        queryWrapper.in("email", Arrays.asList(destArr));
////        queryWrapper.eq("name", "zhangsan");
//        List<AreaPo> areaPoList = areaMapper.selectList(queryWrapper);
//
//        String[] destArr2 = new String[emailList.length - Short.MAX_VALUE];
//        System.arraycopy(emailList, Short.MAX_VALUE, destArr2, 0, emailList.length - Short.MAX_VALUE);
//        QueryWrapper<AreaPo> queryWrapper2 = new QueryWrapper<>();
//        queryWrapper2.in("email", Arrays.asList(destArr2));
//        areaPoList.addAll(areaMapper.selectList(queryWrapper2));
//        System.out.println(areaPoList);

        //调用存储过程
        areaMapper.callProcedure();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void method2() throws IOException {
//        areaMapper.insert(new AreaPo().setName("jk"));
//        try {
//            Thread.sleep(10_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        LambdaQueryWrapper<AreaPo> queryWrapper = Wrappers.lambdaQuery();
//        queryWrapper.apply("id={0}", 11);
//        AreaPo areaPo = areaMapper.selectOne(queryWrapper);
//        System.out.println(areaPo);
        AreaPo areaPo = new AreaPo();
        areaPo.setId(11);
        areaPo.setDescription("123");
//        areaPo.setName(null);
        areaMapper.insert(areaPo);
//        运行时异常 会回滚
//        throw new RuntimeException();
//        非运行时异常并且不是ERROR实例 不会回滚  (ex instanceof RuntimeException || ex instanceof Error)
//        throw new IOException();
    }

    @Data
    @Accessors(chain = true)
    static class Dt {

        private String name;

        private String address;
    }
}

