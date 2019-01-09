package ru.olegshulika.asmeet7_recyclerview;

import android.support.v7.widget.RecyclerView;

public class Item2ViewHolderBinder extends ViewHolderBinder {
    private final Item mItem;

    public Item2ViewHolderBinder(BaseItem item, int viewType) {
        super(viewType);
        mItem = (Item)item;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder, boolean updateText, boolean updateButtonPosN) {
        Item2ViewHolder item2ViewHolder = (Item2ViewHolder)holder;
        if (updateText)
            item2ViewHolder.textItem.setText(mItem.getText());
        if (updateButtonPosN)
            item2ViewHolder.buttonItem.setText("T"+mItem.getType()+" #"+holder.getAdapterPosition());
    }

    @Override
    public BaseItem getItem() {
        return mItem;
    }
}
