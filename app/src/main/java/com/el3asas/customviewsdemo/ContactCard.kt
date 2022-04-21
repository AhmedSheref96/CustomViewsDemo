package com.el3asas.customviewsdemo

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class ContactCard(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var image: Int = 0
    private var name: String = ""
    private var age: String = ""

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true


        return true
    }


}