package com.example.subdemo.mbp.service;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.subdemo.mbp.bean.UserPo;
import com.example.subdemo.mbp.dynamic.MybatisPlusConfig;
import com.example.subdemo.mbp.mapper.UserMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void method() {
        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1);
        MybatisPlusConfig.setTable("t_user_0");
        UserPo userPo = userMapper.selectOne(queryWrapper);
        System.out.println(JSONUtil.toJsonStr(userPo));
    }

}
