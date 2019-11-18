package com.joinyon.houge.bean;

import java.util.List;

public class DicListBean {

    /**
     * errorMsg : OK
     * resultCode : 200
     * resultList : [{"value":"商业银行","key":"商业银行"},{"value":"证券公司","key":"证券公司"},{"value":"信托公司","key":"信托公司"},{"value":"期货公司","key":"期货公司"},{"value":"保险公司","key":"保险公司"},{"value":"私募股权","key":"私募股权"},{"value":"私募证券","key":"私募证券"},{"value":"私募其他","key":"私募其他"},{"value":"公募基金","key":"公募基金"},{"value":"保理公司","key":"保理公司"},{"value":"融资租赁公司","key":"融资租赁公司"},{"value":"上市公司","key":"上市公司"},{"value":"财富公司","key":"财富公司"},{"value":"交易所","key":"交易所"},{"value":"互金平台","key":"互金平台"},{"value":"金融控股公司","key":"金融控股公司"},{"value":"律师事务所","key":"律师事务所"},{"value":"会计师事务所","key":"会计师事务所"},{"value":"资产评估公司","key":"资产评估公司"},{"value":"社会媒体","key":"社会媒体"},{"value":"孵化器","key":"孵化器"},{"value":"产业园区","key":"产业园区"},{"value":"企业服务公司","key":"企业服务公司"},{"value":"投融资平台","key":"投融资平台"},{"value":"创业企业","key":"创业企业"},{"value":"商会协会","key":"商会协会"},{"value":"国有企业","key":"国有企业"},{"value":"房地产企业","key":"房地产企业"},{"value":"其他类别","key":"其他类别"},{"value":"境内公民","key":"境内公民"},{"value":"境外公民","key":"境外公民"}]
     */

    private String errorMsg;
    private String resultCode;
    private List<ResultListBean> resultList;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public List<ResultListBean> getResultList() {
        return resultList;
    }

    public void setResultList(List<ResultListBean> resultList) {
        this.resultList = resultList;
    }

    public static class ResultListBean {
        /**
         * value : 商业银行
         * key : 商业银行
         */

        private String value;
        private String key;
        private boolean s=false;

        public boolean isS() {
            return s;
        }

        public void setS(boolean s) {
            this.s = s;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
