package com.example.subdemo.impl;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import cn.hutool.json.JSONUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamGroupBy {

    public static void main(String[] args) {

        Form form = new Form().setCode("A");
        Visit visit = new Visit().setName("visit").setFormList(Collections.singletonList(form));

        Form form2 = new Form().setCode("B");
        Form form5 = new Form().setCode("F");
        Visit visit2 = new Visit().setName("visit2").setFormList(Arrays.asList(form2, form5));

        Form form3 = new Form().setCode("C");
        Visit visit3 = new Visit().setName("visit3").setFormList(Collections.singletonList(form3));

        Form form4 = new Form().setCode("D");
        Visit visit4 = new Visit().setName("visit4").setFormList(Collections.singletonList(form4));

        List<Visit> visitBeanList = new ArrayList<>();
        visitBeanList.add(visit);
        visitBeanList.add(visit2);
        Phase group = new Phase().setVisitBeanList(visitBeanList);

        List<Visit> visitList2 = new ArrayList<>();
        visitList2.add(visit3);
        visitList2.add(visit4);
        Phase group2 = new Phase().setVisitBeanList(visitList2);

        LinkedHashMap<String, Phase> groupMap = new LinkedHashMap<>();
        groupMap.put("group", group);
        groupMap.put("group2", group2);

        //process 数据处理
        //Map<String,List<String>>
        //{"visit":["A"],"visit2":["B","F"]}
        //{"visit4":["D"],"visit3":["C"]}

        groupMap.forEach((name, bean) -> {

            //two statement
            Map<String, Visit> collect = bean.getVisitBeanList().stream()
                    .collect(groupingBy(Visit::getName, TreeMap::new,
                            collectingAndThen(Collectors.toList(), value -> value.get(0))));
            Map<String, List<String>> formMap = new HashMap<>();
            collect.forEach((phase, v) -> formMap.put(v.getName(), v.getFormList().stream().map(Form::getCode).collect(Collectors.toList())));

            //TODO try one statement
            Map<String, List<Visit>> collect2 = bean.getVisitBeanList().stream()
                    .collect(groupingBy(Visit::getName));
            TreeMap<String, List<String>> collect3 = bean.getVisitBeanList().stream()
                    .collect(groupingBy(Visit::getName, TreeMap::new,
                            mapping(gb -> gb.getFormList().stream().map(Form::getCode).collect(joining()), toList())));
            TreeMap<String, List<List<String>>> collect4 = bean.getVisitBeanList().stream()
                    .collect(groupingBy(Visit::getName, TreeMap::new,
                            mapping(gb -> gb.getFormList().stream().map(Form::getCode).collect(toList()), toList())));
            TreeMap<String, List<List<String>>> collect5 = bean.getVisitBeanList().stream()
                    .collect(groupingBy(Visit::getName, TreeMap::new,
                            mapping(gb -> gb.getFormList().stream().map(Form::getCode).collect(Collectors.toCollection(ArrayList::new)), toList())));
            //TODO success
            Map<String, List<String>> collect6 = bean.getVisitBeanList().stream()
                    .collect(Collectors.toMap(Visit::getName, vs -> vs.getFormList().stream().map(Form::getCode).collect(toList())));
            log.info("{}", JSONUtil.toJsonStr(collect6));
        });
    }


    @Data
    @Accessors(chain = true)
    static class Phase {

        private List<Visit> visitBeanList;
    }

    @Data
    @Accessors(chain = true)
    static class Visit {

        private String name;

        private List<Form> formList;
    }

    @Data
    @Accessors(chain = true)
    static class Form {

        private String code;
    }
}
