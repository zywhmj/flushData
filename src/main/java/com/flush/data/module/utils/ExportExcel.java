package com.flush.data.module.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;


/**
 * excel导出大数据工具类
 * @author zyw
 * @date
 */

public class ExportExcel {

    /**
     * 导出excel
     *
     * @param response
     *            HttpServletResponse
     * @param list
     *            导出数据集合
     * @param lables
     *            表头数组
     * @param fields
     *            key数组
     * @param title
     *            文件名
     */
    public static void export(HttpServletResponse response,List<Map<String, Object>> list,String[] lables,String[] fields,String title) {
        response.setContentType("application/octet-stream");//告诉浏览器输出内容为流
        String filename = "";
        try {
            filename = new String(title.getBytes("UTF-8"), "ISO_8859_1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        response.setHeader("Content-Disposition","attachment;filename=" + filename);
        OutputStream os = null;
        SXSSFWorkbook sxssfWorkbook = null;
        try {
            // 获取SXSSFWorkbook
            sxssfWorkbook = new SXSSFWorkbook();
            Sheet sheet = sxssfWorkbook.createSheet("Sheet1");
            // 冻结第一行
            sheet.createFreezePane(0, 1);
            // 创建第一行,作为header表头
            Row header = sheet.createRow(0);
            // 循环创建header单元格
            for (int cellnum = 0; cellnum < lables.length; cellnum++) {
                Cell cell = header.createCell(cellnum);
                //cell.setCellStyle(getAndSetXSSFCellStyleHeader(sxssfWorkbook));//设置表头单元格样式,根据需要设置
                cell.setCellValue(lables[cellnum]);
                //设置每列固定宽度
                sheet.setColumnWidth(cellnum, 20 * 256);
            }
            // 遍历创建行,导出数据
            for (int rownum = 1; rownum <= list.size(); rownum++) {
                Row row = sheet.createRow(rownum);
                Map<String, Object> map = list.get(rownum-1);
                // 循环创建单元格
                for (int cellnum = 0; cellnum < fields.length; cellnum++) {
                    Cell cell = row.createCell(cellnum);
                    //cell.setCellStyle(getAndSetXSSFCellStyleOne(sxssfWorkbook));//设置数据行单元格样式,根据需要设置
                    cell.setCellValue(map.get(fields[cellnum]) == null ? "" : map.get(fields[cellnum]).toString());
                }
            }
            //自定义各列宽度
            //setSheet(sheet);
            os = response.getOutputStream();
            sxssfWorkbook.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(sxssfWorkbook != null) {
                    //处理SXSSFWorkbook导出excel时，产生的临时文件
                    sxssfWorkbook.dispose();
                }
                if(os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 导出excel带标题
     *
     * @param response
     *            HttpServletResponse
     * @param list
     *            导出数据集合
     * @param lables
     *            表头数组
     * @param fields
     *            key数组
     * @param title
     *            文件名
     * @param headTitle
     *            文件标题
     */
    public static void titleExport(HttpServletResponse response,List<Map<String, Object>> list,String[] lables,String[] fields,String title,String headTitle) {
        response.setContentType("application/octet-stream");//告诉浏览器输出内容为流
        String filename = "";
        try {
            filename = new String(title.getBytes("UTF-8"), "ISO_8859_1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        response.setHeader("Content-Disposition","attachment;filename=" + filename);
        OutputStream os = null;
        SXSSFWorkbook sxssfWorkbook = null;
        try {
            // 获取SXSSFWorkbook
            sxssfWorkbook = new SXSSFWorkbook();
            Sheet sheet = sxssfWorkbook.createSheet("Sheet1");
            // 创建第一行,作为标题
            Row headline = sheet.createRow(0);
            Cell c = headline.createCell(0);
            //设置居中
            XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
            xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
            c.setCellStyle(xssfCellStyle);
            c.setCellValue(headTitle);
            sheet.addMergedRegion(new CellRangeAddress(0,0,0,lables.length-1));//合并单元格(起始行号,终止行号,起始列号,终止列号)
            // 冻结第二行
            sheet.createFreezePane(0, 2);
            // 创建第二行,作为header表头
            Row header = sheet.createRow(1);
            // 循环创建header单元格
            for (int cellnum = 0; cellnum < lables.length; cellnum++) {
                Cell cell = header.createCell(cellnum);
                //cell.setCellStyle(getAndSetXSSFCellStyleHeader(sxssfWorkbook));//设置表头单元格样式,根据需要设置
                cell.setCellValue(lables[cellnum]);
                //设置每列固定宽度
                sheet.setColumnWidth(cellnum, 10 * 256);
            }
            // 遍历创建行,导出数据
            for (int rownum = 1; rownum <= list.size(); rownum++) {
                Row row = sheet.createRow(rownum+1);
                Map<String, Object> map = list.get(rownum-1);
                // 循环创建单元格
                for (int cellnum = 0; cellnum < fields.length; cellnum++) {
                    Cell cell = row.createCell(cellnum);
                    //cell.setCellStyle(getAndSetXSSFCellStyleOne(sxssfWorkbook));//设置数据行单元格样式,根据需要设置
                    cell.setCellValue(map.get(fields[cellnum]) == null ? "" : map.get(fields[cellnum]).toString());
                }
            }
            //自定义各列宽度
            //setSheet(sheet);
            os = response.getOutputStream();
            sxssfWorkbook.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(sxssfWorkbook != null) {
                    //处理SXSSFWorkbook导出excel时，产生的临时文件
                    sxssfWorkbook.dispose();
                }
                if(os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 导出excel(多个工作薄)
     *
     * @param response
     *            HttpServletResponse
     * @param datas
     *            导出数据集合
     * @param title
     *            文件名
     */
    public static void exportSheets(HttpServletResponse response,List<Map<String, Object>> datas,String title) {
        response.setContentType("application/octet-stream");//告诉浏览器输出内容为流
        String filename = "";
        try {
            filename = new String(title.getBytes("UTF-8"), "ISO_8859_1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        response.setHeader("Content-Disposition","attachment;filename=" + filename);
        OutputStream os = null;
        SXSSFWorkbook sxssfWorkbook = null;
        try {
            // 获取SXSSFWorkbook
            sxssfWorkbook = new SXSSFWorkbook();
            // 根据集合的数量创建sheet
            for(int i=0; i<datas.size(); i++){
                Sheet sheet = sxssfWorkbook.createSheet("Sheet"+(i+1));
                // 冻结第一行
                sheet.createFreezePane(0, 1);
                // 创建第一行,作为header表头
                Row header = sheet.createRow(0);
                // 循环创建header单元格
                String[] lables = (String[]) datas.get(i).get("lables");
                String[] fields = (String[]) datas.get(i).get("fields");
                for (int cellnum = 0; cellnum < lables.length; cellnum++) {
                    Cell cell = header.createCell(cellnum);
                    //cell.setCellStyle(getAndSetXSSFCellStyleHeader(sxssfWorkbook));//设置表头单元格样式,根据需要设置
                    cell.setCellValue(lables[cellnum]);
                    //设置每列固定宽度
                    sheet.setColumnWidth(cellnum, 20 * 256);
                }
                // 遍历创建行,导出数据
                List<Map<String, Object>> list = (List<Map<String, Object>>) datas.get(i).get("list");
                for (int rownum = 1; rownum <= list.size(); rownum++) {
                    Row row = sheet.createRow(rownum);
                    Map<String, Object> map = list.get(rownum-1);
                    // 循环创建单元格
                    for (int cellnum = 0; cellnum < fields.length; cellnum++) {
                        Cell cell = row.createCell(cellnum);
                        //cell.setCellStyle(getAndSetXSSFCellStyleOne(sxssfWorkbook));//设置数据行单元格样式,根据需要设置
                        cell.setCellValue(map.get(fields[cellnum]) == null ? "" : map.get(fields[cellnum]).toString());
                    }
                }
            }
            os = response.getOutputStream();
            sxssfWorkbook.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(sxssfWorkbook != null) {
                    //处理SXSSFWorkbook导出excel时，产生的临时文件
                    sxssfWorkbook.dispose();
                }
                if(os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 自定义各列宽度(单位为:字符宽度的1/256)
     */
    private static void setSheet(Sheet sheet) {
        sheet.setColumnWidth(0, 32 * 256);
        sheet.setColumnWidth(1, 32 * 256);
        sheet.setColumnWidth(2, 20 * 256);
        sheet.setColumnWidth(3, 20 * 256);
        sheet.setColumnWidth(4, 20 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 20 * 256);
        sheet.setColumnWidth(7, 20 * 256);
        sheet.setColumnWidth(8, 20 * 256);
        sheet.setColumnWidth(9, 20 * 256);
        sheet.setColumnWidth(10, 32 * 256);
    }

    /**
     * 获取并设置header样式
     */
    private static XSSFCellStyle getAndSetXSSFCellStyleHeader(SXSSFWorkbook sxssfWorkbook) {
        XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
        Font font = sxssfWorkbook.createFont();
        // 字体大小
        font.setFontHeightInPoints((short) 14);
        // 字体粗细
//        font.setBoldweight((short) 20); //TODO 3.9以下无此版本

        // 将字体应用到样式上面
        xssfCellStyle.setFont(font);
        // 是否自动换行
        xssfCellStyle.setWrapText(false);
        // 水平居中
        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 垂直居中
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return xssfCellStyle;
    }

    /**
     * 获取并设置样式
     */
    private static XSSFCellStyle getAndSetXSSFCellStyleOne(SXSSFWorkbook sxssfWorkbook) {
        XSSFCellStyle xssfCellStyle = (XSSFCellStyle) sxssfWorkbook.createCellStyle();
        XSSFDataFormat format = (XSSFDataFormat)sxssfWorkbook.createDataFormat();
        // 是否自动换行
        xssfCellStyle.setWrapText(false);
        // 水平居中
        xssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 垂直居中
        xssfCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 前景颜色
//        xssfCellStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND); //TODO 3.9以下无此版本
        xssfCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        // 边框
        xssfCellStyle.setBorderBottom(BorderStyle.THIN);
        xssfCellStyle.setBorderRight(BorderStyle.THIN);
        xssfCellStyle.setBorderTop(BorderStyle.THIN);
        xssfCellStyle.setBorderLeft(BorderStyle.THIN);
        xssfCellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        xssfCellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        xssfCellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        xssfCellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        // 防止数字过长,excel导出后,显示为科学计数法,如:防止8615192053888被显示为8.61519E+12
        xssfCellStyle.setDataFormat(format.getFormat("0"));
        return xssfCellStyle;
    }
}