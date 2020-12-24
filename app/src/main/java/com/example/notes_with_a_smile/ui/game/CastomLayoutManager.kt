package com.example.notes_with_a_smile.ui.game

import android.content.Context
import android.graphics.PointF
import android.util.DisplayMetrics
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView


class CustomLayoutManager(context: Context) : LinearLayoutManager(context) {
    private val mContext: Context = context
    override fun smoothScrollToPosition(recyclerView: RecyclerView,
                                        state: RecyclerView.State, position: Int) {
        val smoothScroller: LinearSmoothScroller = object : LinearSmoothScroller(mContext) {
            //This controls the direction in which smoothScroll looks
            //for your view
            override fun computeScrollVectorForPosition(targetPosition: Int): PointF? {
                return this@CustomLayoutManager
                        .computeScrollVectorForPosition(targetPosition)
            }

            //This returns the milliseconds it takes to
            //scroll one pixel.
            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                return MILLISECONDS_PER_INCH / displayMetrics.densityDpi
            }
        }
        smoothScroller.targetPosition = position
        startSmoothScroll(smoothScroller)
    }

    companion object {
        private const val MILLISECONDS_PER_INCH = 50f
    }

}