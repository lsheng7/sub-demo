package com.example.subdemo.transactional;

import com.example.subdemo.mbp.mapper.AreaMapper;
import com.example.subdemo.mbp.service.AreaService;
import java.io.IOException;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TsServiceImpl implements TsService {


    @Resource
    private AreaService areaService;

    @Resource
    private AreaMapper areaMapper;

    @Override
//    @Transactional
    public void method() throws IOException {
//
//        AreaPo areaPo = new AreaPo()
//                .setName("zhangning");
//        areaMapper.insert(areaPo);
//        //调用存储过程
//        areaService.method();
////        int zero = 1 / 0;
//        areaMapper.insert(areaPo);
        //开启新的事务
        areaService.method2();
        System.out.println("----------------------");
    }
}
