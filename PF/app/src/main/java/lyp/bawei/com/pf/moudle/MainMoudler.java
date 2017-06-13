package lyp.bawei.com.pf.moudle;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;


import lyp.bawei.com.pf.bean.FistHander;

import lyp.bawei.com.pf.bean.LoginBean;
import lyp.bawei.com.pf.bean.TopicClassAllBean;
import lyp.bawei.com.pf.myInterface.IRetorfit;
import lyp.bawei.com.pf.myInterface.ImainPresenter;
import lyp.bawei.com.pf.utiles.Mainutiles;
import lyp.bawei.com.pf.utiles.UrlConnect;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Administrator on 2017/5/25.
 */

public class MainMoudler {
    private SharedPreferences first;
    private ImainPresenter imainPresenter;
    private Context context;


    public MainMoudler(ImainPresenter imainPresenter, Context context) {
        this.imainPresenter = imainPresenter;
        this.context=context;
    }

    /**
     * 导向请求
     */
    public void getHost() {
        first = context.getSharedPreferences("first", MODE_PRIVATE);
        String appid = Mainutiles.getAppID(first);
        String deviId = Mainutiles.getLocaldeviceId(context);
        int ver_code = Mainutiles.getVer_code(context);
        String tick = Mainutiles.getTick();
        String privateKey = Mainutiles.getPrivateKey(first);
        String  privateMd5 = Mainutiles.getHost(privateKey, appid, deviId, ver_code, tick);

        IRetorfit iRetrofit = Mainutiles.getRetorfitInterface(UrlConnect.BESE_URL);
        Observable<FistHander> observable = iRetrofit.getHost(appid, deviId, ver_code, tick, privateMd5);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FistHander>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FistHander fistHander) {
                        String url_host = fistHander.data.url_host;
                        first = context.getSharedPreferences("first", MODE_PRIVATE);
                        SharedPreferences.Editor edit = first.edit();
                        edit.putString("url_host",url_host);
                        edit.commit();
                        imainPresenter.notifyHost();
                    }
                });
    }
    /**
     * 免费课
     * @param
     */
public void getFreeClass(){
    Log.e("asd","getFreeClass");
    String appid = Mainutiles.getAppID(first);
    String deviId = Mainutiles.getLocaldeviceId(context);
    int ver_code = Mainutiles.getVer_code(context);
    String tick = Mainutiles.getTick();
    String privateKey = Mainutiles.getPrivateKey(first);
    String  privateMd5 = Mainutiles.getHost(privateKey, appid, deviId, ver_code,4,0,tick);
    String hostUrl = Mainutiles.getHostUrl(first);

    IRetorfit iRetrofit = Mainutiles.getRetorfitInterface(hostUrl);
    Observable<FistHander> observable = iRetrofit.getFreeClass(appid,deviId ,ver_code ,tick,4,0,privateMd5);
    observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<FistHander>() {
                @Override
                public void onCompleted() {
                    Log.e("getFreeClass","onCompleted");
                }

                @Override
                public void onError(Throwable e) {
                    Log.e("getFreeClass","onError");
                }

                @Override
                public void onNext(FistHander fistHander) {
                    Log.e("getFreeClass","onNext");
                    Log.e("getFreeClass","onNext:"+fistHander.data.tryX.size()+"");
                    imainPresenter.notifyFreeClass(fistHander);
                }
            });

    }

    /**
     * 轮播图
     * @param
     */
    public void getBanner(){
        first = context.getSharedPreferences("first", MODE_PRIVATE);
        String appid = Mainutiles.getAppID(first);
        String deviId = Mainutiles.getLocaldeviceId(context);
        int ver_code = Mainutiles.getVer_code(context);
        String tick = Mainutiles.getTick();
        String privateKey = Mainutiles.getPrivateKey(first);
        String  privateMd5 = Mainutiles.getHost(privateKey, appid, deviId, ver_code, tick);
       String hostUrl = Mainutiles.getHostUrl(first);

        IRetorfit iRetrofit = Mainutiles.getRetorfitInterface(hostUrl);
        Observable<FistHander> observable = iRetrofit.getBanner(appid,deviId ,ver_code ,tick,privateMd5);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FistHander>() {
                    @Override
                    public void onCompleted() {
                        Log.i("xxx","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("xxx","onError");
                    }

                    @Override
                    public void onNext(FistHander fistHander) {
                        imainPresenter.notifyBannerSuccess(fistHander);
                    }
                });





    }
/**
 * 精品课程列表
 */
