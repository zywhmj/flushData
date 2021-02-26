package com.flush.data.module.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyw
 * @date
 */

public class WordContentController {

    //饱汉模式，需要用到时才去创建
    private Configuration configuration = null;
    public WordContentController() {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
    }
    //创建后缀为.doc的文档
    public void creatDoc() {
        //把数据放进这个map里面进行填充
        Map dataMap = new HashMap();
        //获取数据的方法
        getData(dataMap);
//        URL resource = Thread.currentThread().getContextClassLoader().getResource("templete-tmp.ftl");
//        System.out.println("=======>路径："+resource.getPath());
        //模板文件的位置，你们的模板就是自己修改的flt文档，我的是跟代码同一个包下（确保能找到就可以）
        configuration.setClassForTemplateLoading(this.getClass(), "/templete/");   //TODO classPath 为target中classes的根目录
        Template template = null;
        try {
            //加载---要装载的模板文件
            template = configuration.getTemplate("templete-tmp.ftl"); //TODO 此处相当于拿 /templete/templete-tmp.ftl 文件
        } catch (Exception e) {
            e.printStackTrace();
        }
        //输出文档路径及名称,注意后缀一定要.doc！不然代码运行完后会打不开
        File outFile = new File("D://test//test.docx"); //TODO 输出的文件目录
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            template.process(dataMap, out);
            // System.out.println(out); 查看数据
            //  System.out.println(dataMap); 查看数据
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void getData(Map dataMap) {
        /*dataMap.put("businesstypes", "■开卡 □销户  □业务类型变更（变更类型：1新增号码、2 删除号码、3 更换号码）变更原因：______________");
        dataMap.put("applicationscene", "■AXB  □AX  □其他_______________________");
        dataMap.put("productfuntion", "□录音  ■非录音");
        dataMap.put("paymodel", "■预付 □预付");
        dataMap.put("companyname", "**科技");
        dataMap.put("companyaddress", "保亿创意大厦");
        dataMap.put("linkman", "daboss");
        dataMap.put("phonenumber", "13567890123");*/

        /**
         *这里有循环，是因为我的模板中序号可能有多条，所以我把序号，地区，数量，日	通话量，备注作为了一个bean
         进行了循环添加，如果你们遇上要循环的地方也可以这样，但是模板文件也要修改， ctrl+F 搜索<w:tr，
         找到对应的文字需要循环的下面添加   <#list userList as user>，并在</w:tr后面加上</#list>结尾！
         */
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        for (int i = 1; i < 4; i++) {
            Map<String, String> u = new HashMap<>();
            u.put("subNum", "检材"+i);
            u.put("typeName", "类型名称"+i);
            u.put("status", "状态"+i);
            u.put("describe", "描述"+i);
            u.put("remark", "备注"+i);
            dataList.add(u);
        }
        dataMap.put("dataList", dataList);

        dataMap.put("projectNo", "CNNS-2021-208");
        dataMap.put("projectName", "广州天河区传销案");

    }
    public static void main(String[] args) {
        WordContentController docAdd = new WordContentController();
        docAdd.creatDoc();
    }


}