package com.example.subdemo.pattern.template;

import java.util.List;
import lombok.Data;

@Data
public class ClinPlusOverTimeBo extends ClinPlusBo {

    private List<ClinPlusOverTime> data;

    @Data
    public static class ClinPlusOverTime {

        /**
         * 员工姓名
         */
        private String name;

        /**
         * 随访医院名称
         */
        private String hospital;

        /**
         * 任务编号
         */
        private String taskCode;

        /**
         * 加班时间单位小时
         */
        private String overTime;

        /**
         * 工作区域
         */
        private String workArea;

        /**
         * 工作日期
         */
        private String workDate;

        /**
         * 项目编号
         */
        private String projectCode;

        /**
         * 表单状态： Approved (通过)；Deleted (删除); Rejected (拒绝); Running (进行中)
         */
        private String state;

        /**
         * 加班类型
         */
        private String overtimeType;
    }
}
