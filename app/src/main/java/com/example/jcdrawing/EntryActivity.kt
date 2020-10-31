package com.example.jcdrawing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class EntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)
    }

    fun startJetpackComposeDraw(view: View) {
        startActivity(Intent(this, JcDrawActivity::class.java))
    }
    fun startNormalDraw(view: View) {
        startActivity(Intent(this, DrawActivity::class.java))
    }
}
