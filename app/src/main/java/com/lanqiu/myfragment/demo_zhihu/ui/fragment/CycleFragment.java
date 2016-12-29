package com.lanqiu.myfragment.demo_zhihu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanqiu.myfragment.R;
import com.lanqiu.myfragment.demo_zhihu.base.BaseBackFragment;

/**
 * Created by jh on 2016/12/29.
 */

public class CycleFragment extends BaseBackFragment {
    private static final String ARG_NUMBER = "arg_number";
    private int mNumber;

    /**
     * 构造一个静态方法返回当前类的实例
     */
    public static CycleFragment newInstance(int number) {
        //创建实例
        CycleFragment fragment = new CycleFragment();
        //创建Bundle
        Bundle args = new Bundle();
        args.putInt(ARG_NUMBER, number);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args!=null){
            mNumber = args.getInt(ARG_NUMBER);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cycle,container,false);
        //初始化视图
        initView(view);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 初始化视图
     * @param view
     */
    private void initView(View view) {
    }
}
