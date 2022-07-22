package com.example.subdemo.excel;

import cn.hutool.core.util.StrUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProtocolDemo {

    public static void main(String[] args) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        final int COLUMN_SIZE = 13;
        //方案前缀数据集合
        List<List<String>> prefixList = new ArrayList<>(5);

        //方案流程表
        List<String> sheetNameList = new ArrayList<>(COLUMN_SIZE);
        sheetNameList.add(0, "方案流程表");
        Stream.generate(() -> 1).limit(COLUMN_SIZE - 1).forEach(blank -> sheetNameList.add(StrUtil.EMPTY));
        prefixList.add(sheetNameList);

        //项目名称
        List<String> projectNameList = new ArrayList<>(COLUMN_SIZE);
        projectNameList.add(0, "项目名称");
        projectNameList.add("演示项目");
        Stream.generate(() -> 1).limit(COLUMN_SIZE - 2).forEach(blank -> projectNameList.add(StrUtil.EMPTY));
        prefixList.add(projectNameList);

        //方案名称及方案版本
        List<String> protocolInfoList = new ArrayList<>(COLUMN_SIZE);
        protocolInfoList.add(0, "方案名称");
        protocolInfoList.add(1, "模拟方案");
        Stream.generate(() -> 1).limit(COLUMN_SIZE - 2 - 2).forEach(blank -> protocolInfoList.add(StrUtil.EMPTY));
        protocolInfoList.add(COLUMN_SIZE - 2, "方案版本");
        protocolInfoList.add(COLUMN_SIZE - 1, "2021-12-14");
        prefixList.add(protocolInfoList);

        //header
        List<String> headerList = new ArrayList<>(COLUMN_SIZE);
        headerList.add("阶段");
        headerList.add("筛选期");
        headerList.add("治疗期");
        Stream.generate(() -> 1).limit(6).forEach(blank -> headerList.add(StrUtil.EMPTY));
        headerList.add("EOT");
        headerList.add("随访期");
        Stream.generate(() -> 1).limit(2).forEach(blank -> headerList.add(StrUtil.EMPTY));
        prefixList.add(headerList);

        //loop
        List<String> loopList = new ArrayList<>(COLUMN_SIZE);
        for (int loopIndex = 0; loopIndex < headerList.size(); loopIndex++) {
            if (loopIndex == 5) {
                loopList.add(loopIndex, "循环三次");
            } else if (loopIndex == 10) {
                loopList.add(loopIndex, "一直循环");
            } else {
                loopList.add(loopIndex, StrUtil.EMPTY);
            }
        }
        prefixList.add(loopList);

        Sheet sheet = workbook.createSheet();
        Row row;
        Cell cell;
        //加粗并居中对齐
        XSSFCellStyle boldAndCenterStyle = boldAndCenterStyle(workbook);
        //加粗并左对齐
        XSSFCellStyle boldAndLeftStyle = boldAndLeftStyle(workbook);
        for (int rowIndex = 0; rowIndex < prefixList.size(); rowIndex++) {
            row = sheet.createRow(rowIndex + 1);
            for (int cellIndex = 1; cellIndex < headerList.size() + 1; cellIndex++) {
                //创建单元格
                cell = row.createCell(cellIndex);
                if ((rowIndex == 1 || rowIndex == 2) && cellIndex == 2) {
                    //设置加粗左对齐
                    cell.setCellStyle(boldAndLeftStyle);
                } else {
                    //设置加粗居中对齐
                    cell.setCellStyle(boldAndCenterStyle);
                }
                //填充单元格数据
                cell.setCellValue(prefixList.get(rowIndex).get(cellIndex - 1));
            }
        }

        //合并sheet名称
        mergeSheetName(sheet);
        //合并项目名称
        mergeProjectName(sheet);
        //合并方案名称
        mergeProtocolName(sheet);
        //合并表头单元格合并
        mergeHeader(sheet);
        //合并循环
        mergeLoop(sheet);



        //数据
        List<List<String>> dataList = new ArrayList<>();
        //访视数据
        List<String> visitList = new ArrayList<>(COLUMN_SIZE);
        visitList.add("访视名称");
        visitList.add("V1");
        visitList.add("V2");
        visitList.add("V3A");
        visitList.add("V4A");
        visitList.add("V5");
        visitList.add("V6");
        visitList.add("V7");
        visitList.add("V8");

        visitList.add("EOT");
        visitList.add("S1");
        visitList.add("S2");
        visitList.add("S3");
        dataList.add(visitList);
        //项目\时间
        List<String> projectTimeList = new ArrayList<>(COLUMN_SIZE);
        projectTimeList.add(String.join(StrUtil.BACKSLASH, "项目", "时间"));
        //筛选期
        projectTimeList.add(String.join(StrUtil.LF, "D0", "(-0d,+28d)"));
        //治疗期
        projectTimeList.add(String.join(StrUtil.LF, "D28", "(-3d,+3d)"));
        projectTimeList.add(String.join(StrUtil.LF, "D56", "(-3d,+3d)"));
        projectTimeList.add(String.join(StrUtil.LF, "D84", "(-3d,+3d)"));
        projectTimeList.add(String.join(StrUtil.LF, "D112", "(-3d,+3d)"));
        projectTimeList.add(String.join(StrUtil.LF, "D140", "(-3d,+3d)"));
        projectTimeList.add(String.join(StrUtil.LF, "D168", "(-3d,+3d)"));
        projectTimeList.add(String.join(StrUtil.LF, "D364", "(-3d,+3d)"));
        //EOT
        projectTimeList.add(String.join(StrUtil.LF, "D392", "(-3d,+3d)"));
        //随访期
        projectTimeList.add(String.join(StrUtil.LF, "D482", "(-4d,+4d)"));
        projectTimeList.add(String.join(StrUtil.LF, "D510", "(-0d,+0d)"));
        projectTimeList.add(String.join(StrUtil.LF, "D540", "(-5d,+5d)"));
        dataList.add(projectTimeList);

        String yes = String.valueOf(((char) 8730));
        //知情同意书
        List<String> icfList = new ArrayList<>(COLUMN_SIZE);
        icfList.add("知情同意书");
        icfList.add(yes);
        Stream.generate(() -> 1).limit(visitList.size() - 2).forEach(blank -> icfList.add(StrUtil.EMPTY));
        dataList.add(icfList);

        //血常规
        List<String> bloodList = new ArrayList<>(COLUMN_SIZE);
        bloodList.add("血常规");
        bloodList.add(StrUtil.EMPTY);
        Stream.generate(() -> 1).limit(visitList.size() - 2).skip(2).forEach(blank -> bloodList.add(yes));
        bloodList.add(StrUtil.EMPTY);
        bloodList.add(yes);
        dataList.add(bloodList);

        XSSFCellStyle contentStyle = contentStyle(workbook);
        for (int rowIndex = 4; rowIndex < 4 + dataList.size(); rowIndex++) {
            row = sheet.createRow(rowIndex + 2);
            List<String> cellList = dataList.get(rowIndex - 4);

            for (int cellIndex = 1; cellIndex < cellList.size() + 1; cellIndex++) {
                cell = row.createCell(cellIndex);
                cell.setCellStyle(contentStyle);
                cell.setCellValue(cellList.get(cellIndex - 1));
            }
        }

        try (FileOutputStream out = new FileOutputStream("excel" + File.separator + "protocol.xlsx")) {
            workbook.write(out);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 加粗并左对齐
     *
     * @return {@link XSSFCellStyle }
     * @author lvsheng
     * @date 2021/12/14 15:28
     */
    private static XSSFCellStyle boldAndLeftStyle(XSSFWorkbook wb) {
        XSSFCellStyle cellStyle = wb.createCellStyle();
        //设置自动换行
        cellStyle.setWrapText(true);
        //背景颜色
        cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        //水平居中
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        //垂直对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        //设置边框颜色
        cellStyle.setTopBorderColor(IndexedColors.BLACK.index);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.index);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.index);

        //设置边框样式
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);

        // 创建字体样式
        XSSFFont xssfFont = wb.createFont();
        //字体加粗
        xssfFont.setBold(true);
        // 设置字体类型
        xssfFont.setFontName("黑体");
        // 设置字体大小
        xssfFont.setFontHeightInPoints((short) 10);
        // 为标题样式设置字体样式
        cellStyle.setFont(xssfFont);
        return cellStyle;
    }


    /**
     * 加粗并居中对齐
     *
     * @return {@link XSSFCellStyle }
     * @author lvsheng
     * @date 2021/12/14 15:28
     */
    private static XSSFCellStyle boldAndCenterStyle(XSSFWorkbook wb) {
        XSSFCellStyle cellStyle = wb.createCellStyle();
        //设置自动换行
        cellStyle.setWrapText(true);
        //背景颜色
        cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        //水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //垂直对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        //设置边框颜色
        cellStyle.setTopBorderColor(IndexedColors.BLACK.index);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.index);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.index);

        //设置边框样式
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);

        // 创建字体样式
        XSSFFont xssfFont = wb.createFont();
        //字体加粗
        xssfFont.setBold(true);
        // 设置字体类型
        xssfFont.setFontName("黑体");
        // 设置字体大小
        xssfFont.setFontHeightInPoints((short) 10);
        // 为标题样式设置字体样式
        cellStyle.setFont(xssfFont);
        return cellStyle;
    }

    /**
     * 标题样式
     *
     * @return {@link XSSFCellStyle }
     * @author lvsheng
     * @date 2021/12/14 15:28
     */
    private static XSSFCellStyle contentStyle(XSSFWorkbook wb) {
        XSSFCellStyle cellStyle = wb.createCellStyle();
        //垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置自动换行
        cellStyle.setWrapText(true);
        //下边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        //左边框
        cellStyle.setBorderLeft(BorderStyle.THIN);
        //右边框
        cellStyle.setBorderRight(BorderStyle.THIN);
        //上边框
        cellStyle.setBorderTop(BorderStyle.THIN);
        //生成12号字体
        XSSFFont font = wb.createFont();
        font.setColor((short) 8);
        font.setFontHeightInPoints((short) 10);
        cellStyle.setFont(font);
        return cellStyle;
    }

    /**
     * 合并表单名称
     *
     * @return {@link Sheet }
     * @author lvsheng
     * @date 2021/12/14 16:35
     */
    private static Sheet mergeSheetName(Sheet sheet) {
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 13));
        return sheet;
    }

    /**
     * 合并项目名称
     *
     * @return {@link Sheet }
     * @author lvsheng
     * @date 2021/12/14 16:35
     */
    private static Sheet mergeProjectName(Sheet sheet) {
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 2, 13));
        return sheet;
    }


    /**
     * 合并方案名称
     *
     * @return {@link Sheet }
     * @author lvsheng
     * @date 2021/12/14 16:35
     */
    private static Sheet mergeProtocolName(Sheet sheet) {
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 2, 11));
        return sheet;
    }

    /**
     * 合并表头
     *
     * @return {@link Sheet }
     * @author lvsheng
     * @date 2021/12/14 16:35
     */
    private static Sheet mergeHeader(Sheet sheet) {
        //阶段
        sheet.addMergedRegion(new CellRangeAddress(4, 5, 1, 1));
        //筛选期
        sheet.addMergedRegion(new CellRangeAddress(4, 5, 2, 2));
        //治疗期
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 3, 8));
        //EOT
        sheet.addMergedRegion(new CellRangeAddress(4, 5, 10, 10));
        //随访期
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 11, 13));
        return sheet;
    }

    /**
     * 合并循环
     *
     * @param sheet 表
     * @return {@link Sheet }
     * @author lvsheng
     * @date 2021/12/14 16:35
     */
    private static Sheet mergeLoop(Sheet sheet) {
        //合并治疗期循环
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 6, 8));
        //合并随访期循环
        sheet.addMergedRegion(new CellRangeAddress(5, 5, 11, 13));
        return sheet;
    }

}
