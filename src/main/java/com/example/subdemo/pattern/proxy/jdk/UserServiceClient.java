package com.example.subdemo.pattern.proxy.jdk;

public class UserServiceClient {

    public static void main(String[] args) {
        UserService2 userService = new $Proxy1(new JdkInvocationHandler(new UserService2()));
        userService.add();
    }
}
