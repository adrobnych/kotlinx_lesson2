package com.codegemz.kotlinx.lesson2

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.*

class AboutActivity : AppCompatActivity() {
    private lateinit var view: AboutView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = AboutView()
        view.setContentView(this)

        val aboutString: String = intent.getStringExtra("about_string")
        view.setText(aboutString)
    }
}

class AboutView : AnkoComponent<AboutActivity> {
    private lateinit var about: TextView

    fun setText(text: String) {
        about.text = text
    }

    override fun createView(ui: AnkoContext<AboutActivity>) = with(ui) {
        verticalLayout {
            textView {
                text = "About the program:"
                textSize = 18f
            }.lparams(width = wrapContent) {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = dip(30)
            }

            about = textView {
                textSize = 22f
                textColor = Color.GRAY
            }.lparams(width = wrapContent) {
                gravity = Gravity.CENTER_HORIZONTAL
                topMargin = dip(30)
            }
            background = ColorDrawable(Color.parseColor("#ECECEC"))
        }
    }
}
