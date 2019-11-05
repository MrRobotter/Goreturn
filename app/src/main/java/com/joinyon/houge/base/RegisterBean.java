package com.joinyon.houge.base;

public class RegisterBean   {


    /**
     * resultCode : 1
     * APPUSER_ID : dc5a894aea754024ae3f018b201c88d0
     */

    private String resultCode;
    private String APPUSER_ID;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getAPPUSER_ID() {
        return APPUSER_ID;
    }

    public void setAPPUSER_ID(String APPUSER_ID) {
        this.APPUSER_ID = APPUSER_ID;
    }

    @Override
    public String toString() {
        return "RegisterBean{" +
                "resultCode='" + resultCode + '\'' +
                ", APPUSER_ID='" + APPUSER_ID + '\'' +
                '}';
    }
}
