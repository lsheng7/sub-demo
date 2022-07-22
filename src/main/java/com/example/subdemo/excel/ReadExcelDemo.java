package com.example.subdemo.excel;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo {

    public static void main(String[] args) throws Exception {
        //1. 创建workbook工作簿
        Workbook workbook = new XSSFWorkbook("excel" + File.separator + "demo.xlsx");
        //2. 创建表单Sheet
        Sheet sheet = workbook.getSheetAt(0);
        //获取文件的行数
        int lastRowNum = sheet.getLastRowNum();
        Row row;
        Cell cell;
        //循环遍历所有的行
        for (int rowNum = 0; rowNum <= lastRowNum; rowNum++) {
            row = sheet.getRow(rowNum);
            StringBuilder builder = new StringBuilder();
            //POI的列数是正确的 但是行数会从0开始
            for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
                cell = row.getCell(cellNum);
                builder.append(getValue(cell)).append("-");
            }
            System.out.println(builder);
        }

        //6. 文件流
        FileOutputStream fos = new FileOutputStream("excel" + File.separator + "test.xlsx");
        //7. 写入文件
        workbook.write(fos);
        workbook.close();
    }

    //获取数据
    private static Object getValue(Cell cell) {
        Object value = null;
        switch (cell.getCellType()) {
            case STRING: //字符串类型
                value = cell.getStringCellValue();
                break;
            case BOOLEAN: //boolean类型
                value = cell.getBooleanCellValue();
                break;
            case NUMERIC: //数字类型（包含日期和普通数字）
                if (DateUtil.isCellDateFormatted(cell)) {
                    value = cell.getDateCellValue();
                } else {
                    value = cell.getNumericCellValue();
                }
                break;
            case FORMULA: //公式类型
                value = cell.getCellFormula();
                break;
            default:
                break;
        }
        return value;
    }

}
