package lyp.bawei.com.pf.utiles;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import lyp.bawei.com.pf.myInterface.IRetorfit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/5/25.
 */

public class Mainutiles {
    /**
     * 获取app版本号
     * @param context
     * @return code
     */
    public static int getVer_code(Context context){
        int code=-1;
        try {
            //注意："com.example.try_downloadfile_progress"对应AndroidManifest.xml里的package="……"部分
            code = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("msg",e.getMessage());
        }
        return code;
    }
    /**
     * 获取app版本名称
     * @param context
     * @return
     */
    public static String getVer_name(Context context){
        String name="";
        try {
            //注意："com.example.try_downloadfile_progress"对应AndroidManifest.xml里的package="……"部分
            name = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("msg",e.getMessage());
        }
        return name;
    }
    /**
     * 获得设备唯一表示
     * @param context
     * @return
     */

    public static String getLocaldeviceId(Context context){
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        if (deviceId == null
                || deviceId.trim().length() == 0) {
            deviceId = String.valueOf(System
                    .currentTimeMillis());
        }
        return deviceId ;
    }
    /**
     * 获得时间戳
     * @return
     */
    public static String getTick(){
        //获得系统时间
        Date date =new Date();
        //转化成long类型
        long time = date.getTime();
        String tick_=String.valueOf(time);
        String tick=tick_.substring(0,10);
        return tick;

    }

    /**
     * MD5算法
     * @param string
     * @return
     */
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * 获得首次安装的标识
     * @param preferences
     * @return
     */
    public static boolean isFirstInstall(SharedPreferences preferences){
        boolean isFirstInstall = preferences.getBoolean(UrlConnect.ISFIRSTINSTALL,false);
        return isFirstInstall;
    }

    /**
     * 获得AppID
     * @param preferences
     * @return
     */
    public static String getAppID(SharedPreferences preferences){
        String appKey = preferences.getString(UrlConnect.APP_ID,"");
        return appKey;
    }

    /**
     * 获得privateKey
     * @param preferences
     * @return
     */
    public static String getPrivateKey(SharedPreferences preferences){
        String privateKey = preferences.getString(UrlConnect.PRIVATE_KEY,"");
        return privateKey;
    }

    /**
     * 获得HostUrl
     * @param preferences
     * @return
     */
    public static String getHostUrl(SharedPreferences preferences){
        String privateKey = preferences.getString("url_host","");
        return privateKey;
    }
    /**
     * 请求连接向导
     * @param privateKey 私钥
     * @param appKey appKey
     * @param devId 设备标识
     * @param verCode 版本号
     * @param tick 时间戳
     */
    public static String getHost(String privateKey,String appKey,String devId,int verCode,String tick) {
        //生成签名
        StringBuffer sb = new StringBuffer();
        sb.append(privateKey)
                .append(appKey)
                .append(devId)
                .append(verCode)
                .append(tick);
        String sign_ = Mainutiles.md5(sb.toString());
        String sign = sign_.toUpperCase();
        return sign;
    }
    public static String getHost(String privateKey,String appKey,String devId,int verCode,int page,int num,String tick) {
        //生成签名
        StringBuffer sb = new StringBuffer();
        sb.append(privateKey)
                .append(appKey)
                .append(devId)
                .append(verCode)
                .append(tick)
                .append(page)
                .append(num);
        String sign_ = Mainutiles.md5(sb.toString());
        String sign = sign_.toUpperCase();
        return sign;
    }
    //注册签名
    public static String getHost(String privateKey,String appKey,String devId,int verCode,String tick,String phone) {
        //生成签名
        StringBuffer sb = new StringBuffer();
        sb.append(privateKey)
                .append(appKey)
                .append(devId)
                .append(verCode)
                .append(tick)
                .append(phone);

        String sign_ = Mainutiles.md5(sb.toString());
        String sign = sign_.toUpperCase();
        return sign;
    }
    public static String getHost(String privateKey,String appid,String deviId,int ver_code,String tick,String session,String rand,String pwd) {
        //生成签名
        StringBuffer sb = new StringBuffer();
        sb.append(privateKey)
                .append(appid)
                .append(deviId)
                .append(ver_code)
                .append(tick)
                .append(session)
                .append(rand)
                .append(pwd);

        String sign_ = Mainutiles.md5(sb.toString());
        String sign = sign_.toUpperCase();
        return sign;
    }
    //登陆签名
    public static String getHost(String privateKey,String appKey,String devId,int verCode,String tick,String phone,String pwd) {
        //生成签名
        StringBuffer sb = new StringBuffer();
        sb.append(privateKey)
                .append(appKey)
                .append(devId)
                .append(verCode)
                .append(tick)
                .append(phone)
                .append(pwd);

        String sign_ = Mainutiles.md5(sb.toString());
        String sign = sign_.toUpperCase();
        return sign;
    }
    /**
     * 得到retorfit的接口
     * @param baseurl
     * @return IRetorfit
     */
    public static IRetorfit getRetorfitInterface(String baseurl){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(final String message) {
                //打印retrofit日志
                Log.i("tool", "url = " + message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//创建OkHttpClien
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
//---------------------

    Retrofit retrofit = new Retrofit.Builder().baseUrl(baseurl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
    IRetorfit iRetrofit = retrofit.create(IRetorfit.class);
    return iRetrofit;
}




}
