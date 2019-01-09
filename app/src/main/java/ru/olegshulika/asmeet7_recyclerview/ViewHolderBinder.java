package ru.olegshulika.asmeet7_recyclerview;

import android.support.v7.widget.RecyclerView;

public abstract class ViewHolderBinder {
    protected final int viewType;

    public ViewHolderBinder(int viewType) {
        this.viewType = viewType;
    }

    public void bindViewHolder(RecyclerView.ViewHolder holder){ bindViewHolder(holder, true, true);}

    // for DiffUtils
    public abstract void bindViewHolder(RecyclerView.ViewHolder holder, boolean updateText, boolean updatePositionN);

    public abstract BaseItem getItem();
}

