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
    private List<String> mData = new ArrayList<>();
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ConstraintLayout v = (ConstraintLayout)LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item1_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(mData.get(position));
        holder.button.setText("DEL #"+position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void AddItem(int itemType, String itemText) {
        Log.d(TAG, "AddItem ("+itemType+") "+itemText);
        mData.add(itemText);
        notifyDataSetChanged();
    }
}
