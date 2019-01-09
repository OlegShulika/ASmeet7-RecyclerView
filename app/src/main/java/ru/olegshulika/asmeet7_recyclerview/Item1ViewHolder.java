package ru.olegshulika.asmeet7_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Item1ViewHolder extends RecyclerView.ViewHolder {
    public TextView textItem;
    public Button buttonItem;
    private static final String TAG = "Item1ViewHolder";
    private CustomAdapter adapter;

    public Item1ViewHolder(@NonNull View itemView, CustomAdapter customAdapter) {
        super(itemView);
        Log.d(TAG, "Item1ViewHolder()");

        adapter = customAdapter;

        textItem = itemView.findViewById(R.id.item1_textview);
        buttonItem = itemView.findViewById(R.id.item1_button);

        if (buttonItem!=null)
            buttonItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Log.d(TAG, "delete item1 pos="+pos);
                    adapter.DeleteItem(pos);
                }
            });
    }
}
