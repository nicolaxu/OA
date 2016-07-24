package com.lanshui.oa.activity.myMessage;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lanshui.oa.R;
import com.lanshui.oa.activity.BaseActivity;

public class MessageMainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.message_toolbar);
        toolbar.setTitle(getResources().getString(R.string.tv_todo_message));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_activity_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageMainActivity.super.onBackPressed();
            }
        });
    }
}
