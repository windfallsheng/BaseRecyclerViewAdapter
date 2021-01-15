package com.windfallsheng.baseadapter.listener;

import android.view.View;

/**
 * @Author: lzsheng
 */
public interface OnRecyclerViewItemClick<T> {
    void OnItemClick(View itemView, T t, int position);
}
