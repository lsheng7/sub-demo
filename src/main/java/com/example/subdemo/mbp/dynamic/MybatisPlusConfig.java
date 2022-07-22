package com.example.subdemo.mbp.dynamic;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    private static ThreadLocal<String> table = new ThreadLocal<>();

    public static void setTable(String tableName) {
        table.set(tableName);
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
        Map<String, TableNameHandler> map = new HashMap<>();
        map.put("t_user_account", (sql, tableName) -> table.get());
        //多个
        map.put("user_po", (sql, tableName) -> table.get());
        dynamicTableNameInnerInterceptor.setTableNameHandlerMap(map);
        mybatisPlusInterceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);
        return mybatisPlusInterceptor;
    }

}

