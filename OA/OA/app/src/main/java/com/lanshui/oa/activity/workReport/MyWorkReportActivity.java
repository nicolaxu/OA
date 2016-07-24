package com.lanshui.oa.activity.workReport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.lanshui.oa.R;
import com.lanshui.oa.activity.BaseActivity;
import com.lanshui.oa.utils.Constants;
import com.lanshui.oa.view.adapter.workReport.MyWorkReportAdapter;
import com.lanshui.oa.view.model.Flows;
import com.lanshui.oa.view.model.Gov;
import com.lanshui.oa.view.model.TransFlow;
import com.lanshui.oa.view.model.WorkReport;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/20 0020.
 */
public class MyWorkReportActivity extends BaseActivity implements MyWorkReportAdapter.OnRecyclerViewListener{

    private static final String TAG = Constants.TAG + MyWorkReportActivity.class.getSimpleName();

    @ViewInject(R.id.rv_my_work_report)
    private RecyclerView mRvMyWorkReport;

    @ViewInject(R.id.my_report_toolbar)
    private Toolbar toolbar;

    private List<TransFlow> data;
    private int sign = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_work_report);
        x.view().inject(MyWorkReportActivity.this);

        toolbar.setTitle(R.string.tv_my_report_list);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_activity_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWorkReportActivity.super.onBackPressed();
            }
        });

        mRvMyWorkReport.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRvMyWorkReport.setLayoutManager(manager);
        initData();
        MyWorkReportAdapter adapter = new MyWorkReportAdapter(this,data,sign);
        adapter.setOnRecyclerViewListener(this);
        mRvMyWorkReport.setAdapter(adapter);
    }

    private void initData() {
        // TODO: 2016/7/21 0021
        /**
         * this is test code
         */
        data = new ArrayList<>();
        for(int i=0;i<10;i++){
            Gov gov = new Gov();
            gov.setGuid(000001+i*1000+"");
            gov.setCreatorId(i*12+007);
            gov.setFlowName("这是测试标题,公文"+i);
            gov.setAddTime("2016-07-15");
            gov.setDocBody("这是测试的内容，君不见黄河之水天上来，奔流到海不复回"+i);
            gov.setCreatorDepName("赵;"+"钱;"+"孙;");
            gov.setValidTime("2016-07-20");
            data.add(gov);
            sign ++;
        }

        for(int i=0;i<10;i++){
            Flows flow = new Flows();
            flow.setCreatorId(007+i*13);
            flow.setGuid(000001+i*1000+"");
            flow.setFlowName("这是测试标题,流程"+i);
            flow.setAddTime("2016-07-15");
            flow.setDocBody("这是测试的内容，君不见黄河之水天上来，奔流到海不复回"+i);
            flow.setViewUserList("赵;"+"钱;"+"孙;");
            flow.setValidTime("2016-07-20");
            data.add(flow);
        }
    }

    @Override
    public void onItemClick(int position) {
        // TODO: 2016/7/21 0021
        Log.d(TAG,"item clicked on " + position);
        Intent intent = new Intent(MyWorkReportActivity.this,WorkReportDetailActivity.class);
        intent.putExtra("transFlow",data.get(position));
        startActivity(intent);
    }

    @Override
    public boolean onItemLongPress(int position) {
        // TODO: 2016/7/21 0021
        return false;
    }
}
