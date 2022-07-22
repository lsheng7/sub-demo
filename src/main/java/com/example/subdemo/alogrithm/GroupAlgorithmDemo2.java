package com.example.subdemo.alogrithm;

import cn.hutool.core.util.StrUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

//数据格式(json):

//{
//        "G1": [
//        {
//        "groupName": "A",
//        "name": "1"
//        },
//        {
//        "groupName": "A",
//        "name": "2"
//        }
//        ],
//        "G2": [
//        {
//        "groupName": null,
//        "name": "3"
//        },
//        {
//        "groupName": "B",
//        "name": "4"
//        },
//        {
//        "groupName": "B",
//        "name": "5"
//        }
//        ]
//        }

//要求: 返回每个分组的元素起始索引位置
//注意: "A"和"B"不是固定值

//结果:
//[1,2] 第1位至第2位
//[4,5] 第4位至第5位

@Slf4j
public class GroupAlgorithmDemo2 {

    public static void main(String[] args) {
//
//        Map<String, List<GroupData>> groupDataMap = new HashMap<>();
//
//        List<GroupData> g1DataList = new ArrayList<>();
//        g1DataList.add(new GroupData().setName("1").setGroupName("A"));
//        g1DataList.add(new GroupData().setName("2").setGroupName("A"));
//        groupDataMap.put("G1", g1DataList);
//
//        List<GroupData> g2DataList = new ArrayList<>();
//        g2DataList.add(new GroupData().setName("3"));
//        g2DataList.add(new GroupData().setName("4").setGroupName("B"));
//        g2DataList.add(new GroupData().setName("5").setGroupName("B"));
//        g2DataList.add(new GroupData().setName("5"));
//        g2DataList.add(new GroupData().setName("5").setGroupName("C"));
//        g2DataList.add(new GroupData().setName("5").setGroupName("D"));
//        groupDataMap.put("G2", g2DataList);

        Map<String, List<GroupAlgorithmDemo1.GroupData>> groupDataMap = new HashMap<>();

        List<GroupAlgorithmDemo1.GroupData> g1DataList = new ArrayList<>();
        g1DataList.add(new GroupAlgorithmDemo1.GroupData().setName("1").setGroupName("A"));
        g1DataList.add(new GroupAlgorithmDemo1.GroupData().setName("2").setGroupName("A"));
        g1DataList.add(new GroupAlgorithmDemo1.GroupData().setName("7"));
        groupDataMap.put("G1", g1DataList);

        List<GroupAlgorithmDemo1.GroupData> g2DataList = new ArrayList<>();
//        g2DataList.add(new GroupData().setName("3"));
        g2DataList.add(new GroupAlgorithmDemo1.GroupData().setName("4").setGroupName("B"));
        g2DataList.add(new GroupAlgorithmDemo1.GroupData().setName("5").setGroupName("B"));
        g2DataList.add(new GroupAlgorithmDemo1.GroupData().setName("6").setGroupName("C"));
        g2DataList.add(new GroupAlgorithmDemo1.GroupData().setName("9"));
        groupDataMap.put("G2", g2DataList);

        //索引计数器
        AtomicInteger indexCounter = new AtomicInteger();
        //key是起始位置 value是结束位置
        Map<String, int[]> indexMap = new HashMap<>();

        groupDataMap.forEach((g, dataList) -> {

            dataList.forEach(data -> {
                indexCounter.incrementAndGet();
                String groupName = data.getGroupName();
                if (StrUtil.isNotBlank(groupName)) {
                    if (!indexMap.containsKey(groupName)) {
                        //设置节点的startIndex
                        int[] ints = new int[2];
                        ints[0] = indexCounter.intValue();
                        indexMap.put(groupName, ints);
                    } else {
                        int[] ints = indexMap.get(groupName);
                        ints[1] = indexCounter.intValue();
                    }
                }
            });

        });

        indexMap.forEach((s, ints) -> {
            System.out.println(s + ":[" + ints[0] + "," + ints[1] + "]");
        });
    }


    /**
     * 获取最后一个节点元素
     *
     * @param map 地图
     * @return {@link Integer }
     * @author lvsheng
     * @date 2021/12/17 10:25
     */
    public static Object getTailKeyByReflection(LinkedHashMap map) {
        try {
            Field tail = map.getClass().getDeclaredField("tail");
            tail.setAccessible(true);
            return ((Map.Entry) tail.get(map)).getKey();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Data
    @Accessors(chain = true)
    static class GroupData {

        private String name;

        private String groupName;
    }
}


