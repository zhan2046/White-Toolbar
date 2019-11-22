package zhan.whitetoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void whiteClick(View view) {
    launchActivity(WhiteToolbarActivity.class);
  }

  public void whiteImageClick(View view) {
    launchActivity(WhiteToolbarToImageActivity.class);
  }

  public void whiteMiClick(View view) {
    launchActivity(WhiteMiToolbarActivity.class);
  }

  private void launchActivity(Class clazz) {
    Intent intent = new Intent(this, clazz);
    startActivity(intent);
  }
}
