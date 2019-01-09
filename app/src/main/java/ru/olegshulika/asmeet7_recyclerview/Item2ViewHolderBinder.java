package ru.olegshulika.asmeet7_recyclerview;

import android.support.v7.widget.RecyclerView;

public class Item2ViewHolderBinder extends ViewHolderBinder {
    private final Item mItem;

    public Item2ViewHolderBinder(BaseItem item, int viewType) {
        super(viewType);
        mItem = (Item)item;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        Item2ViewHolder item2ViewHolder = (Item2ViewHolder)holder;
        item2ViewHolder.textItem.setText(mItem.getText());
        item2ViewHolder.buttonItem.setText("T"+mItem.getType()+" #"+holder.getAdapterPosition());
    }

    @Override
    public BaseItem getItem() {
        return mItem;
    }
}
