package lyp.bawei.com.pf.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */

public class FistHander {

        /**
         * ret : 0
         * data : {"app_id":"B406A2EF","private_key":"AEF63FBAEDD31000F25FAD2E4C3C2974"}
         */

        public int ret;
        public DataBean data;

        public  class DataBean {
            /**
             * app_id : B406A2EF
             * private_key : AEF63FBAEDD31000F25FAD2E4C3C2974
             */

            public String app_id;
            public String private_key;
            public String url_host;
            public List<BannerBean> banner;

            public String page_index;
            public int total;
            public String page_size;
            @SerializedName("try")
            public List<TryBean> tryX;

            public String session;
            public boolean login ;
            public boolean alert ;
            public  String message ;
            public  String uname ;
//详情页
            @SerializedName("abstract")
            public String abstractX;
            public int comment_num;
            public String course_video;
            public int exam_score;
            public String object_id;
            public String service_tel;
            public String speaker_audio;
            public String speaker_head;
            public String title;
            public String title2;
            public int try_length;
            public int volume;

            public  class BannerBean {
                public String click;
                public String image;
            }


            public  class TryBean {
                public String title2;
                public String speaker;
                public String title;
                public int try_time;
                public String image;
                public int type;
                public int length;
                public String object_id;
            }
        }
}
