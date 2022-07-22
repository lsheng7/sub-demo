package com.example.subdemo.impl;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import lombok.Data;
import lombok.experimental.Accessors;

public class StreamReducing {

    public static void main(String[] args) {

        List<ReducingBean> reducingBeanList = new ArrayList<>();
        ReducingBean reducingBean = new ReducingBean().setName("A").setHeight(180);
        ReducingBean reducingBean2 = new ReducingBean().setName("A").setHeight(177);
        ReducingBean reducingBean3 = new ReducingBean().setName("B").setHeight(175);
        ReducingBean reducingBean4 = new ReducingBean().setName("B").setHeight(185);

        reducingBeanList.add(reducingBean);
        reducingBeanList.add(reducingBean2);
        reducingBeanList.add(reducingBean3);
        reducingBeanList.add(reducingBean4);

        Map<String, Optional<ReducingBean>> heightEstMap = reducingBeanList.stream()
                .collect(groupingBy(ReducingBean::getName,
                        reducing(BinaryOperator.maxBy(Comparator.comparing(ReducingBean::getHeight)))));
        heightEstMap.forEach((name, option) -> System.out.println(name + " heightest is :" + option.get() + " cm"));
    }


    @Data
    @Accessors(chain = true)
    static class ReducingBean {

        private String name;

        private int height;
    }
}
