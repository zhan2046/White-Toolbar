package zhan.whitetoolbar;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import zhan.whitetoolbar.utils.AppBarStateChangeListener;
import zhan.whitetoolbar.utils.StatusBarUtil;

public class WhiteToolbarToImageActivity extends AppCompatActivity {

  protected Toolbar toolbar;
  protected AppBarLayout appBar;
  protected int mPhoneType;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mPhoneType = StatusBarUtil.StatusBarLightMode(this);

    setContentView(R.layout.activity_white_image);

    StatusBarUtil.StatusBarDarkMode(this, mPhoneType);

    toolbar = (Toolbar) findViewById(R.id.toolbar);
    appBar = (AppBarLayout) findViewById(R.id.app_bar);
    initToolbar();

    int systemBarHeight = StatusBarUtil.getStatusHeight(this);
    toolbar.setPadding(0, systemBarHeight, 0, 0);

    CollapsingToolbarLayout.LayoutParams params = (CollapsingToolbarLayout.LayoutParams) toolbar.getLayoutParams();
    params.height += systemBarHeight;

    initListener();
  }

  private void initListener() {
    appBar.addOnOffsetChangedListener(new AppBarStateChangeListener() {

      @Override public void onStateChanged(AppBarLayout appBarLayout, State state) {
        if (state == State.EXPANDED) {
          hideToolbar();

        } else if (state == State.COLLAPSED) {
          showToolbar();

        } else {
          hideToolbar();
        }
      }
    });
  }

  private void showToolbar() {
    if (toolbar.getBackground() == null) {
      toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_toolbar_mark));
      StatusBarUtil.StatusBarLightMode(this);
    }
  }

  private void hideToolbar() {
    if (toolbar.getBackground() != null) {
      toolbar.setBackgroundDrawable(null);
      StatusBarUtil.StatusBarDarkMode(this, mPhoneType);
    }
  }

  private void initToolbar() {
    toolbar.setTitle("");
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
