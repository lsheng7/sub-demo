package com.example.subdemo;

import com.example.subdemo.bean.People;
import com.example.subdemo.spring.injection.BeanDemo;
import com.example.subdemo.spring.typefilter.AreaSpringExcludeTypeFilter;
import com.example.subdemo.transactional.TsService;
import io.micrometer.core.instrument.MeterRegistry;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 演示应用程序
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2021/11/19 15:36
 */
@EnableScheduling
@Slf4j
@MapperScan("com.example.subdemo.mbp.mapper")
@ComponentScan(basePackages = {"com.example.subdemo", "com.github.yeecode.objectlogger"},
        excludeFilters = {@Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
                @Filter(type = FilterType.CUSTOM, classes = AreaSpringExcludeTypeFilter.class)})
@SpringBootApplication
public class SubDemoApplication implements ApplicationRunner {

//    @Resource
//    private AreaService areaService;
//
//    @Resource
//    private TsService tsService;
//
//    @Resource
//    private UserService userService;

    @Value("${yml.user.name}")
    private String userName;

    @Resource
    private TsService tsService;

    @Value("classpath:log4j2-001.xml")
    private InputStream inputStream;

    @Resource
    private BeanDemo beanDemo;

    /**
     * 主要
     *
     * @param args arg游戏
     * @author lvsheng
     * @date 2021/11/19 15:36
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SubDemoApplication.class, args);
//        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
        return (registry) -> registry.config().commonTags("application", applicationName);
    }

    @Bean
    @ConfigurationProperties(prefix = "people")
    public People people() {
        return new People();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println(userName);
//        areaService.method();
//        tsService.method();
//        userService.method();

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//        System.out.println("-----------log4j2-001.xml start-------------------");
//        String content;
//        while ((content = bufferedReader.readLine()) != null) {
//            System.out.println(content);
//        }
//        System.out.println("----------log4j2-001.xml end--------------------");
        beanDemo.method();
    }
}
