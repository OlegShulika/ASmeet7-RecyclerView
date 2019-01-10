package ru.olegshulika.asmeet7_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "HorizontalAdapter";
    private List<String> mData;
    private CustomAdapter customAdapter;
    protected int  mPosition = -1;

    public HorizontalAdapter(CustomAdapter custAdapter) {
        mData = new ArrayList<>();
        this.customAdapter = custAdapter;
    }

    public void setData(String snapshot) {
        for (char digit : snapshot.toCharArray())
            mData.add("#" + digit);
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        Log.d(TAG, "deleteItem pos="+position);
        if (position>=0 && position<mData.size()) {
            mData.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mData.size() - 1);
            if (mData.size()==0 && mPosition>=0) {
                Log.d(TAG, "delete Horizontal RecyclerViewView pos="+mPosition);
                customAdapter.DeleteItem(mPosition);
            }
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        protected Button mButton;

        public ItemViewHolder(final View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.hor_recycler_button);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { deleteItem(getAdapterPosition()); }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Log.d(TAG, "onCreateViewHolder/"+viewType);
        final Context context = viewGroup.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_hor_recycleview_button_layout, viewGroup, false);
        ItemViewHolder holder = new ItemViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Log.d(TAG, ">bind< pos="+position);
        ItemViewHolder holder = (ItemViewHolder) viewHolder;
        holder.mButton.setText(mData.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
