package com.example.subdemo.pattern.template;

import java.util.List;
import lombok.Data;

@Data
public class ClinPlusUserBo extends ClinPlusBo {

    private List<User> data;

    @Data
    public static class User {

        private String userId;

        private String userName;
    }
}
