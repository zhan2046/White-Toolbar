package zhan.whitetoolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import zhan.whitetoolbar.utils.AppBarStateChangeListener
import zhan.whitetoolbar.utils.StatusBarUtil

class WhiteToolbarToImageActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var appBar: AppBarLayout
    private var mPhoneType: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPhoneType = StatusBarUtil.StatusBarLightMode(this)

        setContentView(R.layout.activity_white_image)

        StatusBarUtil.StatusBarDarkMode(this, mPhoneType)

        toolbar = findViewById(R.id.toolbar)
        appBar = findViewById(R.id.app_bar)
        initToolbar()

        val systemBarHeight = StatusBarUtil.getStatusHeight(this)
        toolbar.setPadding(0, systemBarHeight, 0, 0)

        val params = toolbar.layoutParams as CollapsingToolbarLayout.LayoutParams
        params.height += systemBarHeight

        initListener()
    }

    private fun initListener() {
        appBar.addOnOffsetChangedListener(object : AppBarStateChangeListener() {

            override fun onStateChanged(appBarLayout: AppBarLayout, state: AppBarStateChangeListener.State) {
                if (state === AppBarStateChangeListener.State.EXPANDED) {
                    hideToolbar()

                } else if (state === AppBarStateChangeListener.State.COLLAPSED) {
                    showToolbar()

                } else {
                    hideToolbar()
                }
            }
        })
    }

    private fun showToolbar() {
        if (toolbar.background == null) {
            toolbar.setBackgroundDrawable(resources.getDrawable(R.drawable.shape_toolbar_mark))
            StatusBarUtil.StatusBarLightMode(this)
        }
    }

    private fun hideToolbar() {
        if (toolbar.background != null) {
            toolbar.setBackgroundDrawable(null)
            StatusBarUtil.StatusBarDarkMode(this, mPhoneType)
        }
    }

    private fun initToolbar() {
        toolbar.title = ""
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }
}
