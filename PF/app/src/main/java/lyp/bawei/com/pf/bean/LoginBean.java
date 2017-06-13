package lyp.bawei.com.pf.bean;

/**
 * Created by Administrator on 2017/6/2.
 */

public class LoginBean {
    /**
     * data : {"alert":false,"message":" ୨໛מ௳","session":"5559936945f96e05efbbf344"}
     * ret : 0
     */

    public DataBean data;
    public int ret;

    public static class DataBean {
        /**
         * alert : false
         * message :  ୨໛מ௳
         * session : 5559936945f96e05efbbf344
         */

        public boolean alert;
        public String message;
        public String session;
    }
}
