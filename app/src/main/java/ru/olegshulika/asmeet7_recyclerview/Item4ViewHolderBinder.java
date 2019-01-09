package ru.olegshulika.asmeet7_recyclerview;

import android.support.v7.widget.RecyclerView;

public class Item4ViewHolderBinder extends ViewHolderBinder {
    private final Item mItem;

    public Item4ViewHolderBinder(BaseItem item, int viewType) {
        super(viewType);
        mItem = (Item)item;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        Item4ViewHolder item4ViewHolder = (Item4ViewHolder)holder;
        //item4ViewHolder.
    }

    @Override
    public BaseItem getItem() {
        return mItem;
    }

}
