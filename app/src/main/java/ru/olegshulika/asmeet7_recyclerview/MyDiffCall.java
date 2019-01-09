package ru.olegshulika.asmeet7_recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import java.util.List;

public class MyDiffCall extends DiffUtil.Callback {

    private List<Item> mOldData;
    private List<Item> mNewData;

    public MyDiffCall(List<Item> oldData, List<Item> newData){
        mOldData = oldData;
        mNewData = newData;
    }

    @Override
    public int getOldListSize() {
        return mOldData.size();
    }

    @Override
    public int getNewListSize() {
        return mNewData.size();
    }

    @Override
    public boolean areItemsTheSame(int oldDataPos, int newDataPos) {
        return mOldData.get(oldDataPos).getId()==mNewData.get(newDataPos).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldDataPos, int newDataPos) {
        Item oldItem = mOldData.get(oldDataPos);
        Item newItem = mNewData.get(newDataPos);
        return oldItem.getType()==newItem.getType() &&
                oldItem.getText()==newItem.getText() &&
                oldDataPos==newDataPos;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldDataPos, int newDataPos) {
        Item oldItem = mOldData.get(oldDataPos);
        Item newItem = mNewData.get(newDataPos);
        Bundle diff = new Bundle();
        if (oldItem.getText()!=newItem.getText()){
            diff.putString("text", newItem.getText());
        }
        if (oldDataPos!=newDataPos) {
            diff.putInt("position", newDataPos);
        }
        if (diff.size()==0) {
            return null;
        }
        return diff;
    }

}
