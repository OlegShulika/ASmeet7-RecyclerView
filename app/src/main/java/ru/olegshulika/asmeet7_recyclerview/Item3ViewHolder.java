package ru.olegshulika.asmeet7_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Item3ViewHolder extends RecyclerView.ViewHolder {
    public TextView textItem;
    public Button buttonItem;
    private static final String TAG = "Item3ViewHolder";
    private CustomAdapter adapter;

    public Item3ViewHolder(@NonNull View itemView, CustomAdapter customAdapter) {
        super(itemView);
        Log.d(TAG, "Item3ViewHolder()");

        adapter = customAdapter;

        textItem = itemView.findViewById(R.id.item3_textview);
        buttonItem = itemView.findViewById(R.id.item3_button);

        if (buttonItem!=null)
            buttonItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Log.d(TAG, "delete item3 pos="+pos);
                    adapter.DeleteItem(pos);
                }
            });
    }
}
