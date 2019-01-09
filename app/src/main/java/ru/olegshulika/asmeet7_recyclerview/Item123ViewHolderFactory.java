package ru.olegshulika.asmeet7_recyclerview;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class Item123ViewHolderFactory implements ViewHolderFactory {
    private static final String TAG = "Item123ViewHolderFactory";
    private final int layout;
    private ItemTypes itemType;

    public Item123ViewHolderFactory(int itemLayout, ItemTypes type){
        this.layout = itemLayout;
        this.itemType = type;
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater) {
        Log.d(TAG, "createViewHolder");

        ConstraintLayout itemView = (ConstraintLayout)inflater.inflate(layout, parent, false);

        switch (itemType) {
            case ITEM1:
                return new CustomAdapter.Item1ViewHolder(itemView);
            case ITEM2:
                return new CustomAdapter.Item2ViewHolder(itemView);
            case ITEM3:
                return new CustomAdapter.Item3ViewHolder(itemView);
            default:
                return null;
        }
    }
}
