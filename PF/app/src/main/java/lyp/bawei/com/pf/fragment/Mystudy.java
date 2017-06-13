package lyp.bawei.com.pf.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import lyp.bawei.com.pf.MainActivity;

import lyp.bawei.com.pf.R;
import lyp.bawei.com.pf.adapter.FreeClassAdapter;
import lyp.bawei.com.pf.bean.FistHander;
import lyp.bawei.com.pf.bean.FistHander;
import lyp.bawei.com.pf.bean.TopicClassAllBean;
import lyp.bawei.com.pf.myInterface.Iview;
import lyp.bawei.com.pf.presenter.Mypresenter;
import lyp.bawei.com.pf.utiles.CustomGridView;
import lyp.bawei.com.pf.utiles.CustomListView;
import lyp.bawei.com.pf.utiles.Image;
import lyp.bawei.com.pf.view.BaseFragment;
import lyp.bawei.com.pf.view.DetailActivity;

/**
 * Created by Administrator on 2017/5/23.
 */

public class Mystudy extends BaseFragment {
    @BindView(R.id.stu_pagerbanner)
    Banner stuPagerbanner;
    @BindView(R.id.stu_pager_mf_iamge)
    ImageView stuPagerMfIamge;
    @BindView(R.id.stu_pager_mf_lookall)
    RelativeLayout stuPagerMfLookall;
    @BindView(R.id.stu_pager_lv_free)
    CustomListView stuPagerLvFree;
    @BindView(R.id.stu_pager_jx_iamge)
    ImageView stuPagerJxIamge;
    @BindView(R.id.stu_pager_jxlookall)
    RelativeLayout stuPagerJxlookall;
    @BindView(R.id.stu_pager_lv_choiceness)
    CustomListView stuPagerLvChoiceness;
    @BindView(R.id.stu_pager_zj_iamge)
    ImageView stuPagerZjIamge;
    @BindView(R.id.stu_pager_jp_lookall)
    RelativeLayout stuPagerJpLookall;
    @BindView(R.id.stu_pager_lv_special)
    CustomGridView stuPagerLvSpecial;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.stu_pager_layout, null);

        unbinder = ButterKnife.bind(this, inflate);
        Mypresenter mypresenter = new Mypresenter(this, getActivity());
        mypresenter.getBanner();
        mypresenter.getFreeClass();
        showAllTopicClass(mypresenter);
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void showAllTopicClass(Mypresenter mypresenter) {
        stuPagerJxlookall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment mystudy = fragmentManager.findFragmentByTag("mystudy");
                Fragment myclsaa = fragmentManager.findFragmentByTag("myclsaa");
                Fragment myself = fragmentManager.findFragmentByTag("myself");
                Fragment mystudy_jx = fragmentManager.findFragmentByTag("mystudy_jx");
                fragmentTransaction.show(mystudy_jx);
                fragmentTransaction.hide(myself);
                fragmentTransaction.hide(mystudy);
                fragmentTransaction.hide(myclsaa);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void showBannerData(FistHander firstHender) {
        Log.i("xxx", firstHender.data.banner.size() + "");
        List<FistHander.DataBean.BannerBean> banner = firstHender.data.banner;
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < banner.size(); i++) {
            list.add(banner.get(i).image);
        }
        stuPagerbanner.setImageLoader(new Image());
//设置图片集合
        stuPagerbanner.setImages(list);
//banner设置方法全部调用完毕时最后调用
        stuPagerbanner.start();
    }

    @Override
    public void showFreeClass(FistHander fistHander) {
        Log.e("asd", fistHander.data.tryX.get(0).title2);
        List<FistHander.DataBean.TryBean> tryX = fistHander.data.tryX;

        FreeClassAdapter freeClassAdapter = new FreeClassAdapter(getActivity(), tryX);
        stuPagerLvFree.setAdapter(freeClassAdapter);
        getClick(fistHander);
    }
    public void getClick(final FistHander fistHander){
        stuPagerLvFree.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("id",fistHander.data.tryX.get(position).object_id);
                Log.i("???","id:"+fistHander.data.tryX.get(position).object_id);
                getActivity().startActivity(intent);
            }
        });
    }


}
