package com.lanshui.oa.activity.workReport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lanshui.oa.R;
import com.lanshui.oa.activity.BaseActivity;
import com.lanshui.oa.utils.Constants;
import com.lanshui.oa.view.adapter.workReport.OthersWorkReportAdapter;
import com.lanshui.oa.view.model.WorkReport;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class OthersWorkReportActivity extends BaseActivity implements OthersWorkReportAdapter.OnRecyclerViewListener{

    private static final String TAG = Constants.TAG + OthersWorkReportActivity.class.getSimpleName();
    private boolean DEBUG = false;

    private List<WorkReport> workReports;

    @ViewInject(R.id.others_report_toolbar)
    private Toolbar toolbar;

    @ViewInject(R.id.rv_others_work_report)
    private RecyclerView mRvOthersWorkReport;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others_work_report);
        x.view().inject(this);

        toolbar.setTitle(R.string.tv_others_report_list);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_activity_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OthersWorkReportActivity.super.onBackPressed();
            }
        });

        mRvOthersWorkReport.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRvOthersWorkReport.setLayoutManager(manager);
        initData();
        OthersWorkReportAdapter adapter = new OthersWorkReportAdapter(this,workReports);
        adapter.setOnRecyclerViewListener(this);
        mRvOthersWorkReport.setAdapter(adapter);
    }

    private void initData() {
        // TODO: 2016/7/21 0021
        /**
         * this is test code
         */
        workReports = new ArrayList<>();
        for(int i=0;i<10;i++){
            WorkReport workReport = new WorkReport();
            workReport.setnCreateUid(000001+i*1000);
            workReport.setnTitle("这是他人测试标题"+i);
            workReport.setnCreateTime(new Date());
            workReport.setnContent("这是测试的内容，君不见黄河之水天上来，奔流到海不复回" +
                    ",这是测试的内容，君不见黄河之水天上来，奔流到海不复回" +
                    ",这是测试的内容，君不见黄河之水天上来，奔流到海不复回" +
                    ",这是测试的内容，君不见黄河之水天上来，奔流到海不复回" +
                    ",这是测试的内容，君不见黄河之水天上来，奔流到海不复回" +
                    ",这是测试的内容，君不见黄河之水天上来，奔流到海不复回" +
                    ",这是测试的内容，君不见黄河之水天上来，奔流到海不复回" +
                    ",这是测试的内容，君不见黄河之水天上来，奔流到海不复回"+i);
            workReport.setNameList("赵;"+"钱;"+"孙;");
            workReport.setnReportDate(new Date());
            workReports.add(workReport);
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(OthersWorkReportActivity.this,WorkReportDetailActivity.class);
        intent.putExtra("workReport",workReports.get(position));
        startActivity(intent);
    }

    @Override
    public boolean onItemLongPress(int position) {
        return false;
    }
}
