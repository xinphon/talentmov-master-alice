package com.movtalent.app.category.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.movtalent.app.R;
import com.movtalent.app.model.vo.VideoTypeVo;

import java.util.ArrayList;


/**
 * @author huangyong
 * createTime 2019/6/14
 */
public class CateTabAdapter2 extends RecyclerView.Adapter<CateHolder> {

    public int currentIndex = 0;
    private ArrayList<VideoTypeVo.ClassBean> data;

    public CateTabAdapter2(ArrayList<VideoTypeVo.ClassBean> bean, OnTabSelected onTabSelected) {
        this.onTabSelected = onTabSelected;
        this.data = data;
    }

    public CateTabAdapter2(OnTabSelected onTabSelected) {
        this.onTabSelected = onTabSelected;
    }

    public void setData(ArrayList<VideoTypeVo.ClassBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CateHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cate_tab_item, null);
        return new CateHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CateHolder cateHolder, int i) {
        cateHolder.catTab.setText(data.get(i).getType_name());
        cateHolder.catTab.setSelected(currentIndex == i);
        cateHolder.catTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = i;
                notifyDataSetChanged();
                if (onTabSelected != null) {
                    onTabSelected.onTabSelected(currentIndex, data.get(i));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    private final OnTabSelected onTabSelected;

    public void setSelected(int i) {
        currentIndex = i;
        notifyDataSetChanged();
    }

    public interface OnTabSelected {
        void onTabSelected(int position,VideoTypeVo.ClassBean bean);
    }
}
