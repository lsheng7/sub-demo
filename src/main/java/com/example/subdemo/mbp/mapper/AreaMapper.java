package com.example.subdemo.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.subdemo.mbp.bean.AreaPo;
import com.example.subdemo.mbp.bean.Qc;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface AreaMapper extends BaseMapper<AreaPo> {

    void callProcedure();

//    List<Map<String, Object>> selectAreaPoByCompanyNameAndId();
//
//    List<Map<String,Object>> selectAreaList(@Param("nameList") List<String> nameList,@Param("qc") Qc qc,@Param("limit") Integer limit,@Param("offset") Integer offset);
}
