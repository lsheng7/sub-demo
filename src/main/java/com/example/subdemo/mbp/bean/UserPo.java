package com.example.subdemo.mbp.bean;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class UserPo {

//    @TableId(value = "id", type = AUTO)
    private Integer id;

    private String name;
}