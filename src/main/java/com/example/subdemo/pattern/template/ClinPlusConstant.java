package com.example.subdemo.pattern.template;

public interface ClinPlusConstant {

    /**
     * 工号
     */
    String EMP_ID = "otrial";

    /**
     * 密码
     */
    String PASSWORD = "1tRRRDisyB";

    /**
     * 接口调用成功标识
     */
    String SUCCESS_MSG = "success";

    /**
     * token
     */
    String HEADER_TOKEN = "token";

    /**
     * 发送请求时忽略字段
     */
    String[] IGNORE_FILEDS = {"url", "method", "mode"};

    /**
     * 获取用户认证的接口
     */
    String CLIN_PLUS_LOGIN_URL = "http://122.144.214.179:9001/smo-user/user/login";

    /**
     * 获取用户列表接口
     */
    String CLIN_PLUS_USER_LIST_URL = "http://122.144.214.179:9001/job-details/trial/user";

    /**
     * 获取工时的接口
     */
    String CLIN_PLUS_OVER_TIME_URL = "http://122.144.214.179:9001/job-details/trial/SmoOvertime";
}
