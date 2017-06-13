package lyp.bawei.com.pf.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import lyp.bawei.com.pf.R;
import lyp.bawei.com.pf.bean.FistHander;
import lyp.bawei.com.pf.presenter.Mypresenter;

/**
 * Created by Administrator on 2017/6/5.
 */

public class DetailActivity extends BaseActivity {

    @BindView(R.id.detail_video)
    JCVideoPlayerStandard detailVideo;
    @BindView(R.id.detail_return)
    ImageView detailReturn;
    @BindView(R.id.detail_share)
    ImageView detailShare;
    @BindView(R.id.detail_Img_Text2)
    TextView detailImgText2;
    @BindView(R.id.detail_buy)
    Button detailBuy;
    @BindView(R.id.detail_buy_ll)
    LinearLayout detailBuyLl;
    @BindView(R.id.detail_img)
    Button detailImg;
    @BindView(R.id.detail_tryend_tobuy)
    LinearLayout detailTryendTobuy;
    @BindView(R.id.detail_teacherImg)
    ImageView detailTeacherImg;
    @BindView(R.id.detail_teacherName)
    TextView detailTeacherName;
    @BindView(R.id.detail_listner)
    ImageView detailListner;
    @BindView(R.id.detail_title1)
    TextView detailTitle1;
    @BindView(R.id.detail_title2)
    TextView detailTitle2;
    @BindView(R.id.detail_showNum)
    TextView detailShowNum;
    @BindView(R.id.detail_content)
    TextView detailContent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_main);
        ButterKnife.bind(this);

        Mypresenter mypresenter = new Mypresenter(this, DetailActivity.this);
        String objectId = getObjectId();
        mypresenter.getDetail(objectId);
        getPay();
    }
    public void getPay(){
        detailImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent intent=new Intent(DetailActivity.this,PayActivity.class);
                startActivity(intent);
            }
        });
    }

    public String getObjectId() {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Log.i("???V",id);
        return id;
    }

    @Override
    public void showDetail(FistHander fistHander) {
        super.showDetail(fistHander);
        Log.i("???Video",fistHander.data.course_video);

        detailVideo.setUp(fistHander.data.course_video,"");
        ImageView thumbImageView = detailVideo.thumbImageView;
        thumbImageView.setImageResource(R.drawable.white_radius);
        detailVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailBuyLl.setVisibility(View.INVISIBLE);
            }
        });
    }

    @OnClick({R.id.detail_buy, R.id.detail_img})
    public void onViewClicked(View view) {
        Intent intent=new Intent(this,PayActivity.class);
        switch (view.getId()) {
            case R.id.detail_buy:
                intent.putExtra("price","0.01");
                startActivity(intent);
                break;
            case R.id.detail_img:
                intent.putExtra("price","0.01");
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        detailVideo.releaseAllVideos();
    }
}
