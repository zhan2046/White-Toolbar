
White-Toolbar
===============

A toolbar color is white implement translucent bar sample for Android

Screenshots
===============
1, white toolbar implement translucent bar



![](https://github.com/ruzhan123/White-Toolbar/raw/master/gif/white_toolbar.png)




2, white toolbar implement translucent bar(4.4 MIUUI/4.4 Flyme/android6.0)



![](https://github.com/ruzhan123/White-Toolbar/raw/master/gif/white_toolbar_mi.png)




3, white toolbar implement translucent bar



![](https://github.com/ruzhan123/White-Toolbar/raw/master/gif/white_toolbar_image.png)






Usage
------
white toolbar implement translucent bar

```java

	<android.support.v7.widget.Toolbar
	  android:id="@+id/toolbar"
	  android:layout_width="match_parent"
	  android:layout_height="48dp"
	  app:titleTextAppearance="@style/ToolbarTitle"
	  android:background="@drawable/shape_toolbar_mark"/>
```

shape_toolbar_mark:
```java

	<?xml version="1.0" encoding="utf-8"?>
	<shape xmlns:android="http://schemas.android.com/apk/res/android"
	android:shape="rectangle">
	
	<gradient
	  android:angle="90"
	  android:centerColor="@color/centerColor"
	  android:endColor="@color/endColor"
	  android:startColor="@color/startColor" />
	</shape>
```

```java

	<color name="startColor">#FFFFFFFF</color>
	<color name="centerColor">#FFF5F5F5</color>
	<color name="endColor">#FFE0E0E0</color>
```

theme:
```java

	<activity android:name=".WhiteToolbarActivity" android:theme="@style/WhiteToolbarAppTheme"
	    android:screenOrientation="portrait"/>
	
	<activity android:name=".WhiteToolbarToImageActivity" android:theme="@style/WhiteToolbarAppThemeFull"
	    android:screenOrientation="portrait"/>
	
	<activity android:name=".WhiteMiToolbarActivity" android:theme="@style/WhiteToolbarAppTheme"
	    android:screenOrientation="portrait"/>
```

style.xml
```java

	<style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
	<item name="colorPrimary">@color/colorPrimary</item>
	<item name="colorPrimaryDark">@color/colorPrimaryDark</item>
	<item name="colorAccent">@color/colorAccent</item>
	</style>
	
	<style name="WhiteToolbarAppTheme" parent="AppTheme">
	<item name="windowActionBar">false</item>
	<item name="windowNoTitle">true</item>
	<item name="android:fitsSystemWindows">true</item>
	<item name="android:windowBackground">@color/white</item>
	</style>
```

style-v19.xml
```java

	<style name="WhiteToolbarAppTheme" parent="AppTheme">
	<item name="windowActionBar">false</item>
	<item name="windowNoTitle">true</item>
	<item name="android:fitsSystemWindows">true</item>
	<item name="android:windowBackground">@color/white</item>
	</style>
	
	<style name="WhiteToolbarAppThemeFull" parent="AppTheme">
	<item name="windowActionBar">false</item>
	<item name="windowNoTitle">true</item>
	<item name="android:windowTranslucentStatus">true</item>
	<item name="android:windowTranslucentNavigation">true</item>
	</style>
```


white toolbar implement translucent bar(4.4 MIUUI/4.4 Flyme/android6.0)
```java

	mPhoneType = StatusBarUtil.StatusBarLightMode(this);
```

Developed by
-------

 ruzhan - <a href='javascript:'>dev19921116@gmail.com</a>


License
-------

    Copyright 2017 ruzhan

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
	
