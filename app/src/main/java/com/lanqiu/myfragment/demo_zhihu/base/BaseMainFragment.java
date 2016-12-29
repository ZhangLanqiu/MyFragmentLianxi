package com.lanqiu.myfragment.demo_zhihu.base;

import android.content.Context;

import com.lanqiu.myfragment.demo_zhihu.ui.fragment.first.ZhihuFirstFragment;

/**
 * 懒加载
 * Created by jh on 2016/12/29.
 */

public abstract     class BaseMainFragment extends BaseFragment {
    private OnBackToFirstListener _mBackToFirstListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBackToFirstListener) {
            _mBackToFirstListener = (OnBackToFirstListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + " must implement OnBackToFirstListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        _mBackToFirstListener = null;
    }

    /**
     * 处理回退事件
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {
        if(getChildFragmentManager().getBackStackEntryCount()>1){
            popChild();
        }else{
            if(this instanceof ZhihuFirstFragment){//如果是第一个Fragement 则推出APP
                _mActivity.finish();
            }else{//如果不是则回到第一个fragment
                _mBackToFirstListener.onBackToFirstFragment();
            }
        }
        return true   ;
    }

    public interface OnBackToFirstListener {
        void onBackToFirstFragment();
    }
}
