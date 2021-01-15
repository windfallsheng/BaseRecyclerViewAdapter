package com.windfallsheng.baserecyclerviewadapter.simple;

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
public class SimpleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SimpleListActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<String> data = new ArrayList<>();
        for (int i = 'a'; i < 'z' + 1; i++) {
            data.add(String.valueOf((char) i));
        }
        MySimpleAdapter adapter = new MySimpleAdapter();
        adapter.addAll(data);
        recyclerView.setAdapter(adapter);

        adapter.setOnRecyclerViewItemClick(new OnRecyclerViewItemClick<String>() {
            @Override
            public void OnItemClick(View itemView, String s, int position) {
                Toast.makeText(SimpleListActivity.this, "您点击的位置是：" + position + "==" + s, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnRecyclerViewItemChildClick(new OnRecyclerViewItemChildClick<String>() {
            @Override
            public void OnItemChildClick(View viewChild, String s, int position) {
                switch (viewChild.getId()) {
                    case R.id.textview:
                        Toast.makeText(SimpleListActivity.this, "您点击的是textview：" + s, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

    }

}