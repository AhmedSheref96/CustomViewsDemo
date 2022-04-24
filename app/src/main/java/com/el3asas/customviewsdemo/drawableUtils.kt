package com.el3asas.customviewsdemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.core.content.res.TypedArrayUtils.obtainAttributes


@SuppressLint("RestrictedApi")
fun getAttrDrawable(context: Context, attrs: AttributeSet, attr: Int): Drawable? {
    val a = obtainAttributes(context.resources, context.theme, attrs, intArrayOf(attr))
    val resId = a.getResourceId(0, 0)
    var drawable: Drawable? = null
    if (resId != 0) {
//        drawable = getD(context, resId)
        if (drawable == null) {
            drawable = a.getDrawable(0)
        }
    }
    a.recycle()
    return drawable
}