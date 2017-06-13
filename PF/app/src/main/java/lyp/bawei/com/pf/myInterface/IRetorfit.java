package lyp.bawei.com.pf.myInterface;

import java.util.HashMap;

import lyp.bawei.com.pf.bean.FistHander;
import lyp.bawei.com.pf.bean.LoginBean;
import lyp.bawei.com.pf.bean.TopicClassAllBean;
import lyp.bawei.com.pf.utiles.UrlConnect;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Administrator on 2017/5/25.
 */

public interface IRetorfit {
@POST(UrlConnect.FRIST_HAND)
@FormUrlEncoded
Observable<FistHander> getFirstHand(@Field("type") String type, @Field("dev_id")String dev_id, @Field("ver_code")int ver_code, @Field("tick")String tick, @Field("sign")String sign);



@POST(UrlConnect.GED_HOST)
@FormUrlEncoded
Observable<FistHander> getHost(@Field("app_id") String app_id, @Field("dev_id")String dev_id, @Field("ver_code")int ver_code, @Field("tick")String tick, @Field("sign")String sign);



    @POST(UrlConnect.LISD_BNNER)
    @FormUrlEncoded
    Observable<FistHander> getBanner(@Field("app_id") String app_id, @Field("dev_id")String dev_id, @Field("ver_code")int ver_code, @Field("tick")String tick, @Field("sign")String sign);



    @POST(UrlConnect.LIST_TRY)
    @FormUrlEncoded
    Observable<FistHander> getFreeClass(@Field("app_id") String app_id, @Field("dev_id")String dev_id, @Field("ver_code")int ver_code, @Field("tick")String tick, @Field("page_size")int page_size,@Field("page_index")int page_index,@Field("sign")String sign);


@POST(UrlConnect.LIST_TOPIC)
@FormUrlEncoded
Observable<TopicClassAllBean> getTopicClass(@Field("app_id") String app_id, @Field("dev_id")String dev_id, @Field("ver_code")int ver_code, @Field("tick")String tick, @Field("page_size")int page_size, @Field("page_index")int page_index, @Field("sign")String sign);

    //注册接口
@POST(UrlConnect.USER_REGIN)
@FormUrlEncoded
Observable<FistHander> getRegin(@Field("app_id")String app_id,@Field("dev_id")String dev_id,@Field("ver_code")int ver_code,@Field("tick")String tick,@Field("mobile")String mobile,@Field("sign")String sign);

    //注册校验
    @POST(UrlConnect.CHECK_RAND)
    @FormUrlEncoded
    Observable<FistHander> getCheckRand(@Field("app_id")String app_id,@Field("dev_id")String dev_id,@Field("ver_code")int ver_code,@Field("tick")String tick,@Field("session")String session,@Field("rand")String rand,@Field("passwd")String passwd,@Field("sign")String sign);

    //密码登陆
    @POST(UrlConnect.PWD_LOIN)
    @FormUrlEncoded
    Observable<LoginBean> getLogin(@Field("app_id")String app_id, @Field("dev_id")String dev_id, @Field("ver_code")int ver_code, @Field("tick")String tick, @Field("mobile")String mobile, @Field("passwd")String passwd, @Field("sign")String sign);
//详情页面
@POST(UrlConnect.DETAIL_COURSE)
@FormUrlEncoded
Observable<FistHander> getDetail(@Field("app_id")String app_id, @Field("dev_id")String dev_id, @Field("ver_code")int ver_code, @Field("tick")String tick,  @Field("object_id")String object_id, @Field("sign")String sign);

}
