package ru.olegshulika.asmeet7_recyclerview;

import android.support.v7.widget.RecyclerView;

public class Item3ViewHolderBinder extends ViewHolderBinder {
    private final Item mItem;

    public Item3ViewHolderBinder(BaseItem item, int viewType) {
        super(viewType);
        mItem = (Item)item;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        Item3ViewHolder item3ViewHolder = (Item3ViewHolder)holder;
        item3ViewHolder.textItem.setText(mItem.getText());
        item3ViewHolder.buttonItem.setText("T"+mItem.getType()+" #"+holder.getAdapterPosition());
    }

    @Override
    public BaseItem getItem() {
        return mItem;
    }
}
