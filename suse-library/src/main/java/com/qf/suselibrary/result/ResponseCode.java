package com.qf.suselibrary.result;

/**
 * 状态码和对应的状态码消息
 *
 */
public enum ResponseCode {
    SUCCESS("200","success"),
    FAILED( "500","未知错误"),
    DATAERROR("501","数据异常"),
    USERINFO_ERROR("502","用户信息过期"),
    SQLEXCEPTION("401","sql异常")
    ;
    private String code;

    private String info;

    ResponseCode(String code, String info) {
        this.code = code;
        this.info = info;
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
}
