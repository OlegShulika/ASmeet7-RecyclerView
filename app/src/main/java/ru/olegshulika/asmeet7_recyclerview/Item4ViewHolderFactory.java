package ru.olegshulika.asmeet7_recyclerview;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class Item4ViewHolderFactory implements ViewHolderFactory {
    private static final String TAG = "Item4ViewHolderFactory";
    private static final int layout = R.layout.item4_recyclerview_layout;
    private CustomAdapter adapter;

    public Item4ViewHolderFactory(CustomAdapter customAdapter){
        this.adapter = customAdapter;
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater) {
        Log.d(TAG, "createViewHolder");

        RecyclerView itemView = (RecyclerView)inflater.inflate(layout, parent, false);

        return new Item4ViewHolder(itemView, adapter);
    }
}
