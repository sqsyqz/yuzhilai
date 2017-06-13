package lyp.bawei.com.pf.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/28.
 */

public class TopicClassAllBean {
    /**
     * data : {"page_index":0,"page_size":2,"topic":[{"image":"http://\u2026../image.png","length":5,"object_id":"100001","title":"ӫᬋຽ᷌","title2":"ӫᬋۅຽ᷌","type":1,"speaker":"ᦖ૵ݷ"},{"image":"http://\u2026../image.png","length":5,"object_id":"100001","speaker":"ᦖ૵ݷ","title":"ӫᬋຽ᷌","title2":"ӫᬋۅຽ᷌","type":2}],"total":2}
     * ret : 0
     */

    public DataBean data;
    public int ret;

    public static class DataBean {
        /**
         * page_index : 0
         * page_size : 2
         * topic : [{"image":"http://\u2026../image.png","length":5,"object_id":"100001","title":"ӫᬋຽ᷌","title2":"ӫᬋۅຽ᷌","type":1},{"image":"http://\u2026../image.png","length":5,"object_id":"100001","speaker":"ᦖ૵ݷ","title":"ӫᬋຽ᷌","title2":"ӫᬋۅຽ᷌","type":2}]
         * total : 2
         */

        public int page_index;
        public int page_size;
        public int total;
        public List<TopicBean> topic;

        public static class TopicBean {
            /**
             * image : http://…../image.png
             * length : 5
             * object_id : 100001
             * title : ӫᬋຽ᷌
             * title2 : ӫᬋۅຽ᷌
             * type : 1
             * speaker : ᦖ૵ݷ
             */

            public String image;
            public int length;
            public String object_id;
            public String title;
            public String title2;
            public int type;
            public String speaker;
        }
    }
}
