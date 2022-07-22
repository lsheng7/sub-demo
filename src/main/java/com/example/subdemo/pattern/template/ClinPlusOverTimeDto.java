package com.example.subdemo.pattern.template;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ClinPlusOverTimeDto extends ClinPlusDto {

    /**
     * 加班开始时间例如：2020-02-01-是必填
     */
    private String beginTime;

    /**
     * 加班结束时间例如：2020-02-01-非必填
     */
    private String endTime;

    /**
     * 工号-非必填
     */
    private String empId;

    /**
     * 项目编码-非必填
     */
    private String projectCode;

    /**
     * 任务编码-非必填
     */
    private String taskCode;

    /**
     * 表单状态：Approved (通过)；Deleted (删除); Rejected (拒绝); Running (进行中)-非必填
     */
    private String state;
}
