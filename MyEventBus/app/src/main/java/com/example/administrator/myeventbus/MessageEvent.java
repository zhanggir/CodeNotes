package com.example.administrator.myeventbus;

/**
 * Created by Administrator on 2017/3/7.
 */

public class MessageEvent {
    private String messge;

    public MessageEvent(String messge) {
        this.messge = messge;
    }
    public String getMessge(){
        return messge;
    }
}
