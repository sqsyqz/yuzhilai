package lyp.bawei.com.pf.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lyp.bawei.com.pf.R;
import lyp.bawei.com.pf.bean.FistHander;
import lyp.bawei.com.pf.presenter.Mypresenter;

/**
 * Created by Administrator on 2017/6/1.
 */

public class ReginActivity extends BaseActivity {


    @BindView(R.id.regin_regin)
    Button reginRegin;
    @BindView(R.id.regin_tel)
    EditText reginTel;
    @BindView(R.id.regin_Editcheck)
    EditText reginEditcheck;
    @BindView(R.id.regin_pwd)
    EditText reginPwd;
    private Mypresenter mypresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regin_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.regin_regin)
    public void onViewClicked() {
        mypresenter = new Mypresenter(this, ReginActivity.this);
        String phoneNumber = reginTel.getText().toString();
        mypresenter.getRegin(phoneNumber);

    }

    @Override
    public void showRegin(FistHander fistHander) {
        String session = fistHander.data.session;
        String moble = reginTel.getText().toString();
        String pwd = reginPwd.getText().toString();
        String rand = reginEditcheck.getText().toString();
        mypresenter.getCheckRand(session,moble,pwd,rand);
    }

    @Override
    public void showCheckRand(FistHander fistHander) {
        if (fistHander.data.login){
            Toast.makeText(this, fistHander.data.message+"注册成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
        }

    }
}
