package com.flush.data.module.controller;


import com.flush.data.module.utils.ExportExcel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * excel导出数据：localhost:9999/export
 * 说明：此导出需要3.17的poi的jar，需要打开pom.xml对应的jar并注释其他版本的,并且打开ExportExcel.java注释掉的TODO 3.9两句代码
 * @author zyw
 * @date
 */
@Controller
public class ExportDataHttpController {


    //导出
    @ResponseBody
    @RequestMapping("/export")
    public String export(Model model, HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("导出开始时间：" + format.format(new Date()));
        List<Map<String, Object>> list = new ArrayList<>(); //TODO 查询业务数据
        setData(list);
        String[] lables = new String[]{"号码", "入库时间"};//表头数组
        String[] fields = new String[]{"HM", "RKSJ"};//查询数据对应的属性数组
        String title = "测试.xlsx";
        ExportExcel.export(response, list, lables, fields, title);
        System.out.println("导出结束时间：" + format.format(new Date()));
        return "导出成功";
    }

    private static void setData(List<Map<String, Object>> list) {
        for (int i = 0; i < 100; i++){
            Map<String, Object> map = new HashMap<>();
            map.put("HM", "hm-测试-001"+i);
            map.put("RKSJ", "rksj-测试-999"+i);
            list.add(map);
        }
    }

}