package com.windfallsheng.baseadapter.adapter;

import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import java.util.List;

/**
 * @Author: lzsheng
 */
public abstract class BaseSimpleAdapter<T, VH extends BaseViewHolder> extends BaseAdapter<T, VH> {

    public BaseSimpleAdapter() {
    }

    public BaseSimpleAdapter(List<T> datas) {
        super(datas);
    }

    protected VH onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {
        return createBaseViewHolder(parent, getViewHolderLayoutResId());
    }

    /**
     * item的布局id
     *
     * @return
     */
    protected abstract @LayoutRes
    int getViewHolderLayoutResId();

}
