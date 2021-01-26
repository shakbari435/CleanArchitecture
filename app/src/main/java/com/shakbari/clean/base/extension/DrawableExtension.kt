@file:Suppress("NOTHING_TO_INLINE")

package com.shakbari.clean.base.extension

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.core.graphics.drawable.DrawableCompat

inline fun Drawable.tint(@ColorInt color: Int){
    DrawableCompat.setTint(this, color)
}

