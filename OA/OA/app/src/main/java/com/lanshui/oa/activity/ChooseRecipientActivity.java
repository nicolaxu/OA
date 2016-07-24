package com.lanshui.oa.activity;

import android.content.Intent;
import android.os.Bundle;

import com.lanshui.oa.R;
import com.lanshui.oa.view.model.Recipient;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class ChooseRecipientActivity extends BaseActivity{

    private Map<Integer,List<Recipient>> rescipients;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout);
        // TODO: 2016/7/22 0022
        Intent intent = getIntent();
        rescipients = (Map<Integer, List<Recipient>>) intent.getSerializableExtra("rescipients");
    }
}
