package zhan.whitetoolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import zhan.whitetoolbar.utils.StatusBarUtil;

public class WhiteMiToolbarActivity extends AppCompatActivity {

  protected Toolbar toolbar;
  protected int mPhoneType;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //设置状态栏黑色字体图标
    mPhoneType = StatusBarUtil.StatusBarLightMode(this);

    setContentView(R.layout.activity_white_mi);

    toolbar = (Toolbar) findViewById(R.id.toolbar);
    initToolbar("White Toolbar");
  }

  private void initToolbar(String title) {
    toolbar.setTitle(title);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(true);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        finish();
      }
    });
  }
}
