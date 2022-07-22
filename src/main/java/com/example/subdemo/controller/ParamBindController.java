package com.example.subdemo.controller;

import cn.hutool.core.util.StrUtil;
import com.example.subdemo.controller.ParamBindController.UserDto;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
@SessionAttributes(types = {UserDto.class}, value = "userDto")
@RequestMapping("/param")
public class ParamBindController {

    /**
     * 响应
     */
    @Resource
    private HttpServletResponse response;

    /**
     * 请求
     */
    @Resource
    private HttpServletRequest request;

//    /**
//     * 预请求:
//     *
//     * 被@ModelAttribute注释的方法会在这个控制器每个方法执行前被执行
//     *
//     * @author lvsheng
//     * @date 2022/03/08 15:54
//     */
//    @ModelAttribute
//    public void preRequest() {
//        preRequestForRequestAttribute();
//        preRequestForSessionAttribute();
//    }


    /***
     * 预请求-cookie值
     *
     * @author lvsheng
     * @date 2022/03/08 10:56
     */
    @ResponseBody
    @GetMapping("/pre-request/cookie-value")
    public void preRequestForCookieValue() {
        Cookie cookie = new Cookie("username", "lvsheng");
        response.addCookie(cookie);
    }

    /**
     * 预请求-request-attribute请求转发
     *
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 14:32
     */
    @GetMapping("/pre-request/request-attribute")
    public String preRequestForRequestAttribute() {
        //设置服务端系统属性参数
        request.setAttribute("username", "小麻花");
        return "forward:/param/request-attribute";
    }

    /**
     * 预请求-session-attribute请求转发
     *
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 14:32
     */
    @GetMapping("/pre-request/session-attribute")
    public String preRequestForSessionAttribute() {
        //设置session属性
        HttpSession session = request.getSession();
        session.setAttribute("age", 100);
        return "forward:/param/session-attribute";
    }

    /***
     * cookie值
     * Since:
     * 3.0
     *
     * 操作步骤:
     *
     * STEP1: http://localhost:8041/param/pre-request/cookie-value
     * STEP2: http://localhost:8041/param/cookie-value
     *
     * @param username 用户名称
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 10:56
     */
    @ResponseBody
    @GetMapping("/cookie-value")
    public String cookieValue(@CookieValue(value = "username", defaultValue = "xmz") String username) {
        return "username=" + username;
    }


    /***
     * 矩阵变量-单个属性接收
     *
     * Spring 3.2就已经支持@MatrixVariable特性，但直至现在其依然为默认禁用的状态
     * 是为了增强URL请求地址的功能 需要配置removeSemicolonContent属性值为false才生效
     * com.compass.msg.web.core.config.MatrixVariableConfig#configurePathMatch(org.springframework.web.servlet.config.annotation.PathMatchConfigurer)
     *
     * 用法: ;是用来分割变量的 ,是用来分割多个值的(多个值也可以使用多个相同的变量命名)
     *
     * 测试:
     * http://localhost:8041/param/matrix-variable/attribute/username=lvsheng;age=100
     *
     * @param username 用户名
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 11:05
     */
    @ResponseBody
    @GetMapping("/matrix-variable/attribute/{variable}")
    public String matrixVariableAttribute(@MatrixVariable(value = "username", defaultValue = "xmz") String username,
            @MatrixVariable("age") Integer age) {
        return "username=" + username + ";age=" + age;
    }

    /***
     * 矩阵变量-Map接收
     *
     * 测试:
     * http://localhost:8041/param/matrix-variable/attribute/username=lvsheng;age=100
     *
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 13:46
     */
    @ResponseBody
    @GetMapping("/matrix-variable/map/{variable}")
    public String matrixVariableMap(@MatrixVariable Map<String, Object> map) {
        return "username=" + map.get("username") + ";age=" + map.get("age");
    }

    /***
     * 矩阵变量-List接收
     *
     * 测试:
     * http://localhost:8041/param/matrix-variable/list/address=上海,苏州,昆山
     * http://localhost:8041/param/matrix-variable/list/address=上海;address=苏州;address=昆山
     *
     * @param addressList 地址列表
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 13:24
     */
    @ResponseBody
    @GetMapping("/matrix-variable/list/{variable}")
    public String matrixVariableList(@MatrixVariable("address") List<String> addressList) {
        return String.join(StrUtil.COMMA, addressList);
    }

    /***
     * 矩阵变量-数组接收
     *
     * 测试:
     * http://localhost:8041/param/matrix-variable/arr/address=上海,苏州,昆山
     * http://localhost:8041/param/matrix-variable/arr/address=上海;address=苏州;address=昆山
     *
     * @param addressArr 地址数组
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 13:24
     */
    @ResponseBody
    @GetMapping("/matrix-variable/arr/{variable}")
    public String matrixVariableArr(@MatrixVariable("address") String[] addressArr) {
        return String.join(StrUtil.COMMA, addressArr);
    }

    /***
     * 矩阵变量的路径PathVariable及MatrixVariable搭配使用
     *
     * 测试:
     * http://localhost:8041/param/matrix-variable/path/lvsheng;address=上海
     *
     * @param username 用户名
     * @param address 地址
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 13:40
     */
    @ResponseBody
    @GetMapping("/matrix-variable/path/{username}")
    public String matrixVariablePath(@PathVariable("username") String username, @MatrixVariable("address") String address) {
        return "username=" + username + ";address=" + address;
    }


