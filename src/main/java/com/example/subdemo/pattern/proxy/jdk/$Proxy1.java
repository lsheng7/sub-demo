package com.example.subdemo.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

public final class $Proxy1 extends UserService2 {

    private static Method m1;

    private static Method m2;

    private static Method m3;

    private static Method m4;

    private static Method m0;

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m3 = Class.forName("com.example.subdemo.pattern.proxy.jdk.UserService2").getMethod("add");
            m4 = Class.forName("com.example.subdemo.pattern.proxy.jdk.UserService2").getMethod("say");
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
        } catch (NoSuchMethodException noSuchMethodException) {
            throw new NoSuchMethodError(noSuchMethodException.getMessage());
        } catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }

    private InvocationHandler h;

    public $Proxy1(InvocationHandler paramInvocationHandler) {
        h = paramInvocationHandler;
    }

    @Override
    public final boolean equals(Object paramObject) {
        try {
            return (Boolean) this.h.invoke(this, m1, new Object[]{paramObject});
        } catch (Error | RuntimeException error) {
            throw null;
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public final String toString() {
        try {
            return (String) this.h.invoke(this, m2, null);
        } catch (Error | RuntimeException error) {
            throw null;
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public final void add() {
        try {
            this.h.invoke(this, m3, null);
            return;
        } catch (Error | RuntimeException error) {
            throw null;
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public final String say() {
        try {
            return (String) this.h.invoke(this, m4, null);
        } catch (Error | RuntimeException error) {
            throw null;
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public final int hashCode() {
        try {
            return (Integer) this.h.invoke(this, m0, null);
        } catch (Error | RuntimeException error) {
            throw null;
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

}

