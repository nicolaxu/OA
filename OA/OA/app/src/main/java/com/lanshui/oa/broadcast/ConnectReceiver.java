package com.lanshui.oa.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.lanshui.oa.R;

/**
 * Created by Administrator on 2016/7/15 0015.
 * network listener
 */
public class ConnectReceiver extends BroadcastReceiver {

    private ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;
    NetworkInfo networkInfo1;

    @Override
    public void onReceive(Context context, Intent intent) {

        connectivityManager =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        networkInfo1 = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if(!networkInfo.isConnected() && !networkInfo1.isConnected()){
            Log.d("you","网络链接断开");
            Toast.makeText(context,context.getResources().getString(R.string.network_disconnected),Toast.LENGTH_SHORT).show();

        }else{
            Log.d("you","网络链接正常");
            //Toast.makeText(context,context.getResources().getString(R.string.network_connected),Toast.LENGTH_SHORT).show();
        }
    }
}
