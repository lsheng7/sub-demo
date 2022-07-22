//package com.example.subdemo.mbp.bean;
//
//import com.baomidou.mybatisplus.annotation.TableField;
//import com.baomidou.mybatisplus.annotation.TableName;
//import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
//import lombok.Data;
//import lombok.experimental.Accessors;
//
//
//@Data
//@Accessors(chain = true)
//@TableName(value = "area_back", autoResultMap = true)
//public class AreaPo2 {
//
//    private Integer id;
//
//    private String name;
//
//    private Integer age;
//
//    private String email;
//
//    @TableField(typeHandler = JacksonTypeHandler.class)
//    private Company company;
//
//    private String camelName;
//
//    @Data
//    public static class Company {
//
//        private String id;
//
//        private String name;
//    }
//}