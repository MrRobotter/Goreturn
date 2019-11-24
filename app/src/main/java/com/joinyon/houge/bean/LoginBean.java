package com.joinyon.houge.bean;

import java.io.Serializable;

/**
 * Created by ZX on 2015/7/7.
 */
public class LoginBean implements Serializable {


    /**
     * resultCode : 1
     * APPUSER_ID : dc5a894aea754024ae3f018b201c88d0
     * XM : 众议院
     * SJHM : 15158870823
     * XB : 男
     * ZCBZ : 4
     * YHLX : 2
     * token : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkYzVhODk0YWVhNzU0MDI0YWUzZjAxOGIyMDFjODhkMCIsImlhdCI6MTU3NDU2NDA0Niwic3ViIjoiNjEuMTc0LjE0My4xMzMiLCJpc3MiOiJ7XCJZV0xYXCI6XCLlrZjotKfotKjmirzlgJ_mrL5cIixcIkFQUFVTRVJfSURcIjpcImRjNWE4OTRhZWE3NTQwMjRhZTNmMDE4YjIwMWM4OGQwXCIsXCJTU0JNXCI6XCLnoJTlj5Hpg6hcIixcIllXSlNcIjpcIumhueebruaWuVwiLFwiTVBSWlwiOlwiYXBwcy91c2VyX3RwLzIwMTkxMTE4MTgwMjAwZTBlMTlkZDQwOGQ3NDRmZDkxODhjY2YzMGI1MTdkZDkucG5nXCIsXCJHWlpXXCI6XCLnoJTlj5Hlt6XnqIvluIhcIixcIkdaRERcIjpcIuilv-WfjuWMulwiLFwiTExTXCI6MCxcIkRaWVhcIjpcImVycnJAZnR5eS5jb21cIixcIlNGWkZNXCI6XCJhcHBzL3VzZXJfdHAvMjAxOTExMjIyMDUxMjA0ZDNlOGVhNGI0NWE0NzE5ODJhZDJkODY1ODk5Yzc1Yi5wbmdcIixcIlBYWEhcIjowLFwiTU1cIjpcImFlNWQ4ZjhjNzQyNDk4NDFhOTA5MmI1NWMzZGQzNzVkZmRmMmJhM2ZcIixcIllXQUxcIjpcInl5XCIsXCJaRkxcIjowLFwiQ0pTSlwiOlwiMjAxOS0xMC0yNyAxNTo0Nzo1N1wiLFwiR1pMWVwiOlwi5paw5p2Q5paZO1RNVDvljLrlnZfpk75cIixcIkdaRFdcIjpcIuecn-ecn-ato-ato1wiLFwiU0ZaWk1cIjpcImFwcHMvdXNlcl90cC8yMDE5MTEyMjIwNTExOTU2NmJjZjkyOThmMjQ4ZDhiZWMwNTVlYjk2ZDFhMTA3LnBuZ1wiLFwiWkNCWlwiOlwiNFwiLFwiRFdMQlwiOlwi5LyB5Lia5pyN5YqhXCIsXCJYQlwiOlwi55S3XCIsXCJEV0pDXCI6XCLmtYvor5VcIixcIlhHU0pcIjpcIjIwMTktMTAtMjcgMTU6NDc6NTdcIixcIllXUVlcIjpcIuWtmOi0p-i0qOaKvOi0t-asvlwiLFwiU1pDU1wiOlwi6YeN5bqG5biCIOmHjeW6huW4giDmuJ3kuK3ljLpcIixcIllXSkRcIjpcIklQTzvmlrDkuInmnb8xO-S4iuW4guWFrOWPuDFcIixcIllITFhcIjpcIjJcIixcIlhNXCI6XCLkvJforq7pmaJcIixcIlNKSE1cIjpcIjE1MTU4ODcwODIzXCIsXCJTQ0xcIjowfSIsImV4cCI6MTU3NDU3MTI0Nn0.lmzW-ZKp_0U5qiomi6_2DCASjKAWHtvvi2_KJpnETL4
     */

    private String resultCode;
    private String APPUSER_ID;
    private String XM;
    private String SJHM;
    private String XB;
    private String ZCBZ;
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

    public String getXM() {
        return XM;
    }

    public void setXM(String XM) {
        this.XM = XM;
    }

    public String getSJHM() {
        return SJHM;
    }

    public void setSJHM(String SJHM) {
        this.SJHM = SJHM;
    }

    public String getXB() {
        return XB;
    }

    public void setXB(String XB) {
        this.XB = XB;
    }

    public String getZCBZ() {
        return ZCBZ;
    }

    public void setZCBZ(String ZCBZ) {
        this.ZCBZ = ZCBZ;
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
                ", XM='" + XM + '\'' +
                ", SJHM='" + SJHM + '\'' +
                ", XB='" + XB + '\'' +
                ", ZCBZ='" + ZCBZ + '\'' +
                ", YHLX='" + YHLX + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
