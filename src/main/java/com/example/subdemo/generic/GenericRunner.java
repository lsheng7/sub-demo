package com.example.subdemo.generic;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericRunner implements ApplicationRunner {

    @Resource
    private Map<String, GenericService> genericServiceMap;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(genericServiceMap);
        final BaseVo baseVo = genericServiceMap.get("genericIntegerServiceImpl").method(null);
//        List<String> list=new ArrayList<>();
//        //编译
//        //反射方式设置进去
//        list.add(new Object());
    }

//    public static void main(String[] args) {
//        Map map1=new HashMap();
//        Map<Object,Object> map2=new HashMap<>();
//        Map<Object,String> map3=new HashMap<>();
//        test(map1);
//        test(map2);
//        test(map3);
//    }
//    public static void test(Map<Object,String> map){
//    }
//    泛型擦除
//    deep clone 和shadow clone
}
