package com.example.subdemo.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValueConfig {

    @Bean
    public DogBean dogBean() {
        return new DogBean();
    }

    @Bean
    public UserBean userBean(@Value("#{@dogBean.listSpecific()}") List<String> dogSpecifics) {
        System.out.println(dogSpecifics);
        return new UserBean();
    }

    public static class UserBean {

    }

    public static class DogBean {

        public List<String> listSpecific() {
            return Arrays.asList("聪明", "忠诚");
        }
    }

}
