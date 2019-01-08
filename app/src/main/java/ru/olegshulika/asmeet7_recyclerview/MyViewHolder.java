package ru.olegshulika.asmeet7_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textItem1;
    public Button buttonItem1;
    public TextView textItem2;
    public Button buttonItem2;
    public TextView textItem3;
    public Button buttonItem3;

    private static final String TAG = "MyViewHolder";
    private CustomAdapter mAdapter;

    public MyViewHolder(@NonNull View itemView, CustomAdapter adapter) {
        super(itemView);
        Log.d(TAG, "MyViewHolder()");

        textItem1 = itemView.findViewById(R.id.item1_textview);
        buttonItem1 = itemView.findViewById(R.id.item1_button);

        textItem2 = itemView.findViewById(R.id.item2_textview);
        buttonItem2 = itemView.findViewById(R.id.item2_button);

        textItem3 = itemView.findViewById(R.id.item3_textview);
        buttonItem3 = itemView.findViewById(R.id.item3_button);

        mAdapter = adapter;

        initListeners();
    }

    void initListeners(){
        if (buttonItem1!=null)
            buttonItem1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAdapter.DeleteItem(getAdapterPosition());
                }
            });
        if (buttonItem2!=null)
            buttonItem2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAdapter.DeleteItem(getAdapterPosition());
                }
            });
        if (buttonItem3!=null)
            buttonItem3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAdapter.DeleteItem(getAdapterPosition());
                }
            });
    }
}
