package com.lanqiu.myfragment.demo_zhihu.ui.fragment.first.child;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanqiu.myfragment.R;
import com.lanqiu.myfragment.demo_zhihu.base.BaseBackFragment;
import com.lanqiu.myfragment.demo_zhihu.entity.Article;

/**
 * Created by jh on 2016/12/29.
 */

public class FirstDetailFragment extends BaseBackFragment {
    private static final String ARG_ITME = "arg_item";
    private Article article;
    private Toolbar mToolbar;
    private ImageView mImgDetail;
    private TextView mTvTitle;
    private FloatingActionButton mFab;

    /**
     * @param article
     * @return
     */
    public static FirstDetailFragment newInstance(Article article) {
        //创建Bundle
        Bundle args = new Bundle();
        args.putParcelable(ARG_ITME, article);
        //创建当前类的实例
        FirstDetailFragment fragment = new FirstDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        article = getArguments().getParcelable(ARG_ITME);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhihu_fragment_first_detail,container,false);
        //初始化视图
        initView(view);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 初始化视图
     */
    private void initView(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mImgDetail = (ImageView) view.findViewById(R.id.img_detail);
        mTvTitle = (TextView) view.findViewById(R.id.tv_content);
        mFab = (FloatingActionButton) view.findViewById(R.id.fab);

        mToolbar.setTitle("");
        initToolbarNav(mToolbar);
        mImgDetail.setImageResource(article.getImgRes());
        mTvTitle.setText(article.getTitle());
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
