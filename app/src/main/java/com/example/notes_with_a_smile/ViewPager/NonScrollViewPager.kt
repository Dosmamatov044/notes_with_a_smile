package com.example.notes_with_a_smile.ViewPager

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class NonScrollViewPager : ViewPager {
    private val isScrollBarEvent = false

    constructor(context: Context) : super(context) {}
    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return isScrollBarEvent && super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return isScrollBarEvent && super.onInterceptTouchEvent(ev)
    }
}
