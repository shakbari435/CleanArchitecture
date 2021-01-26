@file:Suppress("NOTHING_TO_INLINE")

package com.shakbari.clean.base.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.annotation.LayoutRes
import androidx.annotation.Px
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.*

//==================================================================================================> Visibility

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.inVisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}
//==================================================================================================> enable and disable

fun View.disable() {
    this.isEnabled = false
    this.alpha = 0.3f
    if (this is ViewGroup) {
        for (i in 0 until childCount) {
            val v: View = this.getChildAt(i)
            v.isEnabled = false
        }
    }
}

fun View.enable() {
    this.isEnabled = true
    this.alpha = 1f
    if (this is ViewGroup) {
        for (i in 0 until childCount) {
            val v: View = this.getChildAt(i)
            v.isEnabled = true
        }
    }
}
//==================================================================================================> inflate

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)



//==================================================================================================> Other

fun View.setHeight(@Px heightPx: Int) {
    val params = this.layoutParams
    when (params) {
        is FrameLayout.LayoutParams -> params.height = heightPx
        is LinearLayout.LayoutParams -> params.height = heightPx
        is RelativeLayout.LayoutParams -> params.height = heightPx
        is CoordinatorLayout.LayoutParams -> params.height = heightPx
        is ConstraintLayout.LayoutParams -> params.height = heightPx
    }
    layoutParams = params
}

fun View.setWidth(@Px heightPx: Int) {
    val params = this.layoutParams
    when (params) {
        is FrameLayout.LayoutParams -> params.width = heightPx
        is LinearLayout.LayoutParams -> params.width = heightPx
        is RelativeLayout.LayoutParams -> params.width = heightPx
        is CoordinatorLayout.LayoutParams -> params.width = heightPx
        is ConstraintLayout.LayoutParams -> params.width = heightPx
    }
    layoutParams = params
}

fun View.setMargin(
        @Px left: Int = marginLeft,
        @Px top: Int = marginTop,
        @Px right: Int = marginRight,
        @Px bottom: Int = marginBottom
) {
    val params = this.layoutParams as? ViewGroup.MarginLayoutParams ?: return
    params.topMargin = top
    params.leftMargin = left
    params.rightMargin = right
    params.bottomMargin = bottom
    layoutParams = params
}
//==================================================================================================> Animation

fun View.scaleAnimate() {
    val animation = ScaleAnimation(
            1.15f, 1F, 1.15f, 1F,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
    this.animation = animation
    animation.duration = 100
    animation.start()
}
