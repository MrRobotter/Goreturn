package com.joinyon.houge.api;


import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.base.RegisterBean;
import com.joinyon.houge.bean.DicListBean;
import com.joinyon.houge.bean.LoginBean;


import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by boxu on 2017/4/4.
 */

public interface ApiService {
    //1.获取数据字典

    //2.获取数据字典列表
    @FormUrlEncoded
    @POST(ApiConstants.GET_DIC_LIST)
    Flowable<DicListBean> getDicList(@Field("BIANMA") String BIANMA);

    @FormUrlEncoded
    @POST(ApiConstants.LOGIN_URL)
    Flowable<LoginBean> login(@Field("SJHM") String loginName, @Field("MM") String password);

    @FormUrlEncoded
    @POST(ApiConstants.REGISTER)
    Flowable<RegisterBean> register(@Field("SJHM") String SJHM, @Field("SJYZM") String SJYZM, @Field("MM") String MM);

    @FormUrlEncoded
    @POST(ApiConstants.SEND_SMS_CODE)
    Flowable<BaseBean> sendSmsCode(@Field("SJHM") String SJHM);

    @FormUrlEncoded
    @POST(ApiConstants.BASE_INFO)
    Flowable<BaseBean> changeInformation(@Field("APPUSER_ID") String APPUSER_ID,
                                         @Field("ZCBZ") String ZCBZ,
                                         @Field("XM") String XM,
                                         @Field("XB") String XB,
                                         @Field("SZCS") String SZCS,
                                         @Field("DZYX") String DZYX,
                                         @Field("GZDW") String GZDW,
                                         @Field("DWJC") String DWJC,
                                         @Field("GZDD") String GZDD,
                                         @Field("SSBM") String SSBM,
                                         @Field("GZZW") String GZZW,
                                         @Field("DWLB") String DWLB
    );

    @FormUrlEncoded
    @POST(ApiConstants.BUSINESS_INFO)
    Flowable<BaseBean> changeBusiness(@Field("APPUSER_ID") String APPUSER_ID,//用户ID
                                      @Field("ZCBZ") String ZCBZ,//注册步骤 3
                                      @Field("YWJS") String YWJS,//业务角色
                                      @Field("YWLX") String YWLX,//角色类型
                                      @Field("GZLY") String GZLY,//关注领域	多个以“；”分割
                                      @Field("YWJD") String YWJD,//业务阶段	多个以“；”分割
                                      @Field("YWQY") String YWQY,//	业务区域
                                      @Field("YWAL") String DWJC//业务案例
    );

}
