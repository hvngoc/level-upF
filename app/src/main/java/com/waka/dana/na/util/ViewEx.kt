package com.waka.dana.na.util

import android.view.View

/**
 * Created by hvngoc on 7/29/22
 */
fun View.visibleIf(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.setOnSafeClickListener(action: (v: View?) -> Unit, millis: Long = 700) {
    setOnClickListener(object : OnThrottleClickListener(millis) {
        override fun onSingleClick(v: View?) {
            action(v)
        }
    })
}