package com.windfallsheng.baseadapter.listener;

import android.view.View;

/**
 * @Author: lzsheng
 */
public interface OnRecyclerViewItemLongClick<T> {
    void OnItemLongClick(View itemView, T t, int position);
}
