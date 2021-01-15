package com.windfallsheng.baserecyclerviewadapter.multiple;

import com.windfallsheng.baseadapter.adapter.IMultipleItem;

/**
 * @Author: lzsheng
 */
class MyMultipleBean implements IMultipleItem {

    private String title;
    private int itemType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int itemType() {
        return itemType;
    }
}
