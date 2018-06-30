package com.charlesandkeith.charlesandkeithassingment.events;

public class ApiErrorEvent {

    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public ApiErrorEvent(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
