package com.example.subdemo.validator;

import cn.hutool.core.util.ObjectUtil;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 性别验证器
 *
 * @author lvsheng
 * @version 1.0.0
 * @date 2021/11/23 13:22
 * @see ConstraintValidator
 */
public class GenderValidator implements ConstraintValidator<Gender, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (ObjectUtil.isNull(value)) {
      return true;
    }
    return "m".equals(value) || "n".equals(value) || "f".equals(value);
  }
}