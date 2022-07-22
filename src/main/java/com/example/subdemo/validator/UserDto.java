package com.example.subdemo.validator;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto {

    @Gender
    private String sex;

    @NotNull
    private String name;
}