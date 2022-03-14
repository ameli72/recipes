package com.andrewmeli.libraries.uicomponents.extensions

import android.view.View


const val DEFAULT_DELAY_MS = 2000L
inline fun View.onSingleClickListener(
    delayMs: Long = DEFAULT_DELAY_MS,
    crossinline l: (View) -> Unit
) {
    setOnClickListener(object : View.OnClickListener {
        private var notClicked = true
        override fun onClick(view: View) {
            if (notClicked) {
                notClicked = false
                l(view)
                view.postDelayed({ notClicked = true }, delayMs)
            }
        }
    })
}