package com.windfallsheng.baserecyclerviewadapter.multiple;

import androidx.annotation.NonNull;
import com.windfallsheng.baseadapter.adapter.BaseMultipleItemAdapter;
import com.windfallsheng.baseadapter.adapter.BaseViewHolder;
import com.windfallsheng.baserecyclerviewadapter.R;

/**
 * @Author: lzsheng
 */
class MyMultipleAdapter extends BaseMultipleItemAdapter<MyMultipleBean, BaseViewHolder> {

    public MyMultipleAdapter() {
        addItemType(1, R.layout.recycler_item_multiple_a);
        addItemType(2, R.layout.recycler_item_multiple_b);
        addItemType(3, R.layout.recycler_item_multiple_c);
        addChildClickViewIds(R.id.textview, R.id.textview2);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder viewHolder, MyMultipleBean myMultipleBean, int position) {
        String title = myMultipleBean.getTitle();
        int itemViewType = viewHolder.getItemViewType();
        switch (itemViewType) {
            case 1:
                viewHolder.setText(R.id.textview, "Hello " + title);
                break;
            case 2:
                viewHolder.setText(R.id.textview, "Hello " + title);
                viewHolder.setText(R.id.textview2, title);
                break;
            case 3:
                viewHolder.setText(R.id.textview, "Hello " + title);
                viewHolder.setText(R.id.textview2, title);
                viewHolder.setText(R.id.textview3, title);
                break;
            default:
                break;
        }
    }
}
