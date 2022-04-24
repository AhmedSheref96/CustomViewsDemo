package com.el3asas.customviewsdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactCard = findViewById<ContactCard>(R.id.card)
        val imageView = findViewById<ImageView>(R.id.image)
        imageView.setImageDrawable(contactCard.image)
    }
}