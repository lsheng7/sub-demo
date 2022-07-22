package com.example.subdemo.generic;

public interface GenericService<E extends BaseDto,F extends BaseVo> {

    BaseVo method(BaseDto baseDto);
}
