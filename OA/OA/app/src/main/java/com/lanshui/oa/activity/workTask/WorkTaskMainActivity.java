package com.lanshui.oa.activity.workTask;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.lanshui.oa.R;
import com.lanshui.oa.activity.BaseActivity;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by Administrator on 2016/7/20 0020.
 */
public class WorkTaskMainActivity extends BaseActivity{

    @ViewInject(R.id.ll_all_join_task_list)
    private LinearLayout mLlJoinTask;

    @ViewInject(R.id.ll_my_execute_task_list)
    private LinearLayout mExecuteTask;

    @ViewInject(R.id.ll_my_direct_task_list)
    private LinearLayout mDirectTask;

    @ViewInject(R.id.ll_my_create_task_list)
    private LinearLayout mCreateTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_task_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.work_task_main_toolbar);
        toolbar.setTitle(R.string.tv_todo_task);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_activity_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkTaskMainActivity.super.onBackPressed();
            }
        });
    }

    @Event(value = {R.id.ll_all_join_task_list
            ,R.id.ll_my_execute_task_list
            ,R.id.ll_my_direct_task_list
            ,R.id.ll_my_create_task_list},type = View.OnClickListener.class)
    private void onClick(View view){
        switch (view.getId()){
            case R.id.ll_all_join_task_list:
                break;
            case R.id.ll_my_execute_task_list:
                break;
            case R.id.ll_my_direct_task_list:
                break;
            case R.id.ll_my_create_task_list:
                break;
        }
    }
}
