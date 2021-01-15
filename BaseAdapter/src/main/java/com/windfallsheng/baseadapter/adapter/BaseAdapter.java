package com.windfallsheng.baseadapter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.windfallsheng.baseadapter.listener.OnRecyclerViewItemChildClick;
import com.windfallsheng.baseadapter.listener.OnRecyclerViewItemChildLongClick;
import com.windfallsheng.baseadapter.listener.OnRecyclerViewItemClick;
import com.windfallsheng.baseadapter.listener.OnRecyclerViewItemLongClick;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @Author: lzsheng
 */
public abstract class BaseAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<T> mDatas = new ArrayList<>();
    /**
     * item行的点击事件
     */
    protected OnRecyclerViewItemClick mOnRecyclerViewItemClick;
    /**
     * item行的长按事件
     */
    protected OnRecyclerViewItemLongClick mOnRecyclerViewItemLongClick;
    /**
     * item行中子控件的点击事件
     */
    protected OnRecyclerViewItemChildClick mOnRecyclerViewItemChildClick;
    /**
     * item行中子控件的长按事件
     */
    protected OnRecyclerViewItemChildLongClick mOnRecyclerViewItemChildLongClick;
    /**
     * 用于保存需要设置点击事件的 ViewId
     */
    protected LinkedHashSet<Integer> mChildClickViewIds;
    /**
     * 用于保存需要设置长按点击事件的 ViewId
     */
    protected LinkedHashSet<Integer> mChildLongClickViewIds;

    public BaseAdapter() {
    }

    public BaseAdapter(List<T> datas) {
        if (datas != null) {
            this.mDatas = datas;
        }
    }

    public void add(T data) {
        if (data != null) {
            this.mDatas.add(data);
        }
    }

    public void addAll(List<T> datas) {
        if (datas != null) {
            this.mDatas.addAll(datas);
        }
    }

    public void setOnRecyclerViewItemClick(OnRecyclerViewItemClick<T> onRecyclerViewItemClick) {
        mOnRecyclerViewItemClick = onRecyclerViewItemClick;
    }

    public void setOnRecyclerViewItemLongClick(OnRecyclerViewItemLongClick<T> onRecyclerViewItemLongClick) {
        mOnRecyclerViewItemLongClick = onRecyclerViewItemLongClick;
    }

    public void setOnRecyclerViewItemChildClick(OnRecyclerViewItemChildClick<T> onRecyclerViewItemChildClick) {
        mOnRecyclerViewItemChildClick = onRecyclerViewItemChildClick;
    }

    public void setOnRecyclerViewItemChildLongClick(OnRecyclerViewItemChildLongClick<T> onRecyclerViewItemChildLongClick) {
        mOnRecyclerViewItemChildLongClick = onRecyclerViewItemChildLongClick;
    }

    @Override
    public void onBindViewHolder(@NonNull VH viewHolder, int position) {
        T t = mDatas.get(position);
        convert(viewHolder, t, position);
    }

    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VH viewHolder = (VH) onCreateDefViewHolder(parent, viewType);
        bindViewClickListener(viewHolder, viewType);
        return viewHolder;
    }

    /**
     * Override this method and return your ViewHolder.
     */
    protected abstract VH onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType);

    protected abstract void convert(@NonNull VH viewHolder, T t, int position);

    @Override
    public int getItemCount() {
        if (mDatas != null) {
            return mDatas.size();
        }
        return 0;
    }

    protected VH createBaseViewHolder(@NonNull ViewGroup parent, @LayoutRes int layoutResId) {
        VH viewHolder = (VH) new BaseViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(layoutResId, parent, false));
        return viewHolder;
    }

    /**
     * 绑定监听事件
     *
     * @param viewHolder
     * @param viewType
     */
    private void bindViewClickListener(VH viewHolder, int viewType) {
        bindViewItemClickListener(viewHolder);
        bindViewItemChildClickListener(viewHolder);
    }

    private void bindViewItemChildClickListener(VH viewHolder) {
        if (mOnRecyclerViewItemChildClick != null && mChildClickViewIds != null) {
            for (int viewId : mChildClickViewIds) {
                View viewChild = viewHolder.getViewOrNull(viewId);
                if (viewChild != null) {
                    viewChild.setOnClickListener(v -> {
                        int position = viewHolder.getAdapterPosition();
                        T t = getDataByPosition(position);
                        mOnRecyclerViewItemChildClick.OnItemChildClick(v, t, position);
                    });
                }
            }
        }
        if (mOnRecyclerViewItemChildLongClick != null && mChildLongClickViewIds != null) {
            for (int viewId : mChildLongClickViewIds) {
                View viewChild = viewHolder.getViewOrNull(viewId);
                if (viewChild != null) {
                    viewChild.setOnLongClickListener(v -> {
                        int position = viewHolder.getAdapterPosition();
                        T t = getDataByPosition(position);
                        mOnRecyclerViewItemChildLongClick.OnItemChildLongClick(v, t, position);
                        return true;
                    });
                }
            }
        }
    }

    private void bindViewItemClickListener(VH viewHolder) {
        if (mOnRecyclerViewItemClick != null) {
            viewHolder.itemView.setOnClickListener(v -> {
                int position = viewHolder.getAdapterPosition();
                T t = getDataByPosition(position);
                mOnRecyclerViewItemClick.OnItemClick(v, t, position);
            });
        }
        if (mOnRecyclerViewItemLongClick != null) {
            viewHolder.itemView.setOnLongClickListener(v -> {
                int position = viewHolder.getAdapterPosition();
                T t = getDataByPosition(position);
                mOnRecyclerViewItemLongClick.OnItemLongClick(v, t, position);
                return true;
            });
        }
    }

    private T getDataByPosition(int position) {
        T t = null;
        if (position != RecyclerView.NO_POSITION) {
            t = mDatas.get(position);
        }
        return t;
    }

    /**
     * 设置需要点击事件的子view
     *
     * @param viewIds intArray
     */
    protected void addChildClickViewIds(@IdRes int... viewIds) {
        if (mChildClickViewIds == null) {
            mChildClickViewIds = new LinkedHashSet<>();
        }
        for (int viewId : viewIds) {
            mChildClickViewIds.add(viewId);
        }
    }

    /**
     * 设置需要长按点击事件的子view
     *
     * @param viewIds intArray
     */
    protected void addChildLongClickViewIds(@IdRes int... viewIds) {
        if (mChildLongClickViewIds == null) {
            mChildLongClickViewIds = new LinkedHashSet<>();
        }
        for (int viewId : viewIds) {
            mChildLongClickViewIds.add(viewId);
        }
    }
}
