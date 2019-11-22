package zhan.whitetoolbar;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

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

    toolbar = findViewById(R.id.toolbar);
    appBar = findViewById(R.id.app_bar);
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
    toolbar.setNavigationOnClickListener(v -> finish());
  }
}
