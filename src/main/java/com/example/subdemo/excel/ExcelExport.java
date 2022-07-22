package com.example.subdemo.excel;

import com.example.subdemo.excel.bean.Employee;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExport {

    public static void main(String[] args) throws Exception {
        //1.构造数据
        List<Employee> employeeList = new ArrayList<>();

        Employee employee = new Employee()
                .setUserId("1001")
                .setUsername("zhangsan")
                .setMobile("18890157191")
                .setTheHighestDegreeOfEducation("本科")
                .setNationalArea("中华人民共和国")
                .setPassportNo("10010001")
                .setNativePlace("江苏.昆山");

        employeeList.add(employee);

        //2.创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //3.构造sheet
        String[] titles = {"编号", "姓名", "手机", "最高学历", "国家地区", "护照号", "籍贯",
                "生日", "属相", "入职时间", "离职类型", "离职原因", "离职时间"};
        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        AtomicInteger headersAi = new AtomicInteger();
        for (String title : titles) {
            Cell cell = row.createCell(headersAi.getAndIncrement());
            cell.setCellValue(title);
        }
        AtomicInteger datasAi = new AtomicInteger(1);
        Cell cell;
        for (Employee emp : employeeList) {
            Row dataRow = sheet.createRow(datasAi.getAndIncrement());
            //编号
            cell = dataRow.createCell(0);
            cell.setCellValue(emp.getUserId());
            //姓名
            cell = dataRow.createCell(1);
            cell.setCellValue(emp.getUsername());
            //手机
            cell = dataRow.createCell(2);
            cell.setCellValue(emp.getMobile());
            //最高学历
            cell = dataRow.createCell(3);
            cell.setCellValue(emp.getTheHighestDegreeOfEducation());
            //国家地区
            cell = dataRow.createCell(4);
            cell.setCellValue(emp.getNationalArea());
            //护照号
            cell = dataRow.createCell(5);
            cell.setCellValue(emp.getPassportNo());
            //籍贯
            cell = dataRow.createCell(6);
            cell.setCellValue(emp.getNativePlace());
            //生日
            cell = dataRow.createCell(7);
            cell.setCellValue(emp.getBirthday());
//            //属相
//            cell = dataRow.createCell(8);
//            cell.setCellValue(emp.getZodiac());
//            //入职时间
//            cell = dataRow.createCell(9);
//            cell.setCellValue(emp.getTimeOfEntry());
//            //离职类型
//            cell = dataRow.createCell(10);
//            cell.setCellValue(emp.getTypeOfTurnover());
//            //离职原因
//            cell = dataRow.createCell(11);
//            cell.setCellValue(emp.getReasonsForLeaving());
//            //离职时间
//            cell = dataRow.createCell(12);
//            cell.setCellValue(emp.getResignationTime());
        }
//        String fileName = URLEncoder.encode(month + "人员信息.xlsx", "UTF-8");
//        response.setContentType("application/octet-stream");
//        response.setHeader("content-disposition", "attachment;filename=" + new
//                String(fileName.getBytes("ISO8859-1")));
//        response.setHeader("filename", fileName);
//        workbook.write(response.getOutputStream());

        workbook.write(new FileOutputStream("excel" + File.separator + "employee.xlsx"));
    }
}
