package zhan.whitetoolbar;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class WhiteToolbarActivity extends AppCompatActivity {

  protected Toolbar toolbar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_white);

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
