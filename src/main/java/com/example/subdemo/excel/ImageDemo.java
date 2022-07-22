package com.example.subdemo.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Slf4j
public class ImageDemo {

    public static void main(String[] args) throws Exception {
        //1. 创建workbook工作簿
        Workbook workbook = new XSSFWorkbook();
        //2. 创建表单Sheet
        Sheet sheet = workbook.createSheet("test");
        //读取图片流
        String logo = "image" + File.separator + "logo.jpg";
        log.info(logo);
        log.info(File.separator);
        FileInputStream fis = new FileInputStream(logo);
        byte[] bytes = IOUtils.toByteArray(fis);
        //读取图片到二进制数组
        fis.read(bytes);
        //向Excel添加一张图片,并返回该图片在Excel中的图片集合中的下标
        int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
        //绘图工具类
        CreationHelper helper = workbook.getCreationHelper();
        //创建一个绘图对象
        Drawing<?> patriarch = sheet.createDrawingPatriarch();
        //创建锚点,设置图片坐标
        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(0);//从0开始
        anchor.setRow1(0);//从0开始
        //创建图片
        Picture picture = patriarch.createPicture(anchor, pictureIdx);
        picture.resize();
        //6. 文件流
        FileOutputStream fos = new FileOutputStream("excel" + File.separator + "test.xlsx");
        //7. 写入文件
        workbook.write(fos);
        workbook.close();
    }
}
