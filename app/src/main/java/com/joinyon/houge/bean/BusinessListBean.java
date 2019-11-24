package com.joinyon.houge.bean;

import java.util.List;

public class BusinessListBean {

    /**
     * errorMsg : OK
     * resultCode : 200
     * resultList : [{"GZZW":"总经理","GZLY":"新三板;房地产","LLS":49,"YWLX":"股权投资","APPUSER_ID":"4bef03d43e2846e480f4805aa30828f4","TX":"apps/user_tp/20191116142259a723813647124839a866ddc2ab0c9637.png","XM":"测试杰","GZDW":"大宇互通集团"},{"GZZW":"IOS","GZLY":"上市公司;独角兽;北斗导航;新能源;人工智能;","LLS":24,"YWLX":"股权投资","APPUSER_ID":"cafa5468034944b2af00bda3fb2b2bc1","TX":"apps/user_tp/2019111614201412c59c42a5d747d09c136701b891c0f1.png","XM":"lxw","GZDW":"hangzhoukejiyouxianggongsi"},{"GZZW":"研发工程师","GZLY":"新材料;TMT;区块链","LLS":0,"YWLX":"存货质押借款","APPUSER_ID":"dc5a894aea754024ae3f018b201c88d0","XM":"众议院","GZDW":"真真正正"},{"LLS":0,"APPUSER_ID":"e79480aed25044f29eca27b8fbd04fe3"}]
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
         * GZZW : 总经理
         * GZLY : 新三板;房地产
         * LLS : 49
         * YWLX : 股权投资
         * APPUSER_ID : 4bef03d43e2846e480f4805aa30828f4
         * TX : apps/user_tp/20191116142259a723813647124839a866ddc2ab0c9637.png
         * XM : 测试杰
         * GZDW : 大宇互通集团
         */

        private String GZZW;
        private String GZLY;
        private int LLS;
        private String YWLX;
        private String APPUSER_ID;
        private String TX;
        private String XM;
        private String GZDW;

        public String getGZZW() {
            return GZZW;
        }

        public void setGZZW(String GZZW) {
            this.GZZW = GZZW;
        }

        public String getGZLY() {
            return GZLY;
        }

        public void setGZLY(String GZLY) {
            this.GZLY = GZLY;
        }

        public int getLLS() {
            return LLS;
        }

        public void setLLS(int LLS) {
            this.LLS = LLS;
        }

        public String getYWLX() {
            return YWLX;
        }

        public void setYWLX(String YWLX) {
            this.YWLX = YWLX;
        }

        public String getAPPUSER_ID() {
            return APPUSER_ID;
        }

        public void setAPPUSER_ID(String APPUSER_ID) {
            this.APPUSER_ID = APPUSER_ID;
        }

        public String getTX() {
            return TX;
        }

        public void setTX(String TX) {
            this.TX = TX;
        }

        public String getXM() {
            return XM;
        }

        public void setXM(String XM) {
            this.XM = XM;
        }

        public String getGZDW() {
            return GZDW;
        }

        public void setGZDW(String GZDW) {
            this.GZDW = GZDW;
        }
    }
}
