package com.windfallsheng.baserecyclerviewadapter.multiple;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.windfallsheng.baseadapter.listener.OnRecyclerViewItemChildClick;
import com.windfallsheng.baseadapter.listener.OnRecyclerViewItemClick;
import com.windfallsheng.baserecyclerviewadapter.R;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzsheng
 */
public class MultipleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_list);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MultipleListActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<MyMultipleBean> data = new ArrayList<>();
        int index = 0;
        for (int i = 'a'; i < 'z' + 1; i++) {
            index++;
            MyMultipleBean bean = new MyMultipleBean();
            bean.setTitle(String.valueOf((char) i));
            bean.setItemType((index % 3) + 1);
            data.add(bean);
        }
        MyMultipleAdapter adapter = new MyMultipleAdapter();
        adapter.addAll(data);
        recyclerView.setAdapter(adapter);

        adapter.setOnRecyclerViewItemClick(new OnRecyclerViewItemClick<MyMultipleBean>() {
            @Override
            public void OnItemClick(View itemView, MyMultipleBean myMultipleBean, int position) {
                Toast.makeText(MultipleListActivity.this, "您点击的位置是：" + position + "==" + myMultipleBean.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnRecyclerViewItemChildClick(new OnRecyclerViewItemChildClick<MyMultipleBean>() {
            @Override
            public void OnItemChildClick(View viewChild, MyMultipleBean myMultipleBean, int position) {
                switch (viewChild.getId()) {
                    case R.id.textview:
                        Toast.makeText(MultipleListActivity.this, "您点击的是textview：" + myMultipleBean.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.textview2:
                        Toast.makeText(MultipleListActivity.this, "您点击的位置是textview2：" + myMultipleBean.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

    }

}