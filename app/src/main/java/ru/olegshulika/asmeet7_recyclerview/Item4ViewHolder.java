package ru.olegshulika.asmeet7_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class Item4ViewHolder extends RecyclerView.ViewHolder {
    public RecyclerView mRecyclerViewInternal;
    private static final String TAG = "Item4ViewHolder";
    private CustomAdapter adapter;

    public Item4ViewHolder(@NonNull View itemView, CustomAdapter customAdapter) {
        super(itemView);
        Log.d(TAG, "Item4ViewHolder()");

        adapter = customAdapter;

        mRecyclerViewInternal = itemView.findViewById(R.id.recycler_int2);
    }}
