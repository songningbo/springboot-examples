package com.bccoder.mvc.exception;

public class BizException extends RuntimeException{
    public BizException(){
    }
    public BizException(String code,String msg){
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
