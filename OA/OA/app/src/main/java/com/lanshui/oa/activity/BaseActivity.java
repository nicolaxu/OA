package com.lanshui.oa.activity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lanshui.oa.R;
import com.lanshui.oa.application.OaApplication;
import com.lanshui.oa.broadcast.ConnectReceiver;

/**
 * Created by Administrator on 2016/7/14 0014.
 */
public class BaseActivity extends AppCompatActivity {

    private long firstDownTime = 0;
    private ConnectReceiver connectReceiver;
    private OaApplication oaApplication;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerReceiver2();
        if(oaApplication == null){
            oaApplication = (OaApplication) getApplication();
        }

        oaApplication.addActivity(this);
    }

    @Override
    public void onDestroy() {
        this.unregisterReceiver(connectReceiver);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if(oaApplication.getSize() == 1){
            if(System.currentTimeMillis() - firstDownTime < 2000){
                finish();
            }else{
                firstDownTime = System.currentTimeMillis();
                Toast.makeText(this,getResources().getString(R.string.twice_click),Toast.LENGTH_SHORT).show();
            }
        }else{
            super.onBackPressed();
        }
    }

    public void registerReceiver2(){
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        connectReceiver = new ConnectReceiver();

        this.registerReceiver(connectReceiver,filter);
    }

    /**
     * override the finish method
     */
    @Override
    public void finish() {
        super.finish();
        if(oaApplication != null){
            oaApplication.removeActivity(this);
        }
    }
}
