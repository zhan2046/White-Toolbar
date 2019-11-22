package zhan.whitetoolbar

import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun whiteClick(view: View) {
        launchActivity(WhiteToolbarActivity::class.java)
    }

    fun whiteImageClick(view: View) {
        launchActivity(WhiteToolbarToImageActivity::class.java)
    }

    fun whiteMiClick(view: View) {
        launchActivity(WhiteMiToolbarActivity::class.java)
    }

    private fun launchActivity(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }
}
