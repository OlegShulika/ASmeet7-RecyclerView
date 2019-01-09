package ru.olegshulika.asmeet7_recyclerview;

import android.support.v7.widget.RecyclerView;

public class Item2ViewHolderBinder extends ViewHolderBinder {
    private final CustomAdapter.Item mItem;

    public Item2ViewHolderBinder(BaseItem item, int viewType) {
        super(viewType);
        mItem = (CustomAdapter.Item)item;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        CustomAdapter.Item2ViewHolder item2ViewHolder = (CustomAdapter.Item2ViewHolder)holder;
        item2ViewHolder.textItem.setText(mItem.getText());
        item2ViewHolder.buttonItem.setText("DEL #"+mItem.getType());
    }

    @Override
    public BaseItem getItem() {
        return mItem;
    }
}
