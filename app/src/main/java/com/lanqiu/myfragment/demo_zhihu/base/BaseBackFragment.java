package com.lanqiu.myfragment.demo_zhihu.base;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lanqiu.myfragment.R;

/**
 * Created by jh on 2016/12/29.
 */

public class BaseBackFragment extends BaseFragment {
    protected void initToolbarNav(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mActivity.onBackPressed();
            }
        });
        initToolbarMenu(toolbar);
    }

}
