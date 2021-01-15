package com.windfallsheng.baserecyclerviewadapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.windfallsheng.baserecyclerviewadapter.multiple.MultipleListActivity;
import com.windfallsheng.baserecyclerviewadapter.simple.SimpleListActivity;

/**
 * @Author: lzsheng
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleItem(View view) {
        startActivity(new Intent(MainActivity.this, SimpleListActivity.class));
    }

    public void multipleItem(View view) {
        startActivity(new Intent(MainActivity.this, MultipleListActivity.class));
    }
}