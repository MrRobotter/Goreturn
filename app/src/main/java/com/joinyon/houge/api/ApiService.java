package com.joinyon.houge.api;


import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.base.RegisterBean;
import com.joinyon.houge.bean.AdverListBean;
import com.joinyon.houge.bean.BusinessListBean;
import com.joinyon.houge.bean.DicListBean;
import com.joinyon.houge.bean.LoginBean;


import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
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

    @FormUrlEncoded
    @POST(ApiConstants.USER_TP_UPLOAD)
    Flowable<BaseBean> userTpUpload(
            @Field("TP") String TP,
            @Field("TPLX") String TPLX,
            @Field("APPUSER_ID") String APPUSER_ID,
            @Field("ZCBZ") String ZCBZ // 注册步骤 1-填写基本信息  2-填写业务信息 3-上传名片 4-上传身份证 5-朋友认证，6，已完成  当刚注册好进来时加业务信息是，传值4，5，6
    );


    @FormUrlEncoded
    @POST(ApiConstants.GET_C_USER_LIST)
    Flowable<BusinessListBean> getCuserList(
            @Field("YHLX") String YHLX,//1-资方  2-项目方  3-专家  4-平台方
            @Field("keywords") String keywords,//关键字搜索
            @Field("PXLX") String PXLX,//排序类型  1-收藏量 2-转发量  3-点评分  4浏览数
            @Field("GZLY") String GZLY,//关注领域  当多选时 以“；”分割传递到后台
            @Field("YWQY") String YWQY,//当多选时 以“；”分割传递到后台
            @Field("YWLX") String YWLX,//当多选时 以“；”分割传递到后台
            @Field("YWJD") String YWJD,//务阶段  当多选时 以“；”分割传递到后台
            @Field("SFTJ") String SFTJ,//是否推荐  1-推荐 2-不推荐
            @Field("currentPage") String currentPage////页码
    );

    @GET(ApiConstants.GET_C_USER_LIST)
    Flowable<BusinessListBean> getCuserList();

    @FormUrlEncoded
    @POST(ApiConstants.ADVERTISING_LIST)
    Flowable<AdverListBean> getAdvertisingLis(
            @Field("SHOW_TYPE") String SHOW_TYPE//所属模块 1:资方 2、项目 3、活动  4、专家
    );
}