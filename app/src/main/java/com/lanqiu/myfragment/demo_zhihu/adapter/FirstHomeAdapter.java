package com.lanqiu.myfragment.demo_zhihu.adapter;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanqiu.myfragment.R;
import com.lanqiu.myfragment.demo_zhihu.entity.Article;
import com.lanqiu.myfragment.demo_zhihu.ui.fragment.first.child.FirstHomeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jh on 2016/12/29.
 */

public class FirstHomeAdapter extends RecyclerView.Adapter<FirstHomeAdapter.VH> {
    private List<Article> mItems = new ArrayList<>();
    private final LayoutInflater mInflater;

    //监听接口
    private OnItemClickListener onItemClickListener;

    public FirstHomeAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    /**
     * 重写创建ViewHolder的方法
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_zhihu_home_first, parent, false);
        //创建VH对象
        final VH holder = new VH(view);
        //为条目设置监听
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取position
                int position = holder.getAdapterPosition();
                if (onItemClickListener != null) {
                    onItemClickListener.itemClick(position, v, holder);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        //获取点击的文章实体类
        Article item = mItems.get(position);
        //把每个图片视图设置不同的Transition名称,防止在一个视图内有多个相同的名称，在变幻的时候造成混乱
        //Fragment支持多个View进行变换，使用适配器时，需要加以区分
        ViewCompat.setTransitionName(holder.img, String.valueOf(position) + "_image");
        ViewCompat.setTransitionName(holder.tvTitle, String.valueOf(position) + "_tv");
        holder.img.setImageResource(item.getImgRes());
        holder.tvTitle.setText(item.getTitle());
    }

    public void setDatas(List<Article> items) {
        mItems.clear();
        mItems.addAll(items);
    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public Article getmItems(int position) {
        return mItems.get(position);
    }

    /*
        设置条目监听的接口
         */
    public interface OnItemClickListener {
        void itemClick(int position, View view, RecyclerView.ViewHolder vh);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public class VH extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private ImageView img;

        public VH(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
