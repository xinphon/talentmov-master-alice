package com.movtalent.app.model;

import android.view.View;

/**
 * @author huangyong
 * createTime 2019-09-14
 */
public class Category {

    private final String catName;

    public String getCatName() {
        return catName;
    }

    public View.OnClickListener getClickListener() {
        return clickListener;
    }

    private final View.OnClickListener clickListener;

    public Category(String catName, View.OnClickListener clickListener) {
        this.catName = catName;
        this.clickListener = clickListener;
    }
}
