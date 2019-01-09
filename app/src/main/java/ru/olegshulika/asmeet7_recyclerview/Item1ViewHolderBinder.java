package ru.olegshulika.asmeet7_recyclerview;

import android.support.v7.widget.RecyclerView;

public class Item1ViewHolderBinder extends ViewHolderBinder {
    private final CustomAdapter.Item mItem;

    public Item1ViewHolderBinder(BaseItem item, int viewType) {
        super(viewType);
        mItem = (CustomAdapter.Item)item;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        CustomAdapter.Item1ViewHolder item1ViewHolder = (CustomAdapter.Item1ViewHolder)holder;
        item1ViewHolder.textItem.setText(mItem.getText());
        item1ViewHolder.buttonItem.setText("DEL #"+mItem.getType());
    }

    @Override
    public BaseItem getItem() {
        return mItem;
    }
}
