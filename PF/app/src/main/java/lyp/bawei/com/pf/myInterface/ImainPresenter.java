package lyp.bawei.com.pf.myInterface;

import lyp.bawei.com.pf.bean.FistHander;
import lyp.bawei.com.pf.bean.LoginBean;
import lyp.bawei.com.pf.bean.TopicClassAllBean;

/**
 * Created by Administrator on 2017/5/25.
 */

public interface ImainPresenter {
    //轮播调用
    void notifyBannerSuccess(FistHander firstHender);
    //精选课程
    void notifyTopicClass(TopicClassAllBean topicClassAllBean);
    //第一次握手调用的接口
    void notifyFirstSuccess();
   // 导向调用的接口
   void notifyHost();
    //免费课程
    void notifyFreeClass(FistHander fistHander);
    //注册
    void notifyRegin(FistHander fistHander);
    //注册校验
    void notifyCheckRand(FistHander fistHander);
    //登陆
    void notifyLogin(LoginBean loginBean);
    //详情
    void notifyDetail(FistHander fistHander);
}
