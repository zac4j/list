package com.zac4j.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.zac4j.list.ui.ItemOperationActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private RecyclerView mListView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.main_btn_item_operation).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.main_btn_item_operation:
        startActivity(new Intent(MainActivity.this, ItemOperationActivity.class));
        break;
    }
  }
}
