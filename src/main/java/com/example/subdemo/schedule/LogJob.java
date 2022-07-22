package com.example.subdemo.schedule;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LogJob {

    private Logger logger = LoggerFactory.getLogger(LogJob.class);

    @Resource
    private ObjectMapper objectMapper;

    @Scheduled(cron = "0/5 * * * * ?")
    public void job() {
        User user = new User();
        user.setName("小米粥");
        user.setAddress("中国.北京");
        try {
            logger.info("输出入参数:{}", objectMapper.writeValueAsString(user));
        } catch (JsonProcessingException exception) {
            logger.error("对象转json失败:{}", exception.getLocation());
        }
    }


    public static class User {

        private String name;

        private String address;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