    /***
     * 模型属性
     * Since:
     * 2.5
     *
     * 测试:
     * http://localhost:8041/param/model-attribute?username=lvsheng&age=100&address=山海
     *
     * @param userDto 用户
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 14:00
     */
    @ResponseBody
    @GetMapping("/model-attribute")
    public String modelAttribute(@ModelAttribute UserDto userDto) {
        return "username=" + userDto.getUsername() + ";age=" + userDto.getAge() + ";address=" + userDto.getAddress();
    }


    /***
     * 路径变量
     * Since:
     * 3.0
     * 测试:
     * http://localhost:8041/param/path-variable/你好
     *
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 14:02
     */
    @ResponseBody
    @GetMapping("/path-variable/{info}")
    public String pathVariable(@PathVariable String info) {
        return info;
    }

    /***
     * 请求属性 Since: 4.3
     *
     * 接收服务端设置的属性值 并非客户端(前端传递)的属性值-@RequestParam等其他注解均是客户端参数
     *
     * 测试:
     * WAY1: http://localhost:8041/param/pre-request/request-attribute(请求转发)
     *
     * WAY2: http://localhost:8041/param/request-attribute (拦截器操作)
     *
     * WAY3: 将preRequest注释代码打开(@ModelAttribute预存值)
     *
     * @param username 用户名
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 14:04
     */
    @ResponseBody
    @GetMapping("/request-attribute")
    public String requestAttribute(@RequestAttribute(required = false) String username) {
        return "username=" + username;
    }


    /***
     *
     * 请求体
     *
     * Since:
     * 3.0
     *
     * 测试:
     *
     * curl --location --request GET 'http://localhost:8041/param/request-body' \
     * --header 'Content-Type: application/json' \
     * --header 'Cookie: username=lvsheng' \
     * --data-raw '{
     *     "username": "吕升",
     *     "age": 100,
     *     "address": "上海"
     * }'
     *
     * @param userDto 用户
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 14:50
     */
    @ResponseBody
    @GetMapping("/request-body")
    public String requestBody(@RequestBody UserDto userDto) {
        return userDto.toString();
    }

    /***
     * 请求头
     * Since:
     * 3.0
     *
     * 测试:
     *
     * curl --location --request GET 'http://localhost:8041/param/request-header' \
     * --header 'username: zhangsan' \
     * --header 'Cookie: username=lvsheng'
     *
     * @param username 用户名
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 14:52
     */
    @ResponseBody
    @GetMapping("/request-header")
    public String requestHeader(@RequestHeader String username) {
        return "username=" + username;
    }

    /***
     * 请求参数
     * Since:
     * 2.5
     *
     * 测试:
     *
     * http://localhost:8041/param/request-param?username=lvsheng
     *
     * @param username 用户名
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 14:53
     */
    @ResponseBody
    @GetMapping("/request-param")
    public String requestParam(@RequestParam String username) {
        return "username=" + username;
    }

    /***
     * 请求的一部分
     * Since:
     * 3.1
     *
     * 测试: curl --location --request GET 'http://localhost:8041/param/request-part' \ --header 'Cookie: username=lvsheng;
     * JSESSIONID=AE346BDC6BB4211C14CBF6A7F84D5B58' \ --form 'upload=@"/C:/Users/sheng.lv/AppData/Local/Postman/app-8.12.4/Squirrel-UpdateSelf.log"'
     *
     * @param multipartFile 文件
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 15:07
     */
    @ResponseBody
    @GetMapping("/request-part")
    public String requestPart(@RequestPart("upload") MultipartFile multipartFile) {
        return multipartFile.getOriginalFilename();
    }

    /***
     * 会话属性
     * Since:
     * 4.3
     *
     * 测试:
     *
     * WAY1: http://localhost:8041/param/pre-request/session-attribute(请求转发)
     *
     * WAY2: http://localhost:8041/param/session-attribute(拦截器)
     *
     * WAY3: 将preRequest注释代码打开(@ModelAttribute预存值)
     *
     * @param age 年龄
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/08 15:06
     */
    @ResponseBody
    @GetMapping("/session-attribute")
    public String sessionAttribute(@SessionAttribute Integer age) {
        return "age=" + age;
    }

    /**
     * 会话属性 需要结合@SessionAttributes注解使用 该注解是作用于类上的
     *
     * @param model 模型
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/09 09:09
     */
    @GetMapping("/session-attributes")
    public String sessionAttributes(Model model) {
        UserDto userDto = new UserDto()
                .setUsername("吕升")
                .setAge(100)
                .setAddress("上海");

        // 这步操作结合+@SessionAttributes(types = {UserDto.class}, value = "userDto")会将userDto放置到
        // HttpSession中
        model.addAttribute("userDto", userDto);
        return "forward:/param/session-attributes/get";
    }

    /**
     * 获取会话属性
     *
     * @param userDto 用户请求实体
     * @return {@link String }
     * @author lvsheng
     * @date 2022/03/09 09:09
     */
    @ResponseBody
    @GetMapping("/session-attributes/get")
    public String getSessionAttribute(@SessionAttribute UserDto userDto) {
        return userDto.toString();
    }


    @Data
    @Accessors(chain = true)
    public static class UserDto {

        private String username;

        private Integer age;

        private String address;
    }

}
