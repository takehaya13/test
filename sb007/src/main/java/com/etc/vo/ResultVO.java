package com.etc.vo;

public class ResultVO {
    private boolean result;
    private String error;


    public ResultVO(boolean result) {
        this.result = result;
    }

    public ResultVO() {
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
