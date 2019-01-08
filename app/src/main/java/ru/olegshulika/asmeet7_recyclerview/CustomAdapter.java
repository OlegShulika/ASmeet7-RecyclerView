package ru.olegshulika.asmeet7_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.constraint.ConstraintLayout;
import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private static final String TAG = "CustomAdapter";
    public class Item implements BaseItem {
        private long idItem;
        private ItemTypes itemType;
        private String text;

        public Item(long id, int type, String msg) {
            this.idItem = id;
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
        public long getId() { return idItem; }
    }

    private List<Item> mData = new ArrayList<>();
    private SparseArray<ViewHolderFactory> mFactoryMap;

    public CustomAdapter() {
        initFactory();
    }

    private void initFactory() {
        mFactoryMap = new SparseArray<>();
        mFactoryMap.put(ItemTypes.ITEM1.getType(), new Item123ViewHolderFactory(R.layout.item1_layout));
        mFactoryMap.put(ItemTypes.ITEM2.getType(), new Item123ViewHolderFactory(R.layout.item2_layout));
        mFactoryMap.put(ItemTypes.ITEM3.getType(), new Item123ViewHolderFactory(R.layout.item3_layout));
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int itemType) {
        Log.d(TAG, "onCreateViewHolder/"+itemType);
        ViewHolderFactory factory = mFactoryMap.get(itemType);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return (MyViewHolder)factory.createViewHolder(parent, inflater, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, ">>bind<< pos="+position);
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

    public void AddItem(long id, int itemType, String itemText) {
        Log.d(TAG, "AddItem ("+itemType+") "+itemText);
        mData.add(new Item(id, itemType,itemText));
        notifyItemInserted(mData.size()-1);
    }

    public void DeleteItem(int position) {
        Log.d(TAG, "DeleteItem pos="+position);
        if (position>=0 && position<mData.size()) {
            mData.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mData.size());
        }
    }
}
