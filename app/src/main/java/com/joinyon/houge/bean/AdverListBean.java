package com.joinyon.houge.bean;

import java.util.List;

public class AdverListBean {

    /**
     * errorMsg : OK
     * resultCode : 200
     * resultList : [{"IMG":"apps/advertising/2019111014250435691d0d2127480db06cce8d54eb3b91.png","SHOW_TYPE":"1","OBJECT_ID":"4bef03d43e2846e480f4805aa30828f4","ADVERTISING_ID":"c1ee5b90038211ea90c1fa163ec53ff8","CH_NAME":"沉甸甸的","TYPE":"1","REMARK":"撒旦法师打发士大夫撒旦法师的","WEBSITE":""}]
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
         * IMG : apps/advertising/2019111014250435691d0d2127480db06cce8d54eb3b91.png
         * SHOW_TYPE : 1
         * OBJECT_ID : 4bef03d43e2846e480f4805aa30828f4
         * ADVERTISING_ID : c1ee5b90038211ea90c1fa163ec53ff8
         * CH_NAME : 沉甸甸的
         * TYPE : 1
         * REMARK : 撒旦法师打发士大夫撒旦法师的
         * WEBSITE :
         */

        private String IMG;
        private String SHOW_TYPE;
        private String OBJECT_ID;
        private String ADVERTISING_ID;
        private String CH_NAME;
        private String TYPE;
        private String REMARK;
        private String WEBSITE;

        public String getIMG() {
            return IMG;
        }

        public void setIMG(String IMG) {
            this.IMG = IMG;
        }

        public String getSHOW_TYPE() {
            return SHOW_TYPE;
        }

        public void setSHOW_TYPE(String SHOW_TYPE) {
            this.SHOW_TYPE = SHOW_TYPE;
        }

        public String getOBJECT_ID() {
            return OBJECT_ID;
        }

        public void setOBJECT_ID(String OBJECT_ID) {
            this.OBJECT_ID = OBJECT_ID;
        }

        public String getADVERTISING_ID() {
            return ADVERTISING_ID;
        }

        public void setADVERTISING_ID(String ADVERTISING_ID) {
            this.ADVERTISING_ID = ADVERTISING_ID;
        }

        public String getCH_NAME() {
            return CH_NAME;
        }

        public void setCH_NAME(String CH_NAME) {
            this.CH_NAME = CH_NAME;
        }

        public String getTYPE() {
            return TYPE;
        }

        public void setTYPE(String TYPE) {
            this.TYPE = TYPE;
        }

        public String getREMARK() {
            return REMARK;
        }

        public void setREMARK(String REMARK) {
            this.REMARK = REMARK;
        }

        public String getWEBSITE() {
            return WEBSITE;
        }

        public void setWEBSITE(String WEBSITE) {
            this.WEBSITE = WEBSITE;
        }
    }
}
