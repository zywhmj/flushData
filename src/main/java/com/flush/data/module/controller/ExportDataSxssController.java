package com.flush.data.module.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  excel导出数据：直接执行main方法
 *  说明：依赖3.9的poi的jar，需要打开pom.xml对应的jar并注释其他版本的
 * @author zyw
 * @date
 */
public class ExportDataSxssController {

    public static void main(String[] args) {
        try {
            boolean createExcelFile = createExcelFile();
            if (createExcelFile) {
                System.out.println("SXSSF_excel导出成功");
            } else {
                System.out.println("SXSSFexcel导出失败");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static boolean createExcelFile() throws Exception {

        boolean state = false;
        OutputStream os = null;
        FileOutputStream fos = null;
        String resultFileName = null;
        String fileName = "";
        try {
            Workbook wb;
            fileName = "kemu.xlsx";
            wb = createReportWorkbook();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            resultFileName = "E:\\" + File.separator + "excel" + File.separator + sdf.format(new Date())
                    + File.separator + fileName;
            resultFileName = resultFileName.replaceAll("\\\\", "/");
            File file = new File(resultFileName);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            fos = new FileOutputStream(file);
            os = new BufferedOutputStream(fos, 1024);
            wb.write(os);
            os.flush();
            state = true;
        } finally {
            if (os != null)
                os.close();
        }
        return state;
    }

    private static Workbook createReportWorkbook() {
        String[] titles = { "时间", "科目", "科目", "科目", "科目", "备注" };
        String[] handClum = { "0,1,0,0", "0,0,1,4", "0,1,5,5" };

        String[] titles2 = { "时间", "科目一", "科目二", "科目三", "科目四", "备注" };

        // 100 指定Excel在屏幕尺寸下可滑动数据为100条
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);// 设置单元格水平居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);// 设置单元格垂直居中
        Sheet sheet = wb.createSheet("sheet1");
        for (int i = 0; i < titles.length; i++) {
            sheet.setColumnWidth(i, 5000);
        }

        Row row = sheet.createRow(0);// 创建表头1
        for (int i = 0; i < titles.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(titles[i]);
        }

        // TODO 动态合并单元格
        for (int i = 0; i < handClum.length; i++) {
            // sheet.autoSizeColumn(i, true);
            String[] temp = handClum[i].split(",");
            Integer startrow = Integer.parseInt(temp[0]);
            Integer overrow = Integer.parseInt(temp[1]);
            Integer startcol = Integer.parseInt(temp[2]);
            Integer overcol = Integer.parseInt(temp[3]);
            sheet.addMergedRegion(new CellRangeAddress(startrow, overrow, startcol, overcol));
        }

        row = sheet.createRow(1);// 创建表头2
        for (int i = 0; i < titles2.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(titles2[i]);
        }

        List<keMu> kemus = new ArrayList<keMu>();
        for (int i = 0; i < 1000; i++) {
            keMu kemu = new keMu();
            kemu.setCreateDate("2018/11/06");
            kemu.setKe1("理论" + i);
            kemu.setKe2("模拟" + i);
            kemu.setKe3("上机" + i);
            kemu.setKe4("实操" + i);
            kemu.setRemark("通过");
            kemus.add(kemu);
        }
        // 填充数据
        if (kemus != null && kemus.size() > 0) {
            for (int i = 0; i < kemus.size(); i++) {
                Row contentRow = sheet.createRow(i + 2);// 填充类容,从第2行开始,0行给表头
                if (i % 100 == 0) {
                    try {
                        ((SXSSFSheet) sheet).flushRows(100);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                for (int j = 0; j < titles2.length; j++) {
                    Cell cell = contentRow.createCell(j);
                    cell.setCellStyle(style);
                    keMu content = kemus.get(i);
                    switch (j) {
                        case 0:
                            cell.setCellValue(content.getCreateDate());
                            break;
                        case 1:
                            cell.setCellValue(content.getKe1());
                            break;
                        case 2:
                            cell.setCellValue(content.getKe2());
                            break;
                        case 3:
                            cell.setCellValue(content.getKe3());
                            break;
                        case 4:
                            cell.setCellValue(content.getKe4());
                            break;
                        case 5:
                            cell.setCellValue(content.getRemark());
                            break;
                    }
                }
            }
        }

        return wb;
    }

    static class keMu {
        private String createDate;
        private String ke1;
        private String ke2;
        private String ke3;
        private String ke4;
        private String remark;

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getKe1() {
            return ke1;
        }

        public void setKe1(String ke1) {
            this.ke1 = ke1;
        }

        public String getKe2() {
            return ke2;
        }

        public void setKe2(String ke2) {
            this.ke2 = ke2;
        }

        public String getKe3() {
            return ke3;
        }

        public void setKe3(String ke3) {
            this.ke3 = ke3;
        }

        public String getKe4() {
            return ke4;
        }

        public void setKe4(String ke4) {
            this.ke4 = ke4;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

    }
}