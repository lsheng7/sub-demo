package com.example.subdemo.pattern.proxy.jdk;

import java.lang.reflect.Method;

public final class RealStar implements Star2, Star {

    public static void main(String[] args) throws Exception {
        RealStar realStar = new RealStar();
        Method subHashCode = realStar.getClass().getMethod("hashCode");
        System.out.println(subHashCode);
        int result = (int) subHashCode.invoke(realStar);
        System.out.println(result);
        System.out.println("------------------------------------------------------");
        Method parentHashCode = realStar.getClass().getSuperclass().getMethod("hashCode");
        System.out.println(parentHashCode);
        int result2 = (int) parentHashCode.invoke(realStar);
        System.out.println(result2);
    }

    @Override
    public void sing() {
        System.out.println("RealStar.sing()");
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode");
        return 0;
    }
}