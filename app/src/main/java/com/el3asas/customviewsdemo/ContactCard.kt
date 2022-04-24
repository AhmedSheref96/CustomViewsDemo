package com.el3asas.customviewsdemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.withStyledAttributes
import kotlin.math.min


@SuppressLint("ResourceType")
class ContactCard(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var image: ShapeDrawable? = null
    var name: String = ""
    var age: String = ""
    var ageTextSize: Float = 0f
    var nameTextSize: Float = 0f

    private val namePaint = Paint()
    private val agePaint = Paint()

    init {
        isClickable = true
        context.withStyledAttributes(attrs, R.styleable.ContactCard) {
            image = ShapeDrawable(OvalShape())
            image?.paint?.color = Color.BLUE
            nameTextSize = getDimensionPixelSize(R.styleable.ContactCard_nameTextSize, 25).toFloat()
            ageTextSize = getDimensionPixelSize(R.styleable.ContactCard_ageTextSize, 25).toFloat()
            name = getString(R.styleable.ContactCard_profileName) ?: ""
            age = getString(R.styleable.ContactCard_profileAge) ?: ""
        }

//        namePaint.textAlign = Paint.Align.RIGHT
        namePaint.color = Color.BLUE
        namePaint.isAntiAlias = true
        namePaint.typeface = Typeface.DEFAULT_BOLD
        namePaint.textSize = nameTextSize
//        agePaint.textAlign = Paint.Align.CENTER
        agePaint.color = Color.GRAY
        agePaint.isAntiAlias = true
        agePaint.typeface = Typeface.SANS_SERIF
        agePaint.textSize = ageTextSize
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val desiredWidth = minimumWidth + paddingLeft + paddingRight
        val desiredHeight = minimumHeight + paddingTop + paddingBottom

        Log.v("[View name] onMeasure w", MeasureSpec.toString(widthMeasureSpec))
        Log.v("[View name] onMeasure h", MeasureSpec.toString(heightMeasureSpec))

        setMeasuredDimension(
            measureDimension(desiredWidth, widthSize),
            measureDimension(desiredHeight, heightSize)
        )
    }

    private fun measureDimension(desiredSize: Int, measureSpec: Int): Int {
        var result: Int
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize
        } else {
            result = desiredSize
            if (specMode == MeasureSpec.AT_MOST) {
                result = min(result, specSize)
            }
        }
        if (result < desiredSize) {
            Log.e("ChartView", "The view is too small, the content might get cut")
        }
        return result
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (image == null)
            Log.d("", "onDraw: ---------------- image null")
        else
            Log.d("", "onDraw: ---------------- image not null")
        image?.setBounds(0, 0, 0, 0)
        image?.draw(canvas)

        canvas.drawText(name, 100f, 300f, namePaint)
        canvas.drawText(age, 100f, 300f+nameTextSize+20f, agePaint)

    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true
        invalidate()
        return true
    }

}