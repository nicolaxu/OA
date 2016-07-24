package com.lanshui.oa.activity.workReport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lanshui.oa.R;
import com.lanshui.oa.activity.BaseActivity;

import org.xutils.view.annotation.Event;
import org.xutils.x;

/**
 * Created by Administrator on 2016/7/19 0019.
 */
public class WorkReportMainActivity extends BaseActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_report_main);
        x.view().inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.report_main_toolbar);
        toolbar.setTitle(R.string.tv_todo_report);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_activity_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkReportMainActivity.super.onBackPressed();
            }
        });

    }

    @Event(value = {
             R.id.ll_my_report_list
            ,R.id.ll_others_report_list
            ,R.id.ll_create_new_report},type = View.OnClickListener.class)
    private void onClick(View view){
        switch (view.getId()){
            case R.id.ll_my_report_list:
                Intent intent1 = new Intent(WorkReportMainActivity.this,MyWorkReportActivity.class);
                startActivity(intent1);
                break;
            case R.id.ll_others_report_list:
                Intent intent2 = new Intent(WorkReportMainActivity.this,OthersWorkReportActivity.class);
                startActivity(intent2);
                break;
            case R.id.ll_create_new_report:
                break;
        }
    }
}
