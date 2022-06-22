package com.example.lastfresh.controller.sell;

public class ResponseEntityEx {
    private String status;
    private Object body;

    public ResponseEntityEx(String status, Object body) {
        this.status = status;
        this.body = body;
    }

    public ResponseEntityEx(Object body) {
        this.status = "ok";
        this.body = body;
    }

    public static ResponseEntityEx ok(Object body) {
        return new ResponseEntityEx("ok", body);
    }

    public static ResponseEntityEx fail(Object body) {
        return new ResponseEntityEx("fail", body);
    }
}
