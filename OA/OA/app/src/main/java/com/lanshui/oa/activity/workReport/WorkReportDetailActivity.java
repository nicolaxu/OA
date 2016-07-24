package com.lanshui.oa.activity.workReport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lanshui.oa.R;
import com.lanshui.oa.activity.BaseActivity;
import com.lanshui.oa.view.model.WorkReport;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class WorkReportDetailActivity extends BaseActivity {

    @ViewInject(R.id.my_work_report_detail_toolbar)
    private Toolbar toolbar;

    @ViewInject(R.id.tv_work_report_detail_title)
    private TextView detailTitle;

    @ViewInject(R.id.tv_work_report_detail_leader)
    private TextView detailLeader;

    @ViewInject(R.id.tv_work_report_detail_create_time)
    private TextView createTime;

    @ViewInject(R.id.tv_work_report_detail_update_time)
    private TextView updateTime;

    @ViewInject(R.id.tv_work_report_detail_content)
    private TextView detailContent;

    @ViewInject(R.id.tv_work_report_detail_attch)
    private TextView detailAttch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_detail);

        x.view().inject(this);
        Intent intent = getIntent();
        WorkReport workReport = (WorkReport) intent.getSerializableExtra("workReport");

        // TODO: 2016/7/24
        toolbar.setTitle(workReport.getnTitle());
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_activity_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkReportDetailActivity.super.onBackPressed();
            }
        });



        detailTitle.setText(workReport.getnTitle());
        detailLeader.setText(workReport.getNameList());
        createTime.setText(new SimpleDateFormat("yyyy-MM-dd").format(workReport.getnCreateTime()).toString());
        updateTime.setText(new SimpleDateFormat("yyyy-MM-dd").format(workReport.getnReportDate()).toString());
        detailContent.setText(workReport.getnContent());

    }
}
