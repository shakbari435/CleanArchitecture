package com.shakbari.clean.base.extension

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

private val colorEvaluator by lazy { ArgbEvaluator() }

fun TextView.animateTextColor(to: Int) {
    animate().cancel()
    val from = currentTextColor
    computeColors(from, to) { setTextColor(it) }
}

fun FloatingActionButton.animateBackgroundColor(to: Int) {
    animate().cancel()
    val from = backgroundTintList!!.defaultColor
    computeColors(from, to) {
        backgroundTintList = ColorStateList.valueOf(it)
    }
}

fun View.animateBackgroundColor(to: Int) {
    animate().cancel()

    val from = if (background != null && background is ColorDrawable) {
        (background as ColorDrawable).color
    } else context.colorSurface()
    computeColors(from, to) { setBackgroundColor(it) }
}

private fun computeColors(from: Int, to: Int, func: (Int) -> Unit) {
    val animation = ValueAnimator.ofObject(colorEvaluator, from, to)
    animation.duration = 150
    animation.addUpdateListener {
        func(it.animatedValue as Int)
    }
    animation.start()
}

fun Context.scrimBackground(): Int {
    return themeAttributeToColor(com.google.android.material.R.attr.scrimBackground)
}

fun Context.textColorPrimary(): Int {
    return themeAttributeToColor(android.R.attr.textColorPrimary)
}

fun Context.textColorSecondary(): Int {
    return themeAttributeToColor(android.R.attr.textColorSecondary)
}

fun Context.colorSurface(): Int {
    return themeAttributeToColor(com.google.android.material.R.attr.colorSurface)
}

fun Context.colorBackground(): Int {
    return themeAttributeToColor(android.R.attr.colorBackground)
}

fun Context.colorPrimary(): Int {
    return themeAttributeToColor(com.google.android.material.R.attr.colorPrimary)
}

fun Context.colorAccent(): Int {
    return themeAttributeToColor(com.google.android.material.R.attr.colorAccent)
}

fun Context.colorControlNormal(): Int {
    return themeAttributeToColor(com.google.android.material.R.attr.colorControlNormal)
}

fun Context.colorPrimaryId(): Int {
    return themeAttributeToResId(com.google.android.material.R.attr.colorPrimary)
}

fun Context.themeAttributeToColor(themeAttributeId: Int, fallbackColor: Int = Color.WHITE): Int {
    val outValue = TypedValue()
    val theme = this.theme
    val resolved = theme.resolveAttribute(themeAttributeId, outValue, true)
    if (resolved) {
        return ContextCompat.getColor(this, outValue.resourceId)
    }
    return fallbackColor
}

fun Context.themeAttributeToResId(themeAttributeId: Int): Int {
    val outValue = TypedValue()
    val theme = this.theme
    val resolved = theme.resolveAttribute(themeAttributeId, outValue, true)
    if (resolved) {
        return outValue.resourceId
    }
    return -1
}