package lyp.bawei.com.pf.utiles;

/**
 * Use:封装所有的数据接口
 * Author:陈懿鹏
 * Data:2017/5/18.
 */

public class UrlConnect {
    //后台公钥
    public static final String PUBLIC_KEY="312045ED9D036BEED16E96F3878E222ED7E58AC9";
    //appid 键值
    public static final String APP_ID="app_id";
    //privare_key 键值
    public static final String PRIVATE_KEY="private_key";
    //首次安装键值
    public static final String ISFIRSTINSTALL="is_first_install";

    //BASEURL
    public static final String BESE_URL="https://pretty.f8cam.com:17211";
    //手次握手
    public static final String FRIST_HAND="/app/v1/first_hand";

    //连接向导
    public static final String GED_HOST="/app/v1/get_host";

    //首页轮播图
    public static final String LISD_BNNER="/app/v1/list_banner";
    //免费试听课
    public static final String LIST_TRY="/app/v1/list_try";
//精品专辑类表
    public static final String LIST_TOPIC="/app/v1/list_topic";
//注册
public static final String USER_REGIN="/app/v1/user_reg";
//注册校验
public static final String CHECK_RAND="/app/v1/user_check_rand";
    //登陆
    public static final String PWD_LOIN="/app/v1/user_pwd_login";
    //课程详情
    public static final String DETAIL_COURSE="/app/v1/detail_course";
}