public void getTopicList(){
    Log.e("top","getTopicList");
    first = context.getSharedPreferences("first", MODE_PRIVATE);
    String appid = Mainutiles.getAppID(first);
    String deviId = Mainutiles.getLocaldeviceId(context);
    int ver_code = Mainutiles.getVer_code(context);
    String tick = Mainutiles.getTick();
    String privateKey = Mainutiles.getPrivateKey(first);
    String  privateMd5 = Mainutiles.getHost(privateKey, appid, deviId, ver_code, 4,0,tick);
    String hostUrl = Mainutiles.getHostUrl(first);

    IRetorfit iRetrofit = Mainutiles.getRetorfitInterface(hostUrl);
    Observable<TopicClassAllBean> observable = iRetrofit.getTopicClass(appid,deviId ,ver_code ,tick,4,0,privateMd5);
    observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<TopicClassAllBean>() {
                @Override
                public void onCompleted() {
                    Log.e("top","onCompleted");
                }

                @Override
                public void onError(Throwable e) {
                    Log.e("top","onError");
                }

                @Override
                public void onNext(TopicClassAllBean topicClassAllBean) {
                    Log.e("top","onNext");
                    imainPresenter.notifyTopicClass(topicClassAllBean);
                }
            });
}
    /**
     * 第一次握手
     */
    public void getHeadData(){
        IRetorfit iRetrofit = Mainutiles.getRetorfitInterface(UrlConnect.BESE_URL);
        String sign = Mainutiles.getHost(UrlConnect.PUBLIC_KEY,"ANDROID", Mainutiles.getLocaldeviceId(context),Mainutiles.getVer_code(context),Mainutiles.getTick());
        Observable<FistHander> observable = iRetrofit.getFirstHand("ANDROID", Mainutiles.getLocaldeviceId(context), Mainutiles.getVer_code(context), Mainutiles.getTick(),sign);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FistHander>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FistHander fistHander) {
                        first = context.getSharedPreferences("first", MODE_PRIVATE);
                        SharedPreferences.Editor edit = first.edit();
                        edit.putString(UrlConnect.APP_ID,fistHander.data.app_id);
                        edit.putString(UrlConnect.PRIVATE_KEY,fistHander.data.private_key);
                        edit.commit();
                        imainPresenter.notifyFirstSuccess();

                    }
                });

    }
    /**
     * 注册
     */
    public void getReginInfo(String phoneNumber){
        first = context.getSharedPreferences("first", MODE_PRIVATE);
        String appid = Mainutiles.getAppID(first);
        String deviId = Mainutiles.getLocaldeviceId(context);
        int ver_code = Mainutiles.getVer_code(context);
        String tick = Mainutiles.getTick();
        String privateKey = Mainutiles.getPrivateKey(first);
        String sign=Mainutiles.getHost(privateKey,appid,deviId,ver_code,tick,phoneNumber);
        String hostUrl = Mainutiles.getHostUrl(first);
        IRetorfit iRetrofit = Mainutiles.getRetorfitInterface(hostUrl);
        Observable<FistHander> observable = iRetrofit.getRegin(appid, deviId, ver_code, tick, phoneNumber, sign);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FistHander>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(FistHander fistHander) {
                imainPresenter.notifyRegin(fistHander);
                Log.e("xxxxxx",fistHander.data.session);
            }
        });

    }
/**
 * 注册校验
 */
   public void getCheckRandInfo(String session,String moble,String pwd,String rand){
       first = context.getSharedPreferences("first", MODE_PRIVATE);
       String privateKey = Mainutiles.getPrivateKey(first);
       String appid = Mainutiles.getAppID(first);
       String deviId = Mainutiles.getLocaldeviceId(context);
       int ver_code = Mainutiles.getVer_code(context);
       String tick = Mainutiles.getTick();
       String sign=Mainutiles.getHost(privateKey,appid,deviId,ver_code,tick,session,rand,pwd);
       String hostUrl = Mainutiles.getHostUrl(first);

       IRetorfit iRetrofit = Mainutiles.getRetorfitInterface(hostUrl);
       Observable<FistHander> observable = iRetrofit.getCheckRand(appid, deviId, ver_code, tick, session, rand, pwd, sign);
       observable.subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<FistHander>() {
                   @Override
                   public void onCompleted() {

                   }

                   @Override
                   public void onError(Throwable e) {

                   }

                   @Override
                   public void onNext(FistHander fistHander) {
                       imainPresenter.notifyCheckRand(fistHander);
                   }
               });
   }
    /**
     * 登陆
     */
    public void getLoinInfo(String pwd,String mob){
        Log.e("getLoinInfo",pwd+"--"+mob);
        first = context.getSharedPreferences("first", MODE_PRIVATE);
        String privateKey = Mainutiles.getPrivateKey(first);
        String appid = Mainutiles.getAppID(first);
        String deviId = Mainutiles.getLocaldeviceId(context);
        int ver_code = Mainutiles.getVer_code(context);
        String tick = Mainutiles.getTick();
        String sign=Mainutiles.getHost(privateKey,appid,deviId,ver_code,tick,mob,pwd);
        String hostUrl = Mainutiles.getHostUrl(first);

        IRetorfit iRetrofit = Mainutiles.getRetorfitInterface(hostUrl);
        Observable<LoginBean> observable = iRetrofit.getLogin(appid, deviId, ver_code, tick,mob, pwd, sign);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("getLoinInfo","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getLoinInfo","onError");
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        Log.e("getLoinInfo","onNext");
                        Log.e("getLoinInfo",loginBean.data.alert+"成功");
                        imainPresenter.notifyLogin(loginBean);
                    }
                });
    }
    /**
     * 详情
     */
    public void getDetail(String objectId){
        first = context.getSharedPreferences("first", MODE_PRIVATE);
        String session=null;
        String privateKey = Mainutiles.getPrivateKey(first);
        String appid = Mainutiles.getAppID(first);
        String deviId = Mainutiles.getLocaldeviceId(context);
        int ver_code = Mainutiles.getVer_code(context);
        String tick = Mainutiles.getTick();
        String sign=Mainutiles.getHost(privateKey,appid,deviId,ver_code,tick,objectId);
        String hostUrl = Mainutiles.getHostUrl(first);

        IRetorfit iRetrofit = Mainutiles.getRetorfitInterface(hostUrl);
        Observable<FistHander> observable = iRetrofit.getDetail(appid, deviId, ver_code, tick, objectId, sign);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FistHander>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FistHander fistHander) {
                        imainPresenter.notifyDetail(fistHander);
                    }
                });
    }
}
