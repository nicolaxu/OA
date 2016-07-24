package com.lanshui.oa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lanshui.oa.R;
import com.lanshui.oa.utils.Constants;
import com.lanshui.oa.utils.Preference;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2016/7/14 0014.
 */
public class LoginActivity extends BaseActivity {

    private boolean isFisrt;
    private boolean pass;

    @ViewInject(R.id.bt_login)
    private Button mLogin;

    @ViewInject(R.id.et_username)
    private EditText mEtUsername;

    @ViewInject(R.id.et_password)
    private EditText mEtPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        x.view().inject(this);
    }

    @Event(value = {R.id.bt_login},type = View.OnClickListener.class)
    private void onClick(View view){
        switch (view.getId()){
            case R.id.bt_login:

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }


    private void checkUser(){
        String username = (Preference.newInstance(this)).getString("username","");
        String password = (Preference.newInstance(this)).getString("password","");
        if(username == ""){
            isFisrt = true;
        }else{
            mEtUsername.setText(username);
            mEtPassword.setText(password);
        }
    }

    private void doUserLogin(){
        RequestParams params = new RequestParams(Constants.USERLOGIN_URL);
        params.addBodyParameter("username",mEtUsername.getText().toString());
        params.addBodyParameter("password",mEtPassword.getText().toString());
        params.setConnectTimeout(4000);
        x.http().post(params, new Callback.CommonCallback<Object>() {
            @Override
            public void onSuccess(Object o) {

            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                Log.d("you",throwable.toString());
            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
