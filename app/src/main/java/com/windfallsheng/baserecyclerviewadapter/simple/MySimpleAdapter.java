package com.windfallsheng.baserecyclerviewadapter.simple;

import androidx.annotation.NonNull;
import com.windfallsheng.baseadapter.adapter.BaseSimpleAdapter;
import com.windfallsheng.baseadapter.adapter.BaseViewHolder;
import com.windfallsheng.baserecyclerviewadapter.R;

/**
 * @Author: lzsheng
 */
class MySimpleAdapter extends BaseSimpleAdapter<String, BaseViewHolder> {

    public MySimpleAdapter() {
        addChildClickViewIds(R.id.textview);
    }

    @Override
    protected int getViewHolderLayoutResId() {
        return R.layout.recycler_item_simple;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder viewHolder, String s, int position) {
        viewHolder.setText(R.id.textview, "Hello " + s);
    }
}
