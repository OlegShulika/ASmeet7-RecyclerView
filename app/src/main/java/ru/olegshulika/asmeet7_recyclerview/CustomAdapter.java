package ru.olegshulika.asmeet7_recyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
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
import static ru.olegshulika.asmeet7_recyclerview.ItemTypes.ITEM4RV;


public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "CustomAdapter";
    private List<Item> mData;
    private List<ViewHolderBinder> mBinders;
    private SparseArray<ViewHolderFactory> mFactoryMap;


    public CustomAdapter() {
        mData = new ArrayList<>();
        mBinders = new ArrayList<>();
        initFactory();
    }

    private void initFactory() {
        mFactoryMap = new SparseArray<>();
        mFactoryMap.put(ITEM1.getType(), new Item1ViewHolderFactory( this));
        mFactoryMap.put(ITEM2.getType(), new Item2ViewHolderFactory( this));
        mFactoryMap.put(ITEM3.getType(), new Item3ViewHolderFactory( this));
        mFactoryMap.put(ITEM4RV.getType(), new Item4ViewHolderFactory( this));
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
            case ITEM4RV:
                return new Item4ViewHolderBinder(baseItem, baseItem.getType());
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
        Log.d(TAG, ">bind< pos="+position);
        ViewHolderBinder binder = mBinders.get(position);
        if (binder != null)
            binder.bindViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List<Object> payloads){
        if (payloads.isEmpty()){
            super.onBindViewHolder(holder, position, payloads);
        } else {
            Log.d(TAG, ">>bind<< pos=" + position);
            ViewHolderBinder binder = mBinders.get(position);
            Bundle diff = (Bundle) payloads.get(0);
            for (String key : diff.keySet()) {
                if (key.equals("text"))
                    binder.bindViewHolder(holder, true, false);
                if (key.equals("position"))
                    binder.bindViewHolder(holder, false, true);
            }
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

    public String GetDataSnapshot() {
        String itemChars="";
        for (Item item:mData)
            itemChars += item.getCharType();
        return itemChars;
    }


    public void AddItem(long id, int itemType, String itemText) {
        Log.d(TAG, "AddItem ("+itemType+") "+itemText);
        List<Item> oldData = new ArrayList<>(mData);

        if (id==0)                              // internal recycler view
            id = -System.currentTimeMillis();

        Item newItem = new Item(id, itemType,itemText);
        mData.add(newItem);
        mBinders.add(generateBinder(newItem));
        NotifyDiffResult(oldData,mData);
    }

    public void DeleteItem(int position) {
        Log.d(TAG, "DeleteItem pos="+position);
        if (position>=0 && position<mData.size()) {
            List<Item> oldData = new ArrayList<>(mData);
            mData.remove(position);
            mBinders.remove(position);
            NotifyDiffResult(oldData,mData);
        }
    }

    private void NotifyDiffResult (List<Item> oldData, List<Item> newData){
        MyDiffCall addDiffUtilCallback = new MyDiffCall(oldData, newData);
        DiffUtil.DiffResult productDiffResult = DiffUtil.calculateDiff(addDiffUtilCallback);

        productDiffResult.dispatchUpdatesTo(this);
    }

}
