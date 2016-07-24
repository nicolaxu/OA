package com.lanshui.oa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.lanshui.oa.R;
import com.lanshui.oa.utils.Constants;
import com.lanshui.oa.utils.Preference;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/7/14 0014.
 */
public class WelcomeActivity extends BaseActivity {

    public boolean pass = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //检测密码的正确性
        checkUserLogin();

        //开启一个2秒的timertask
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(pass){
                    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task,2000);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //重写父类的返回按钮事件
        return true;
    }

    public void checkUserLogin(){

        String username = Preference.newInstance(this).getString("username",null);
        String password = Preference.newInstance(this).getString("password",null);
        if(username != null){
            Log.d("you","这里有错误");
            RequestParams params = new RequestParams(Constants.USERLOGIN_URL);
            params.addBodyParameter("username",username);
            params.addBodyParameter("password",password);
            params.setConnectTimeout(2000);
            x.http().post(params, new Callback.CommonCallback<Object>() {
                @Override
                public void onSuccess(Object o) {
                    pass = true;
                }

                @Override
                public void onError(Throwable throwable, boolean b) {
                    pass = false;
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
}
