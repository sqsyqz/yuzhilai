package lyp.bawei.com.pf.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import lyp.bawei.com.pf.R;
import lyp.bawei.com.pf.adapter.TopicClassAdapter;

import lyp.bawei.com.pf.bean.TopicClassAllBean;

import lyp.bawei.com.pf.presenter.Mypresenter;
import lyp.bawei.com.pf.view.BaseFragment;
import lyp.bawei.com.pf.view.DetailActivity;
import lyp.bawei.com.pf.view.ZhuanjiDateile;

/**
 * Created by Administrator on 2017/5/28.
 */

public class Mystudy_jx extends BaseFragment{


    @BindView(R.id.jx_all_listview)
    ListView jxAllListview;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.quality_all_class_layout, null);
        unbinder = ButterKnife.bind(this, inflate);
        Mypresenter mypresenter = new Mypresenter(this, getActivity());
        mypresenter.getTopicClass();

        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }



    @Override
    public void shouwTopicAllClass(TopicClassAllBean topicClassAllBean) {
        Log.e("topicClassAllBean",topicClassAllBean.data.topic.get(0).image);
        List<TopicClassAllBean.DataBean.TopicBean> topic = topicClassAllBean.data.topic;
        TopicClassAdapter topicClassAdapter = new TopicClassAdapter(getActivity(), topic);
        jxAllListview.setAdapter(topicClassAdapter);
        itemClick();
    }
public void itemClick(){
    jxAllListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent=new Intent(getActivity(), ZhuanjiDateile.class);
            startActivity(intent);
        }
    });
}
}
