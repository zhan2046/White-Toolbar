package zhan.whitetoolbar.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressLint("ObsoleteSdkInt")
public class StatusBarUtil {

  @TargetApi(19)
  public static void transparencyBar(Activity activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      Window window = activity.getWindow();
      window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      window.getDecorView()
          .setSystemUiVisibility(
              View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      window.setStatusBarColor(Color.TRANSPARENT);
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      Window window = activity.getWindow();
      window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
          WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
  }

  public static void setStatusBarColor(Activity activity, int colorId) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      Window window = activity.getWindow();
      //      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      window.setStatusBarColor(activity.getResources().getColor(colorId));
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      transparencyBar(activity);
      SystemBarTintManager tintManager = new SystemBarTintManager(activity);
      tintManager.setStatusBarTintEnabled(true);
      tintManager.setStatusBarTintResource(colorId);
    }
  }

  public static int StatusBarLightMode(Activity activity) {
    int result = 0;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      if (MIUISetStatusBarLightMode(activity.getWindow(), true)) {
        result = 1;
      } else if (FlymeSetStatusBarLightMode(activity.getWindow(), true)) {
        result = 2;
      } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        activity.getWindow()
            .getDecorView()
            .setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        result = 3;
      }
    }
    return result;
  }

  @RequiresApi(api = Build.VERSION_CODES.M)
  public static void StatusBarLightMode(Activity activity, int type) {
    if (type == 1) {
      MIUISetStatusBarLightMode(activity.getWindow(), true);
    } else if (type == 2) {
      FlymeSetStatusBarLightMode(activity.getWindow(), true);
    } else if (type == 3) {
      activity.getWindow()
          .getDecorView()
          .setSystemUiVisibility(
              View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                      View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
  }

  public static void StatusBarDarkMode(Activity activity, int type) {
    if (type == 1) {
      MIUISetStatusBarLightMode(activity.getWindow(), false);
    } else if (type == 2) {
      FlymeSetStatusBarLightMode(activity.getWindow(), false);
    } else if (type == 3) {
      activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
    }
  }

  public static boolean FlymeSetStatusBarLightMode(Window window, boolean dark) {
    boolean result = false;
    if (window != null) {
      try {
        WindowManager.LayoutParams lp = window.getAttributes();
        Field darkFlag =
            WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
        Field meizuFlags = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
        darkFlag.setAccessible(true);
        meizuFlags.setAccessible(true);
        int bit = darkFlag.getInt(null);
        int value = meizuFlags.getInt(lp);
        if (dark) {
          value |= bit;
        } else {
          value &= ~bit;
        }
        meizuFlags.setInt(lp, value);
        window.setAttributes(lp);
        result = true;
      } catch (Exception e) {

      }
    }
    return result;
  }

  @SuppressLint("PrivateApi")
  public static boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
    boolean result = false;
    if (window != null) {
      Class clazz = window.getClass();
      try {
        int darkModeFlag = 0;
        Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
        darkModeFlag = field.getInt(layoutParams);
        Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
        if (dark) {
          extraFlagField.invoke(window, darkModeFlag, darkModeFlag);
        } else {
          extraFlagField.invoke(window, 0, darkModeFlag);
        }
        result = true;
      } catch (Exception e) {

      }
    }
    return result;
  }

  @SuppressLint("PrivateApi")
  public static int getStatusHeight(Context context) {
    int statusHeight = -1;
    try {
      Class clazz = Class.forName("com.android.internal.R$dimen");
      Object object = clazz.newInstance();

      int height = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
      statusHeight = context.getResources().getDimensionPixelSize(height);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return statusHeight;
  }
}

