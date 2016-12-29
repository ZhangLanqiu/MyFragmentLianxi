package com.lanqiu.myfragment;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lanqiu.myfragment.demo_zhihu.MainActivity;

public class EnterActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private TextView mTvBtnFlow;
    private TextView mTvBtnWechat;
    private TextView mTvBtnZhihu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        //初始化所有的View
        initView();
    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mTvBtnFlow = (TextView) findViewById(R.id.tv_btn_flow);
        mTvBtnWechat = (TextView) findViewById(R.id.tv_btn_wechat);
        mTvBtnZhihu = (TextView) findViewById(R.id.tv_btn_zhihu);
        setSupportActionBar(mToolBar);
        mTvBtnZhihu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EnterActivity.this, MainActivity.class));
            }
        });
    }
}
