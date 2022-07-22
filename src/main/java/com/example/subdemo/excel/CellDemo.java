package com.example.subdemo.excel;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CellDemo {

    public static void main(String[] args) throws Exception {
        //1. 创建workbook工作簿
        Workbook workbook = new XSSFWorkbook();
        //2. 创建表单Sheet
        Sheet sheet = workbook.createSheet("test");
        //3. 创建行对象 从0开始
        Row row = sheet.createRow(3);
        //4. 创建单元格 从0开始
        Cell cell = row.createCell(0);
        //5. 单元格写入数据
        //第4行第1列
        cell.setCellValue("第4行第1列单元格");
        //6. 文件流
        FileOutputStream fos = new FileOutputStream("excel" + File.separator + "test.xlsx");
        //7. 写入文件
        workbook.write(fos);
        workbook.close();
    }
}
