package com.joinyon.houge.api;


import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.base.RegisterBean;
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
    @FormUrlEncoded
    @POST(ApiConstants.LOGIN_URL)
    Flowable<LoginBean> login(@Field("SJHM") String loginName, @Field("MM") String password);

    @FormUrlEncoded
    @POST(ApiConstants.REGISTER)
    Flowable<RegisterBean> register(@Field("SJHM") String SJHM, @Field("SJYZM") String SJYZM, @Field("MM") String MM);

    @FormUrlEncoded
    @POST(ApiConstants.SEND_SMS_CODE)
    Flowable<BaseBean> sendSmsCode(@Field("SJHM") String SJHM);
}
