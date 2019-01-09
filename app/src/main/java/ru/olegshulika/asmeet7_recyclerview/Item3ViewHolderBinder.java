package ru.olegshulika.asmeet7_recyclerview;

import android.support.v7.widget.RecyclerView;

public class Item3ViewHolderBinder extends ViewHolderBinder {
    private final CustomAdapter.Item mItem;

    public Item3ViewHolderBinder(BaseItem item, int viewType) {
        super(viewType);
        mItem = (CustomAdapter.Item)item;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        CustomAdapter.Item3ViewHolder item3ViewHolder = (CustomAdapter.Item3ViewHolder)holder;
        item3ViewHolder.textItem.setText(mItem.getText());
        item3ViewHolder.buttonItem.setText("DEL #"+mItem.getType());
    }

    @Override
    public BaseItem getItem() {
        return mItem;
    }
}
