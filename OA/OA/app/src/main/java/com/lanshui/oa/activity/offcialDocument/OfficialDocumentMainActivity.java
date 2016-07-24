package com.lanshui.oa.activity.offcialDocument;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lanshui.oa.R;
import com.lanshui.oa.activity.BaseActivity;

/**
 * Created by Administrator on 2016/7/20 0020.
 */
public class OfficialDocumentMainActivity extends BaseActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official_document_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.official_document_main_toolbar);
        toolbar.setTitle(R.string.tv_todo_offcial);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_activity_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OfficialDocumentMainActivity.super.onBackPressed();
            }
        });
    }
}
