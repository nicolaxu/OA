package com.lanshui.oa.activity.workTask;

import android.content.Intent;
import android.os.Bundle;

import com.lanshui.oa.activity.BaseActivity;
import com.lanshui.oa.view.model.WorkTask;

import java.util.List;

/**
 * Created by Administrator on 2016/7/22 0022.
 */
public class WorkTaskDetailActivity extends BaseActivity{

    private List<WorkTask> workTasks;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        workTasks = (List<WorkTask>) intent.getSerializableExtra("workTask");
    }
}
