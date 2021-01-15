package com.windfallsheng.baseadapter.adapter;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import java.util.List;

/**
 * @Author: lzsheng
 */
public abstract class BaseMultipleItemAdapter<T extends IMultipleItem, VH extends BaseViewHolder> extends BaseAdapter<T, VH> {

    /**
     * itemType及与它对应的布局文件的映射集合；
     */
    private SparseIntArray itemTypeLayouts = new SparseIntArray();

    public BaseMultipleItemAdapter() {
    }

    public BaseMultipleItemAdapter(List<T> datas) {
        super(datas);
    }

    @Override
    public int getItemViewType(int position) {
        if (this.mDatas != null) {
            T t = this.mDatas.get(position);
            if (t != null) {
                return t.itemType();
            }
        }
        return 0;
    }

    protected VH onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutResId = itemTypeLayouts.get(viewType);
        return createBaseViewHolder(parent, layoutResId);
    }

    /**
     * 添加itemType及与它对应的布局文件到这个映射集合中；
     *
     * @param viewType
     * @param layoutResId
     */
    protected void addItemType(int viewType, @LayoutRes int layoutResId) {
        itemTypeLayouts.put(viewType, layoutResId);
    }

}
