package com.zac4j.list.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.zac4j.list.R;
import com.zac4j.list.adapter.ItemOperationListAdapter;
import com.zac4j.list.bean.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Page for operate item.
 * Created by Zaccc on 2018/2/26.
 */

public class ItemOperationActivity extends AppCompatActivity implements View.OnClickListener {

  private RecyclerView mListView;
  private ItemOperationListAdapter mAdapter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_item_operation);

    updateUi();

    addUiListeners();
  }

  private void updateUi() {
    mListView = findViewById(R.id.io_list_container);
    mListView.setLayoutManager(new LinearLayoutManager(this));

    mAdapter = new ItemOperationListAdapter(this);
    mListView.setAdapter(mAdapter);
  }

  private void addUiListeners() {
    findViewById(R.id.io_btn_add_header).setOnClickListener(this);
    findViewById(R.id.io_btn_insert_view).setOnClickListener(this);
    findViewById(R.id.io_btn_add_footer).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.io_btn_add_header:
        break;
      case R.id.io_btn_insert_view:
        break;
      case R.id.io_btn_add_footer:
        break;
    }
  }

  @Override
  protected void onStart() {
    super.onStart();
    List<Text> textList = generateListData();
    mAdapter.setData(textList);
  }

  private List<Text> generateListData() {
    List<Text> result = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < 20; i++) {
      String title = "Title -> " + i;
      String content = "Content -> " + random.nextInt();
      Text text = new Text(title, content);
      result.add(text);
    }
    return result;
  }
}
