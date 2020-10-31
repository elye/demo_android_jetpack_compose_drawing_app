package com.example.jcdrawing

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class DrawActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw)
    }
}

class CanvasView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0) :
    View(context, attrs, defStyleAttr, defStyleRes) {


    private val path = Path()
    private val paint = Paint().apply {
        strokeCap = Paint.Cap.ROUND
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            // A gesture is starting, move the path to the pointer's location
            MotionEvent.ACTION_DOWN -> path.moveTo(event.x, event.y)

            // Follow the pointer as it moves
            MotionEvent.ACTION_MOVE -> path.lineTo(event.x, event.y)

            // A gesture finished, stop drawing
            MotionEvent.ACTION_UP -> {}

            else -> return false
        }
        invalidate()
        return true
    }
}