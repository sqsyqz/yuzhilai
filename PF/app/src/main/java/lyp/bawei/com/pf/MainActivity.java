package lyp.bawei.com.pf;


import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lyp.bawei.com.pf.bean.FistHander;
import lyp.bawei.com.pf.bean.TopicClassAllBean;
import lyp.bawei.com.pf.fragment.Myclsaa;
import lyp.bawei.com.pf.fragment.Myself;
import lyp.bawei.com.pf.fragment.Mystudy;
import lyp.bawei.com.pf.fragment.Mystudy_jx;
import lyp.bawei.com.pf.myInterface.Iview;
import lyp.bawei.com.pf.presenter.Mypresenter;
import lyp.bawei.com.pf.utiles.Mainutiles;
import lyp.bawei.com.pf.view.BaseActivity;


public class MainActivity extends BaseActivity {
    @BindView(R.id.main_frame)
    FrameLayout mainFrame;
    @BindView(R.id.main_frame_rb_stu)
    RadioButton mainFrameRbStu;
    @BindView(R.id.main_frame_rb_cla)
    RadioButton mainFrameRbCla;
    @BindView(R.id.main_frame_rb_my)
    RadioButton mainFrameRbMy;
    @BindView(R.id.main_pager_rg)
    RadioGroup mainPagerRg;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    private FragmentManager supportFragmentManager;
    private Myclsaa myclsaa;
    private Myself myself;
    private Mystudy mystudy;
    private Mypresenter mypresenter;
    private Mystudy_jx mystudy_jx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        saveHeadData();

    }

    private void getFragment() {
        myclsaa = new Myclsaa();
        myself = new Myself();
        mystudy = new Mystudy();
        mystudy_jx = new Mystudy_jx();
        supportFragmentManager = getSupportFragmentManager();
//开启事物
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//添加到布局
        fragmentTransaction.add(R.id.main_frame, mystudy, "mystudy");
        fragmentTransaction.add(R.id.main_frame, myclsaa, "myclsaa");
        fragmentTransaction.add(R.id.main_frame, myself, "myself");
        fragmentTransaction.add(R.id.main_frame, mystudy_jx, "mystudy_jx");
//控制隐藏显示
        fragmentTransaction.show(mystudy);
        fragmentTransaction.hide(myclsaa);
        fragmentTransaction.hide(myself);
        fragmentTransaction.hide(mystudy_jx);
//提交事务
        fragmentTransaction.commit();
        mainPagerRg.check(R.id.main_frame_rb_stu);

    }

    //是否是第一次登陆
    public void saveHeadData() {
        mypresenter = new Mypresenter(this, MainActivity.this);
        SharedPreferences first = getSharedPreferences("first", MODE_PRIVATE);
        boolean flag = first.getBoolean("flag", false);
        if (!flag) {
            SharedPreferences.Editor edit = first.edit();
            mypresenter.getHeadData();
            edit.putBoolean("flag", true);
            edit.commit();

        } else {
            mypresenter.getHostData();

        }

    }

    @OnClick({R.id.main_frame_rb_stu, R.id.main_frame_rb_cla, R.id.main_frame_rb_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_frame_rb_stu:
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.show(mystudy);
                fragmentTransaction.hide(myclsaa);
                fragmentTransaction.hide(myself);
                fragmentTransaction.hide(mystudy_jx);
                fragmentTransaction.commit();
                break;
            case R.id.main_frame_rb_cla:
                FragmentTransaction fragmentTransaction2 = supportFragmentManager.beginTransaction();
                fragmentTransaction2.show(myclsaa);
                fragmentTransaction2.hide(mystudy);
                fragmentTransaction2.hide(myself);
                fragmentTransaction2.hide(mystudy_jx);
                fragmentTransaction2.commit();
                break;
            case R.id.main_frame_rb_my:
                FragmentTransaction fragmentTransaction3 = supportFragmentManager.beginTransaction();
                fragmentTransaction3.show(myself);
                fragmentTransaction3.hide(mystudy);
                fragmentTransaction3.hide(myclsaa);
                fragmentTransaction3.hide(mystudy_jx);
                fragmentTransaction3.commit();
                break;
        }
    }

    @Override
    public void shouwFirstSuccess() {
        mypresenter.getHostData();
    }

    @Override
    public void showHost() {
        getFragment();
    }


}
