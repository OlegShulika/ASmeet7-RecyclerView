package ru.olegshulika.asmeet7_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mData;

    public HorizontalAdapter(){
        mData = new ArrayList<>();
    }

    public void setData(String snapshot) {
        for(char digit:snapshot.toCharArray())
            mData.add("#"+digit);
        notifyDataSetChanged();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        protected Button mButton;

        public ItemViewHolder(View itemView){
            super(itemView);
            mButton = itemView.findViewById(R.id.hor_recycler_button);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_hor_recycleview_button_layout, viewGroup, false);
        ItemViewHolder holder = new ItemViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ItemViewHolder holder = (ItemViewHolder) viewHolder;
        holder.mButton.setText(mData.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
