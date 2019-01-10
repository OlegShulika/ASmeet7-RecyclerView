package ru.olegshulika.asmeet7_recyclerview;

import android.support.v7.widget.RecyclerView;

public class Item4ViewHolderBinder extends ViewHolderBinder {
    private final Item mItem;
    protected int mPosition;

    public Item4ViewHolderBinder(BaseItem item, int viewType) {
        super(viewType);
        mItem = (Item)item;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder, boolean updateText, boolean updateButtonPosN) {
        Item4ViewHolder item4ViewHolder = (Item4ViewHolder)holder;
        item4ViewHolder.mHorizontalAdapter.setData(item4ViewHolder.mCustomAdapter.GetDataSnapshot());
        mPosition = item4ViewHolder.getAdapterPosition();
    }

    @Override
    public BaseItem getItem() {
        return mItem;
    }

}
