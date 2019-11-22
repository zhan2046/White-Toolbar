package zhan.whitetoolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import zhan.whitetoolbar.utils.StatusBarUtil

class WhiteMiToolbarActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private var mPhoneType: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPhoneType = StatusBarUtil.StatusBarLightMode(this)
        setContentView(R.layout.activity_white_mi)
        toolbar = findViewById(R.id.toolbar)
        initToolbar("White Toolbar")
    }

    private fun initToolbar(title: String) {
        toolbar.title = title
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }
    }
}
