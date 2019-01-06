package ru.olegshulika.asmeet7_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView textItem1;
    public Button buttonItem1;
    public TextView textItem2;
    public Button buttonItem2;
    public TextView textItem3;
    public Button buttonItem3;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textItem1 = itemView.findViewById(R.id.item1_textview);
        buttonItem1 = itemView.findViewById(R.id.item1_button);

        textItem2 = itemView.findViewById(R.id.item2_textview);
        buttonItem2 = itemView.findViewById(R.id.item2_button);

        textItem3 = itemView.findViewById(R.id.item3_textview);
        buttonItem3 = itemView.findViewById(R.id.item3_button);
    }
}
