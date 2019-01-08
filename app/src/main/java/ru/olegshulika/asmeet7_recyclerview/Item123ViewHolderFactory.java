package ru.olegshulika.asmeet7_recyclerview;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class Item123ViewHolderFactory implements ViewHolderFactory {
    private static final String TAG = "Item123ViewHolderFactory";
    private final int layout;

    public Item123ViewHolderFactory(int itemLayout){
        this.layout = itemLayout;
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater, CustomAdapter adapter) {
        Log.d(TAG, "createViewHolder");

        ConstraintLayout itemView = (ConstraintLayout)inflater.inflate(layout, parent, false);
        RecyclerView.ViewHolder holder = new MyViewHolder(itemView, adapter);
        return holder;
    }
}
