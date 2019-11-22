package zhan.whitetoolbar;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import zhan.whitetoolbar.utils.StatusBarUtil;

public class WhiteMiToolbarActivity extends AppCompatActivity {

  protected Toolbar toolbar;
  protected int mPhoneType;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mPhoneType = StatusBarUtil.StatusBarLightMode(this);
    setContentView(R.layout.activity_white_mi);
    toolbar = findViewById(R.id.toolbar);
    initToolbar("White Toolbar");
  }

  private void initToolbar(String title) {
    toolbar.setTitle(title);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(true);
    toolbar.setNavigationOnClickListener(v -> finish());
  }
}
