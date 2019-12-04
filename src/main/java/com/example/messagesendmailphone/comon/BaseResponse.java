package com.example.messagesendmailphone.comon;

import lombok.Data;

/**
 * @author hs
 * @data: 2019/10/22 12:00
 * @param:
 * @description: 基本响应封装
 */
@Data
public class BaseResponse {

    private int    code;
    private String msg;

    public BaseResponse(){
    }

    public BaseResponse(CodeEnum code){
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public static BaseResponse out(CodeEnum code) {
        return new BaseResponse(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
