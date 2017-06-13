package lyp.bawei.com.pf.presenter;

import android.content.Context;
import android.util.Log;

import lyp.bawei.com.pf.bean.FistHander;
import lyp.bawei.com.pf.bean.LoginBean;
import lyp.bawei.com.pf.bean.TopicClassAllBean;
import lyp.bawei.com.pf.moudle.MainMoudler;
import lyp.bawei.com.pf.myInterface.ImainPresenter;
import lyp.bawei.com.pf.myInterface.Iview;
import lyp.bawei.com.pf.utiles.Mainutiles;

/**
 * Created by Administrator on 2017/5/25.
 */

public class Mypresenter implements ImainPresenter {
    private Iview iview;
    private MainMoudler mainMoudler;

    public Mypresenter(Iview iview, Context context) {
        this.iview = iview;
        mainMoudler = new MainMoudler(this, context);
    }

    //第一次握手
    public void getHeadData() {
        mainMoudler.getHeadData();
    }

    //导向
    public void getHostData() {
        mainMoudler.getHost();
    }

    //轮播
    public void getBanner() {
        mainMoudler.getBanner();
    }

    //免费课
    public void getFreeClass() {
        Log.e("asd", "getFreeClass");
        mainMoudler.getFreeClass();
    }
//注册
   public void getRegin(String phoneNumber){
       Log.e("xxxxxx",phoneNumber);
       mainMoudler.getReginInfo(phoneNumber);
   }
    //注册校验
   public void getCheckRand(String session,String moble,String pwd,String rand){
       mainMoudler.getCheckRandInfo(session,moble,pwd,rand);
   }
    //登陆
    public void getLoinInfo(String pwd,String mob){
        Log.e("xxx","getLoinInfo");
        mainMoudler.getLoinInfo(pwd,mob);
    }
    //详情
    public void getDetail(String objectId){
        mainMoudler.getDetail(objectId);
    }
    //轮播
    @Override
    public void notifyBannerSuccess(FistHander firstHender) {
        iview.showBannerData(firstHender);
    }

    //全部精选课
    @Override
    public void notifyTopicClass(TopicClassAllBean topicClassAllBean) {
        iview.shouwTopicAllClass(topicClassAllBean);
    }


    public void getTopicClass() {
        mainMoudler.getTopicList();
    }


    //第一次握手
    @Override
    public void notifyFirstSuccess() {
        iview.shouwFirstSuccess();
    }

    //导向
    @Override
    public void notifyHost() {

        iview.showHost();
    }

    @Override
    public void notifyFreeClass(FistHander fistHander) {
        iview.showFreeClass(fistHander);
    }
//注册
    @Override
    public void notifyRegin(FistHander fistHander) {
        iview.showRegin(fistHander);
    }
//注册校验
    @Override
    public void notifyCheckRand(FistHander fistHander) {
        iview.showCheckRand(fistHander);
    }
//密码登陆
    @Override
    public void notifyLogin(LoginBean loginBean) {
        Log.e("ddd","notifyLogin");
        iview.showPwdLogin(loginBean);
    }
//详情
    @Override
    public void notifyDetail(FistHander fistHander) {
        iview.showDetail(fistHander);
    }
}
