package com.lanqiu.myfragment.demo_zhihu.base;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.lanqiu.myfragment.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by jh on 2016/12/29.
 */

public class BaseFragment extends SupportFragment {
    private static final String TAG = "MyFragment";

    protected void initToolbarMenu(Toolbar toolbar) {
        toolbar.inflateMenu(R.menu.hierarchy);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_hierarchy:
                        _mActivity.showFragmentStackHierarchyView();
                        _mActivity.logFragmentStackHierarchy(TAG);
                        break;
                }
                return true;
            }
        });
    }

}
