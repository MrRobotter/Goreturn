package com.joinyon.houge.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPHelper {

    private static SPHelper helper;
    private SharedPreferences settings = null;
    private Context ctx;
    private SharedPreferences.Editor editor;
    private String sPrefsName;

    private static final String UID = "uid";
    private static final String scaleRate_W = "scaleRate_W";
    private static final String scaleRate = "scaleRate";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String TOKEN = "token";
    private static final String COOKIE = "cookie";
    private static final String APP_ID = "app_id";
    private static final String USER_ID = "user_id";
    private static final String NAME = "name";
    private static final String PHONE = "phone";

    private static final String HEAD_IMAGE = "head_image";
    private static final String LIST_IMAGE = "list_image";
    private static final String NICKNAME = "nickname";
    private static final String LOGIN_NAME = "login_name";

    private static final String H5URL = "h5url";
    private static final String QRURL = "qrurl";

    private static final String SHOP_NAME = "shop_name";
    private static final String LOGIN_TYPE = "login_type";

    private static final String ACCID = "accid";
    private static final String ACC_TOKEN = "acc_token";

    private static final String ACC_PLATFORM = "platform_accid";
    private static final String FIRST_INDEX = "first_index";
    private static final String INVITE_CODE = "inviteCode";
    private static final String INVITE_CODE_QR = "inviteCodeQr";

    private static final String IS_HAS_VIP_SESSION = "is_has_vip_session";

    private static final String SHOP_VALIDY_DATE = "shop_validy_date";
    private static final String SCREEN_WIDTH = "screen_width";
    private static final String SCREEN_HEIGHT = "screen_height";

    public static void init(Context context) {
        helper = new SPHelper(context);
    }

    public static SPHelper getInstance() {
        if (helper == null) {
            throw new NullPointerException(
                    "NOT INIT sphelper,please call init in app first");
        }
        return helper;
    }

    private SPHelper(Context context) {
        this.ctx = context;
        sPrefsName = ctx.getPackageName();
        this.settings = ctx.getSharedPreferences(sPrefsName,
                Context.MODE_PRIVATE);
        this.editor = settings.edit();
    }


    public static String getUid() {
        return getInstance().settings.getString(UID, "");
    }

    public static String getInviteCode() {
        return getInstance().settings.getString(INVITE_CODE, "");
    }

    public static String getInvitecodeqr() {
        return getInstance().settings.getString(INVITE_CODE_QR, "");
    }

    public static void setInviteCode(String inviteCode) {
        getInstance().editor.putString(INVITE_CODE, inviteCode);
        getInstance().editor.commit();
    }

    public static void setInvitecodeqr(String inviteCodeQr) {
        getInstance().editor.putString(INVITE_CODE_QR, inviteCodeQr);
        getInstance().editor.commit();
    }

    public static void setUid(String uid) {
        getInstance().editor.putString(UID, uid);
        getInstance().editor.commit();
    }

    public static double getScaleRate_W() {
        return getInstance().settings.getFloat(scaleRate_W, 0.0f);
    }

    public static void setScaleRate_W(float scaleRateW) {
        getInstance().editor.putFloat(scaleRate_W, scaleRateW);
        getInstance().editor.commit();
    }

    public static double getScaleRate() {
        return getInstance().settings.getFloat(scaleRate, 0.0f);
    }

    public static void setScaleRate(float scaleRatef) {
        getInstance().editor.putFloat(scaleRate, scaleRatef);
        getInstance().editor.commit();
    }

    public static void setScreenWidth(int screenWidth) {
        getInstance().editor.putInt(SCREEN_WIDTH, screenWidth);
        getInstance().editor.commit();
    }

    public static int getScreenWidth() {
        return getInstance().settings.getInt(SCREEN_WIDTH, 0);
    }

    public static void setScreenHeight(int screenHeight) {
        getInstance().editor.putInt(SCREEN_HEIGHT, screenHeight);
        getInstance().editor.commit();
    }

    public static int getScteenHeight() {
        return getInstance().settings.getInt(SCREEN_HEIGHT, 0);

    }

    public static String getUsername() {
        return getInstance().settings.getString(USERNAME, "");
    }

    public static void setUsername(String username) {
        getInstance().editor.putString(USERNAME, username);
        getInstance().editor.commit();
    }

    public static String getPassword() {
        return getInstance().settings.getString(PASSWORD, "");
    }

    public static void setPassword(String password) {
        getInstance().editor.putString(PASSWORD, password);
        getInstance().editor.commit();
    }

    public static String getIsHasVipSession() {
        return getInstance().settings.getString(IS_HAS_VIP_SESSION, "");
    }

    public static void setIsHasVipSession(String isHasVipSession) {
        getInstance().editor.putString(IS_HAS_VIP_SESSION, isHasVipSession);
        getInstance().editor.commit();
    }

    public static String getToken() {
        return getInstance().settings.getString(TOKEN, "");
    }

    public static void setToken(String token) {
        getInstance().editor.putString(TOKEN, token);
        getInstance().editor.commit();
    }

    public static String getShopName() {
        return getInstance().settings.getString(SHOP_NAME, "");
    }

    public static void setShopName(String shopName) {
        getInstance().editor.putString(SHOP_NAME, shopName);
        getInstance().editor.commit();
    }

    public static String getCookie() {
        return getInstance().settings.getString(COOKIE, "");
    }

    public static void setCookie(String cookie) {
        getInstance().editor.putString(COOKIE, cookie);
        getInstance().editor.commit();
    }


    public static String getUserId() {
        return getInstance().settings.getString(USER_ID, "");
    }

    public static void setUserId(String userId) {
        getInstance().editor.putString(USER_ID, userId);
        getInstance().editor.commit();
    }

    public static String getAppId() {
        return getInstance().settings.getString(APP_ID, "");
    }

    public static void setAppId(String app_id) {
        getInstance().editor.putString(APP_ID, app_id);
        getInstance().editor.commit();
    }

    public static String getName() {
        return getInstance().settings.getString(NAME, "");
    }

    public static void setName(String name) {
        getInstance().editor.putString(NAME, name);
        getInstance().editor.commit();
    }


    public static String getPhone() {
        return getInstance().settings.getString(PHONE, "");
    }

    public static void setPhone(String phone) {
        getInstance().editor.putString(PHONE, phone);
        getInstance().editor.commit();
    }

    public static String getHeadImage() {
        return getInstance().settings.getString(HEAD_IMAGE, "");
    }

    public static void setHeadImage(String headImage) {
        getInstance().editor.putString(HEAD_IMAGE, headImage);
        getInstance().editor.commit();
    }

    public static String getListImage() {
        return getInstance().settings.getString(LIST_IMAGE, "");
    }

    public static void setListImage(String listImage) {
        getInstance().editor.putString(LIST_IMAGE, listImage);
        getInstance().editor.commit();
    }

    public static String getNickname() {
        return getInstance().settings.getString(NICKNAME, "");
    }

    public static void setNickname(String nickname) {
        getInstance().editor.putString(NICKNAME, nickname);
        getInstance().editor.commit();
    }

    public static String getLoginName() {
        return getInstance().settings.getString(LOGIN_NAME, "");
    }

    public static void setLoginName(String loginName) {
        getInstance().editor.putString(LOGIN_NAME, loginName);
        getInstance().editor.commit();
    }

    public static String getLoginType() {
        return getInstance().settings.getString(LOGIN_TYPE, "");
    }

    public static void setLoginType(String loginType) {
        getInstance().editor.putString(LOGIN_TYPE, loginType);
        getInstance().editor.commit();
    }

    public static String getH5url() {
        return getInstance().settings.getString(H5URL, "");
    }

    public static void setH5url(String h5url) {
        getInstance().editor.putString(H5URL, h5url);
        getInstance().editor.commit();
    }

    public static String getQrurl() {
        return getInstance().settings.getString(QRURL, "");
    }

    public static void setQrurl(String qrurl) {
        getInstance().editor.putString(QRURL, qrurl);
        getInstance().editor.commit();
    }

    public static String getAccid() {
        return getInstance().settings.getString(ACCID, "");
    }

    public static void setAccid(String accid) {
        getInstance().editor.putString(ACCID, accid);
        getInstance().editor.commit();
    }

    public static String getAccToken() {
        return getInstance().settings.getString(ACC_TOKEN, "");
    }

    public static void setAccToken(String accToken) {
        getInstance().editor.putString(ACC_TOKEN, accToken);
        getInstance().editor.commit();
    }

    public static String getAccPlatform() {
        return getInstance().settings.getString(ACC_PLATFORM, "");
    }

    public static void setAccPlatform(String accPlatform) {
        getInstance().editor.putString(ACC_PLATFORM, accPlatform);
        getInstance().editor.commit();
    }

    public static String getFirstIndex() {
        return getInstance().settings.getString(FIRST_INDEX, "");
    }

    public static void setFirstIndex(String firstIndex) {
        getInstance().editor.putString(FIRST_INDEX, firstIndex);
        getInstance().editor.commit();
    }

    public static String getShopValidyDate() {
        return getInstance().settings.getString(SHOP_VALIDY_DATE, "");
    }

    public static void setShopValidyDate(String shopValidyDate) {
        getInstance().editor.putString(SHOP_VALIDY_DATE, shopValidyDate);
        getInstance().editor.commit();
    }
}
