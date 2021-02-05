package com.flush.data.module.utils;

import com.alibaba.fastjson.annotation.JSONField;

public class Result {

    @JSONField(
            name = "RETURN_CODE"
    )
    private String returnCode;
    @JSONField(
            name = "RETURN_DATA"
    )
    private String returnData;
    @JSONField(
            name = "RETURN_DESC"
    )
    private String returnDesc;
    @JSONField(
            name = "RETURN_STAMP"
    )
    private String returnStamp;

    public Result() {

    }

    public Result(String returnCode, String returnData, String returnDesc, String returnStamp) {
        this.returnCode = returnCode;
        this.returnData = returnData;
        this.returnDesc = returnDesc;
        this.returnStamp = returnStamp;
    }


    public String getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnData() {
        return this.returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public String getReturnDesc() {
        return this.returnDesc;
    }

    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
    }

    public String getReturnStamp() {
        return this.returnStamp;
    }

    public void setReturnStamp(String returnStamp) {
        this.returnStamp = returnStamp;
    }

    @Override
    public String toString() {
        return "Result{" +
                "returnCode='" + returnCode + '\'' +
                ", returnData='" + returnData + '\'' +
                ", returnDesc='" + returnDesc + '\'' +
                ", returnStamp='" + returnStamp + '\'' +
                '}';
    }
}
