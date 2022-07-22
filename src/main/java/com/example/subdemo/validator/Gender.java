package com.example.subdemo.validator;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 性别
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2021/11/23 13:27
 * @see Annotation
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
    ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = GenderValidator.class)
@Documented
public @interface Gender {

  String message() default "性别为男或者女";


  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}