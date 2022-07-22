package com.example.subdemo.object.log;

import com.github.yeecode.objectlogger.client.annotation.LogTag;
import com.github.yeecode.objectlogger.client.service.LogClient;
import javax.annotation.Resource;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logger")
public class ObjectLoggerController {

    @Resource
    private LogClient logClient;

    @RequestMapping
    public void log() {
        UserLog userLog = new UserLog()
                .setId("1")
                .setName("张三")
                .setAddress("上海");

        UserLog userLog2 = new UserLog()
                .setId("2")
                .setAddress("北京")
                .setName("李四");

        // Usage 3: Automatically analyze and record changes in object attributes
        logClient.logObject(
                "1",
                "Tom",
                "update",
                "Update a Task",
                null,
                null,
                userLog,
                userLog2);
    }

    @Data
    @Accessors(chain = true)
    public static class UserLog {
//
//        @LogTag(alias = "用户id")
        private String id;

        @LogTag(alias = "用户名称")
        private String name;

        @LogTag(alias = "用户地址")
        private String address;
    }
}
