package com.amp.layoutviewpagersample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amp.view.CurrentPageListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layouts = arrayOf(R.layout.layout_1, R.layout.layout_2)
        viewPager.setLayouts(layouts.toList())
        viewPager.setCurrentPageListener(object : CurrentPageListener {
            override fun currentPageDisplayed(currentPosition: Int) {
                Toast.makeText(this@MainActivity, "$currentPosition", Toast.LENGTH_SHORT).show()
            }

        })
    }
}