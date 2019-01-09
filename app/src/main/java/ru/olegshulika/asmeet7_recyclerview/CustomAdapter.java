package ru.olegshulika.asmeet7_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.constraint.ConstraintLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static ru.olegshulika.asmeet7_recyclerview.ItemTypes.ITEM1;
import static ru.olegshulika.asmeet7_recyclerview.ItemTypes.ITEM2;
import static ru.olegshulika.asmeet7_recyclerview.ItemTypes.ITEM3;


public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
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

    private static List<Item> mData = new ArrayList<>();
    private static List<ViewHolderBinder> mBinders = new ArrayList<>();
    private SparseArray<ViewHolderFactory> mFactoryMap;

    public CustomAdapter() {
        initFactory();
    }

    private void initFactory() {
        mFactoryMap = new SparseArray<>();
        mFactoryMap.put(ITEM1.getType(), new Item123ViewHolderFactory(R.layout.item1_layout, ITEM1));
        mFactoryMap.put(ITEM2.getType(), new Item123ViewHolderFactory(R.layout.item2_layout, ITEM2));
        mFactoryMap.put(ITEM3.getType(), new Item123ViewHolderFactory(R.layout.item3_layout, ITEM3));
    }

    private ViewHolderBinder generateBinder(BaseItem baseItem){
        Item item = (Item)baseItem;
        switch (item.itemType) {
            case ITEM1:
                return new Item1ViewHolderBinder(baseItem, baseItem.getType());
            case ITEM2:
                return new Item2ViewHolderBinder(baseItem, baseItem.getType());
            case ITEM3:
                return new Item3ViewHolderBinder(baseItem, baseItem.getType());
            default:
                return null;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int itemType) {
        Log.d(TAG, "onCreateViewHolder/"+itemType);
        ViewHolderFactory factory = mFactoryMap.get(itemType);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return factory.createViewHolder(parent, inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, ">>bind<< pos="+position);
        ViewHolderBinder binder = mBinders.get(position);
        if (binder != null)
            binder.bindViewHolder(holder);
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
        Item newItem = new Item(id, itemType,itemText);
        mData.add(newItem);
        mBinders.add(generateBinder(newItem));
        notifyItemInserted(mData.size()-1);
    }

    public static void DeleteItem(int position) {
        Log.d(TAG, "DeleteItem pos="+position);
        if (position>=0 && position<mData.size()) {
            mData.remove(position);
            mBinders.remove(position);
            //notifyItemRemoved(position);
            //notifyItemRangeChanged(position, mData.size());
        }
    }

    public static class Item1ViewHolder extends RecyclerView.ViewHolder {
        public TextView textItem;
        public Button buttonItem;
        private static final String TAG = "Item1ViewHolder";

        public Item1ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "Item1ViewHolder()");

            textItem = itemView.findViewById(R.id.item1_textview);
            buttonItem = itemView.findViewById(R.id.item1_button);

            if (buttonItem!=null)
                buttonItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = getAdapterPosition();
                        Log.d(TAG, "delete item1 pos="+pos);
                        DeleteItem(pos);
                    }
                });
        }
    }

    public static class Item2ViewHolder extends RecyclerView.ViewHolder {
        public TextView textItem;
        public Button buttonItem;
        private static final String TAG = "Item2ViewHolder";

        public Item2ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "Item2ViewHolder()");

            textItem = itemView.findViewById(R.id.item2_textview);
            buttonItem = itemView.findViewById(R.id.item2_button);

            if (buttonItem!=null)
                buttonItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = getAdapterPosition();
                        Log.d(TAG, "delete item2 pos="+pos);
                        DeleteItem(pos);
                    }
                });
        }
    }

    public static class Item3ViewHolder extends RecyclerView.ViewHolder {
        public TextView textItem;
        public Button buttonItem;
        private static final String TAG = "Item3ViewHolder";

        public Item3ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "Item3ViewHolder()");

            textItem = itemView.findViewById(R.id.item3_textview);
            buttonItem = itemView.findViewById(R.id.item3_button);

            if (buttonItem!=null)
                buttonItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = getAdapterPosition();
                        Log.d(TAG, "delete item3 pos="+pos);
                        DeleteItem(pos);
                    }
                });
        }
    }

}
