package lyp.bawei.com.pf.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lyp.bawei.com.pf.R;
import lyp.bawei.com.pf.bean.FistHander;
import lyp.bawei.com.pf.bean.LoginBean;
import lyp.bawei.com.pf.presenter.Mypresenter;
import lyp.bawei.com.pf.utiles.Mainutiles;

/**
 * Created by Administrator on 2017/6/1.
 */

public class LoginActivity extends BaseActivity {


    @BindView(R.id.login_return)
    ImageView loginReturn;
    @BindView(R.id.login_img)
    ImageView loginImg;
    @BindView(R.id.login_tel)
    EditText loginTel;

    @BindView(R.id.login_pwd)
    EditText login_pwd;
    @BindView(R.id.regin_noShowPwd)
    ImageView reginNoShowPwd;
    @BindView(R.id.login_forgetPwd)
    TextView loginForgetPwd;
    @BindView(R.id.login_login)
    Button loginLogin;
    @BindView(R.id.login_regin)
    Button loginRegin;
    @BindView(R.id.login_weChat)
    TextView loginWeChat;
    @BindView(R.id.login_QQ)
    TextView loginQQ;
    private Mypresenter mypresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        ButterKnife.bind(this);
        mypresenter = new Mypresenter(this, LoginActivity.this);


    }

    @OnClick({R.id.login_login, R.id.login_regin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_login:

                String pwd = login_pwd.getText().toString();
                String mob = loginTel.getText().toString();
                Log.e("xxx","view中pwd"+pwd);
                mypresenter.getLoinInfo(pwd,mob);
                break;
            case R.id.login_regin:
                Intent intent = new Intent(this, ReginActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void showPwdLogin(LoginBean loginBean) {
        Log.e("xxxView","showPwdLogin");
        Toast.makeText(this,loginBean.data.session, Toast.LENGTH_SHORT).show();
    }
}
