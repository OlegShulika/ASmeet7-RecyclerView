package ru.olegshulika.asmeet7_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.constraint.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private static final String TAG = "CustomAdapter";
    private class Item implements BaseItem {
        private ItemTypes itemType;
        private String text;
        public Item(int type, String msg) {
            this.itemType = ItemTypes.fromId(type);
            this.text = msg;
        }
        @Override
        public int getType() {
            return itemType.getType();
        }
        public String getText() {
            return text;
        }
    }

    private List<Item> mData = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int itemType) {
        int itemLayout;
        switch (ItemTypes.fromId(itemType)){
            case ITEM1:
                itemLayout=R.layout.item1_layout;
                break;
            case ITEM2:
                itemLayout=R.layout.item2_layout;
                break;
            case ITEM3:
                itemLayout=R.layout.item3_layout;
                break;
            default:
                itemLayout=R.layout.item1_layout;
                break;
        }
        ConstraintLayout v = (ConstraintLayout)LayoutInflater.from(parent.getContext()).
                inflate(itemLayout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        switch(mData.get(position).itemType){
            case ITEM1:
                holder.textItem1.setText(mData.get(position).getText());
                holder.buttonItem1.setText("DEL #"+position);
                break;
            case ITEM2:
                holder.textItem2.setText(mData.get(position).getText());
                holder.buttonItem2.setText("DEL #"+position);
                break;
            case ITEM3:
                holder.textItem3.setText(mData.get(position).getText());
                holder.buttonItem3.setText("DEL #"+position);
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemViewType(int position){
        return mData.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void AddItem(int itemType, String itemText) {
        Log.d(TAG, "AddItem ("+itemType+") "+itemText);
        mData.add(new Item(itemType,itemText));
        notifyDataSetChanged();
    }
}
