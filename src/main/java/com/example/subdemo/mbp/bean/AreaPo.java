package com.example.subdemo.mbp.bean;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@TableName(value = "area_po", autoResultMap = true)
public class AreaPo {

    @TableId(value = "id", type = AUTO)
    private Integer id;

    private String name = "浙江";

    private String description;
//
//    private Integer age;
//
//    private String email;

//    @TableField(typeHandler = JacksonTypeHandler.class)
//    private Company company;
//
//    private String camelName;
//
//    @TableLogic
//    private Boolean deleted;
//
//    @Data
//    public static class Company {
//
//        private String id;
//
//        private String name;
//    }
}