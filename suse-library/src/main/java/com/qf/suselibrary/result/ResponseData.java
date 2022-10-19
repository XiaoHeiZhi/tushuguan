package com.qf.suselibrary.result;

/**
 * 封装返回值类型
 */
public class ResponseData {

    private  String code;       //状态

    private  String info;       //消息

    private  Object data;       //数据

    private  Long count;     //分页实现的 数据总量


    public ResponseData() {     //无参构造函数
    }

    public ResponseData(String code, String info, Object data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }

    public ResponseData(ResponseCode responseCode, Object data) {
        this.code = responseCode.getCode();
        this.info = responseCode.getInfo();
        this.data = data;
    }

    public ResponseData(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public ResponseData(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.info = responseCode.getInfo();
    }

    //有分页功能的时候使用
    public ResponseData(String code, String info,Long count, Object data) {
        this.code = code;
        this.info = info;
        this.data = data;
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
