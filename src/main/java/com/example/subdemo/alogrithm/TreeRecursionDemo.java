package com.example.subdemo.alogrithm;

import cn.hutool.json.JSONUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.experimental.Accessors;

public class TreeRecursionDemo {


    public static void main(String[] args) {

        Department dept1 = new Department().setId("1").setName("A");
        Department dept2 = new Department().setId("2").setName("B").setParentId("1");
        Department dept3 = new Department().setId("3").setName("C").setParentId("1");
        Department dept4 = new Department().setId("4").setName("D").setParentId("2");
        Department dept5 = new Department().setId("5").setName("E").setParentId("3");
        Department dept6 = new Department().setId("6").setName("F").setParentId("4");


        List<Department> departmentList = new ArrayList<>();
        departmentList.add(dept1);
        departmentList.add(dept4);
        departmentList.add(dept5);
        departmentList.add(dept6);
        departmentList.add(dept2);
        departmentList.add(dept3);

        departmentList.stream().filter(department -> department.getParentId() == null)
                .forEach(department -> {
                    //都是顶级节点
                    List<Department> resultList = recursion(department.getId(), departmentList);
                    department.setChildren(resultList);
                    System.out.println(JSONUtil.toJsonStr(department));
                });
    }

    private static List<Department> recursion(String id, List<Department> departmentList) {
        List<Department> resultList = new ArrayList<>();
        for (Department dept : departmentList) {
            if (Objects.equals(id, dept.getParentId())) {
                resultList.add(dept);
                dept.setChildren(recursion(dept.getId(), departmentList));
            }
        }
        return resultList;
    }


    @Data
    @Accessors(chain = true)
    static class Department {

        private String id;
        private String name;
        private String parentId;
        private List<Department> children;
    }
}
