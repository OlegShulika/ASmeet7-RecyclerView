package ru.olegshulika.asmeet7_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class Item4ViewHolder extends RecyclerView.ViewHolder {
    public RecyclerView mRecyclerViewInternal;
    private static final String TAG = "Item4ViewHolder";
    protected CustomAdapter mCustomAdapter;
    protected HorizontalAdapter mHorizontalAdapter;

    public Item4ViewHolder(@NonNull View itemView, CustomAdapter customAdapter) {
        super(itemView);
        Log.d(TAG, "Item4ViewHolder()");

        mCustomAdapter = customAdapter;
        mHorizontalAdapter = new HorizontalAdapter(mCustomAdapter);

        mRecyclerViewInternal = itemView.findViewById(R.id.recycler_int2);
        mRecyclerViewInternal.setLayoutManager(
                new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false));
        mRecyclerViewInternal.setAdapter(mHorizontalAdapter);
    }


}
