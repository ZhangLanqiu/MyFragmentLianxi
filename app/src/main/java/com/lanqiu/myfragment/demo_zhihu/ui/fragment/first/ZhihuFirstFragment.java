package com.lanqiu.myfragment.demo_zhihu.ui.fragment.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanqiu.myfragment.R;
import com.lanqiu.myfragment.demo_zhihu.base.BaseMainFragment;
import com.lanqiu.myfragment.demo_zhihu.ui.fragment.first.child.FirstHomeFragment;

/**
 * Created by jh on 2016/12/29.
 */

public class ZhihuFirstFragment extends BaseMainFragment {
    /**
     * 构建一个静态方法返回当前Fragment的实例
     *
     * @return
     */
    public static ZhihuFirstFragment newInstance() {
        Bundle args = new Bundle();//创建Bundle
        ZhihuFirstFragment fragment = new ZhihuFirstFragment();//创建当前类对象
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhihu_fragment_first, container, false);
        return view;
    }
    /**
     * 重写懒加载方法
     */
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_first_container, FirstHomeFragment.newInstance());
        }
    }
}
