package com.codegemz.kotlinx.lesson2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {
    private lateinit var view: MainView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = MainView()
        view.setContentView(this)
    }
}

class MainView : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            button("Send intent to activity") {
                onClick {
                    // try to write your text
                    val intent = Intent(ctx, AboutActivity::class.java)
                    intent.putExtra("about_string", "This program wrote KotlinX")
                    ctx.startActivity(intent)
                    // or easier
                    // startActivity<AboutActivity>("about_string" to "This program wrote KotlinX")
                }
            }.lparams(width = matchParent, height = wrapContent) {
                topMargin = dip(50)
                leftPadding = dip(50)
                rightPadding = dip(50)
            }
        }
    }
}
