package com.example.subdemo.spring.typefilter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> 目标是根据配置, 将符合条件的区域实现类从classpath全部扫进来.
 * <p> 我们就不在其上注解 @Component 来越疱代俎。
 * @author LQ
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Areaed {
	/**
	 * 所属区域
	 * @return
	 */
	String value();

	/**
	 * 描述性信息
	 * @return
	 */
	String description() default "";
}
