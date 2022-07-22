package com.example.subdemo.pattern.template;

import lombok.Data;

@Data
public class ClinPlusEmpBo extends ClinPlusBo {

    private ClinPlusEmp data;

    @Data
    public static class ClinPlusEmp {

        private String empId;

        private String courseIds;

        private String userName;

        private String userId;

        private String roles;

        private String token;
    }

}
