package com.lanshui.oa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jauker.widget.BadgeView;
import com.lanshui.oa.R;
import com.lanshui.oa.activity.myDocument.DocumentMainActivity;
import com.lanshui.oa.activity.myMessage.MessageMainActivity;
import com.lanshui.oa.activity.offcialDocument.OfficialDocumentMainActivity;
import com.lanshui.oa.activity.workReport.WorkReportMainActivity;
import com.lanshui.oa.activity.workTask.WorkTaskMainActivity;
import com.lanshui.oa.utils.Constants;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @ViewInject(R.id.swipe_refresh)
    private SwipeRefreshLayout mSwipeRefresh ;

    @ViewInject(R.id.ll_todo_message)
    private LinearLayout mLlTodoMessage;

    @ViewInject(R.id.ll_todo_task)
    private LinearLayout mLlTodoTask;

    BadgeView badgeView1;
    BadgeView badgeView2;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case Constants.REFRESH_COMPLETE :
                    mSwipeRefresh.setRefreshing(false);
                    badgeView1 = new BadgeView(MainActivity.this);
                    badgeView1.setTargetView(mLlTodoMessage);
                    badgeView1.setText("new");

                    badgeView2 = new BadgeView(MainActivity.this);
                    badgeView2.setTargetView(mLlTodoTask);
                    badgeView2.setText("new");
                    Toast.makeText(MainActivity.this,"complete refresh",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x.view().inject(this);
        mSwipeRefresh.setColorSchemeResources(android.R.color.holo_red_light
                ,android.R.color.holo_green_light
                ,android.R.color.holo_blue_light
                ,android.R.color.holo_orange_light);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Event(value = {R.id.swipe_refresh},type = SwipeRefreshLayout.OnRefreshListener.class)
    private void onRefresh(){
        Toast.makeText(MainActivity.this,"start refresh",Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // TODO: 2016/7/18 0018
                    Thread.sleep(2000);
                    handler.sendEmptyMessage(Constants.REFRESH_COMPLETE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Event(value = {R.id.ll_todo_message
            ,R.id.ll_todo_process
            ,R.id.ll_todo_official
            ,R.id.ll_todo_document
            ,R.id.ll_todo_report
            ,R.id.ll_todo_task} ,type = View.OnClickListener.class)
    private void onClick(View view){
        switch (view.getId()){
            case R.id.ll_todo_message:
                Intent intent = new Intent(MainActivity.this,MessageMainActivity.class);
                startActivity(intent);
                //badgeView1.setBadgeCount(0);
                // TODO: 2016/7/20 0020  
                break;
            case R.id.ll_todo_process:
                break;
            case R.id.ll_todo_official:
                Intent intent4 = new Intent(MainActivity.this, OfficialDocumentMainActivity.class);
                startActivity(intent4);
                break;
            case R.id.ll_todo_document:
                Intent intent3 = new Intent(MainActivity.this, DocumentMainActivity.class);
                startActivity(intent3);
                break;
            case R.id.ll_todo_report:
                Intent intent1 = new Intent(MainActivity.this, WorkReportMainActivity.class);
                startActivity(intent1);
                break;
            case R.id.ll_todo_task:
                Intent intent2 = new Intent(MainActivity.this, WorkTaskMainActivity.class);
                startActivity(intent2);
                //badgeView2.setBadgeCount(0);
                // TODO: 2016/7/20 0020
                break;
        }
    }
}
