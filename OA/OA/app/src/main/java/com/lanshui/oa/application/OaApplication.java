package com.lanshui.oa.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.lanshui.oa.utils.Constants;

import java.util.Stack;

/**
 * Created by Administrator on 2016/7/18 0018.
 */
public class OaApplication extends Application {

    public static Stack<Activity> activities;
    private boolean DEBUG = true;

    @Override
    public void onCreate() {
        super.onCreate();
        activities = new Stack<Activity>();

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                if(Constants.DEBUGMODE && DEBUG){
                    Log.d("oa",activity.getClass().getSimpleName()+" is Created");
                }
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    public void addActivity(Activity activity) {
        if (activity != null && activities != null) {
            activities.add(activity);
        }

        if(Constants.DEBUGMODE && DEBUG){
            Log.d("you", "the last add is "
                    + activity.getClass().getSimpleName()
                    + "the stack size is "+activities.size());
        }
    }

    public void removeActivity(Activity activity){
        if(activity != null && activities.contains(activity)){
            activities.remove(activity);
            activity.finish();
        }
    }

    public Object getTop(){
        Activity activity = null;
        if(activities != null && !activities.empty()){
            activity = activities.lastElement();
        }

        return activity;
    }

    public void removeAll(){
        if(activities != null){
            for(Activity activity : activities){
                activities.remove(activity);
                activity.finish();
            }
        }
    }

    public int getSize(){
        return activities.size();
    }
}
