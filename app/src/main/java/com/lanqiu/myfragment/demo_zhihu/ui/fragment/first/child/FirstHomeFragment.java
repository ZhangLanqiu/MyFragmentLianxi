package com.lanqiu.myfragment.demo_zhihu.ui.fragment.first.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanqiu.myfragment.R;
import com.lanqiu.myfragment.demo_zhihu.adapter.FirstHomeAdapter;
import com.lanqiu.myfragment.demo_zhihu.base.BaseFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by jh on 2016/12/29.
 */

public class FirstHomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private String[] mTitles = new String[]{
            "Use imagery to express a distinctive voice and exemplify creative excellence.",
            "An image that tells a story is infinitely more interesting and informative.",
            "The most powerful iconic images consist of a few meaningful elements, with minimal distractions.",
            "Properly contextualized concepts convey your message and brand more effectively.",
            "Have an iconic point of focus in your imagery. Focus ranges from a single entity to an overarching composition."
    };
    private int[] mImgRes = new int[]{
            R.mipmap.bg_first, R.mipmap.bg_second, R.mipmap.bg_third, R.mipmap.bg_fourth, R.mipmap.bg_fifth
    };
    private View view;
    private Toolbar mToolbar;
    private RecyclerView mRecy;
    private SwipeRefreshLayout mRefreshLayout;
    private FloatingActionButton mFab;
    private FirstHomeAdapter mAdapter;

    /*
    构建一个静态方法返回当前类的实例
     */
    public static FirstHomeFragment newInstance() {
        Bundle args = new Bundle();//创建bundle
        FirstHomeFragment fragment = new FirstHomeFragment();//创建当前类的对象
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.zhihu_fragment_first_home, null);
        EventBus.getDefault().register(this);//注册EventBus
        initView();//初始化View
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 初始化View
     */
    private void initView() {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mRecy = (RecyclerView) view.findViewById(R.id.recy);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        mFab = (FloatingActionButton) view.findViewById(R.id.fab);

        mToolbar.setTitle("首页");
        initToolbarMenu(mToolbar);
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(this);
        //创建适配器
        mAdapter = new FirstHomeAdapter(_mActivity);
        LinearLayoutManager manager = new LinearLayoutManager(_mActivity);
        mRecy.setLayoutManager(manager);
        mRecy.setAdapter(mAdapter);

        //设置条目监听
        mAdapter.setOnItemClickListener(new FirstHomeAdapter.OnItemClickListener() {
            @Override
            public void itemClick(int position, View view, RecyclerView.ViewHolder vh) {

            }
        });
    }

    @Override
    public void onRefresh() {

    }
}
