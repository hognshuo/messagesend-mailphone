package com.example.messagesendmailphone.comon;

import lombok.Data;

/**
 * 响应数据结构封装
 *
 * @author hs
 * @data 2019-10-25 13:49
 * @param <T>
 * @description
 */
@Data
public class ResponseData<T> extends BaseResponse {

    private T data;

    private ResponseData(){
    }

    private ResponseData(CodeEnum code, T data){
        super(code);
        this.data = data;
    }

    public static <T> ResponseData<T> out(CodeEnum code, T data) {
        return new ResponseData<T>(code, data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
