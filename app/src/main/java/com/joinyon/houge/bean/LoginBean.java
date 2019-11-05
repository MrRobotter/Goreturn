package com.joinyon.houge.bean;

import java.io.Serializable;

/**
 * Created by ZX on 2015/7/7.
 */
public class LoginBean implements Serializable {


    /**
     * resultCode : 1
     * APPUSER_ID : dc5a894aea754024ae3f018b201c88d0
     * SJHM : 15158870823
     * YHLX : 0
     * token : eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NzIxNjU0ODUsInN1YiI6IjExNS4xOTguNDMuMjUyIiwiaXNzIjoie1wiTU1cIjpcImFlNWQ4ZjhjNzQyNDk4NDFhOTA5MmI1NWMzZGQzNzVkZmRmMmJhM2ZcIixcIlpGTFwiOjAsXCJDSlNKXCI6XCIyMDE5LTEwLTI3IDE1OjQ3OjU3XCIsXCJZSExYXCI6XCIwXCIsXCJMTFNcIjowLFwiQVBQVVNFUl9JRFwiOlwiZGM1YTg5NGFlYTc1NDAyNGFlM2YwMThiMjAxYzg4ZDBcIixcIlpDQlpcIjpcIjFcIixcIlNKSE1cIjpcIjE1MTU4ODcwODIzXCIsXCJTQ0xcIjowLFwiUFhYSFwiOjAsXCJYR1NKXCI6XCIyMDE5LTEwLTI3IDE1OjQ3OjU3XCJ9IiwiZXhwIjoxNTcyMTcyNjg1fQ.yCSsWY3Y8S3hBayOfbPRCp0D2fsjsgDNfBteE0mew14
     */

    private String resultCode;
    private String APPUSER_ID;
    private String SJHM;
    private String YHLX;
    private String token;

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

    public String getSJHM() {
        return SJHM;
    }

    public void setSJHM(String SJHM) {
        this.SJHM = SJHM;
    }

    public String getYHLX() {
        return YHLX;
    }

    public void setYHLX(String YHLX) {
        this.YHLX = YHLX;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "resultCode='" + resultCode + '\'' +
                ", APPUSER_ID='" + APPUSER_ID + '\'' +
                ", SJHM='" + SJHM + '\'' +
                ", YHLX='" + YHLX + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
