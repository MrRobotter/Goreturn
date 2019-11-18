/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.joinyon.houge.api;

public class ApiConstants {
    public static final String _ID = "5b505368ca87a81d1a716097";
    public static final String _TOKEN = "c0ca4f2c1d2bf1b7f00624514616f85d";

    public static final String BASE_URL = "http://47.97.107.105/";
    public static final String IMAGE_URL = "https://coludkejia.cn/MysasPlatform";
    //1.获取数据字典
    public static final String GET_DIC = "investment/app/cuser/getdic.do";
    //2.获取数据字典列表
    public static final String GET_DIC_LIST = "investment/app/cuser/getdicList.do";

    //6.基本信息填写
    public static final String BASE_INFO = "investment/app/cuser/changeInformation.do";
    //7.填写业务信息
    public static final String BUSINESS_INFO="investment/app/cuser/changeBusiness.do";
    //登录
    public static final String LOGIN_URL = "investment/app/cuser/login.do";
    //获取验证码
    public static final String SEND_SMS_CODE = "investment/app/cuser/sendSMSCode.do";
    //注册
    public static final String REGISTER = "investment/app/cuser/register.do";

    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.HOME_NEW_LIST:
                host = "";
                break;
            case HostType.PICTURE_NEW_LIST:
                host = "";
                break;

            default:
                host = "";
                break;
        }
        return host;
    }
}
