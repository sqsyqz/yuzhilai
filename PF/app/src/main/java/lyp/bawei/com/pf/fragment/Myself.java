package lyp.bawei.com.pf.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import lyp.bawei.com.pf.R;
import lyp.bawei.com.pf.view.LoginActivity;

/**
 * Created by Administrator on 2017/5/23.
 */

public class Myself extends Fragment {
    @BindView(R.id.my_pager_himage)
    ImageButton myPagerHimage;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.my_pager_layout, null);

        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.my_pager_himage)
    public void onViewClicked() {
        Intent intent=new Intent(getActivity(),LoginActivity.class);
        startActivity(intent);
    }
}
