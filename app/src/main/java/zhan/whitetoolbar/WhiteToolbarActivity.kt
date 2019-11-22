package zhan.whitetoolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class WhiteToolbarActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_white)

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
