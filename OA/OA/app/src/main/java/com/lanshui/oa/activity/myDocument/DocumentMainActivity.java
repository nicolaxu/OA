package com.lanshui.oa.activity.myDocument;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lanshui.oa.R;
import com.lanshui.oa.activity.BaseActivity;

/**
 * Created by Administrator on 2016/7/20 0020.
 */
public class DocumentMainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.document_main_toolbar);
        toolbar.setTitle(R.string.tv_todo_document);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_activity_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentMainActivity.super.onBackPressed();
            }
        });
    }
}
