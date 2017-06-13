package lyp.bawei.com.pf.myInterface;

import lyp.bawei.com.pf.bean.FistHander;
import lyp.bawei.com.pf.bean.LoginBean;
import lyp.bawei.com.pf.bean.TopicClassAllBean;

/**
 * Created by Administrator on 2017/5/25.
 */

public interface Iview {
    void showBannerData(FistHander firstHender);
    void shouwFirstSuccess();
    void showHost();
    void showFreeClass(FistHander fistHander);
    void shouwTopicAllClass(TopicClassAllBean topicClassAllBean);
    void showRegin(FistHander fistHander);
    void showCheckRand(FistHander fistHander);
    void showPwdLogin(LoginBean loginBean);
    void showDetail(FistHander fistHander);
}
