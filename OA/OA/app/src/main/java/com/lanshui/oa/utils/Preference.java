package com.lanshui.oa.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/7/15 0015.
 */
public class Preference {

    private static SharedPreferences instance;

    private Preference(Context context){

    }


    public static SharedPreferences newInstance(Context context){
        if(instance == null){
            instance = context.getSharedPreferences("oa",Context.MODE_PRIVATE);
        }

        return instance;
    }
}
