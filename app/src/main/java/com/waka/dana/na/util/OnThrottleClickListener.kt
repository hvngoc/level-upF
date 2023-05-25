package com.waka.dana.na.util

import android.os.SystemClock
import android.view.View

/**
 * Created by hvngoc on 5/25/23
 */
abstract class OnThrottleClickListener @JvmOverloads constructor(
    private val minClickInterval: Long = 600 //default value for minclick time
) : View.OnClickListener {

    /**
     * The time the last click was applied
     */
    private var mLastClickTime: Long = 0

    /**
     * @param v The view that was clicked.
     */
    abstract fun onSingleClick(v: View?)

    override fun onClick(v: View?) {
        val currentClickTime: Long = SystemClock.elapsedRealtime()
        val elapsedTime = currentClickTime - mLastClickTime
        if (elapsedTime <= minClickInterval) return
        mLastClickTime = currentClickTime
        onSingleClick(v)
    }
}