package ru.olegshulika.asmeet7_recyclerview;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class Item1ViewHolderFactory implements ViewHolderFactory {
    private static final String TAG = "Item1ViewHolderFactory";
    private static final int layout = R.layout.item1_layout;
    private CustomAdapter adapter;

    public Item1ViewHolderFactory(CustomAdapter customAdapter){
        this.adapter = customAdapter;
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater) {
        Log.d(TAG, "createViewHolder");

        ConstraintLayout itemView = (ConstraintLayout)inflater.inflate(layout, parent, false);

        return new Item1ViewHolder(itemView, adapter);
    }
}
