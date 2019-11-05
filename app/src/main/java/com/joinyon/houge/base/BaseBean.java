package com.joinyon.houge.base;

import java.io.Serializable;

/**
 * Created by ZX on 2015/7/7.
 */
public class BaseBean implements Serializable {

    /**
     * resultCode : 1
     */

    private String resultCode;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "resultCode='" + resultCode + '\'' +
                '}';
    }
}
