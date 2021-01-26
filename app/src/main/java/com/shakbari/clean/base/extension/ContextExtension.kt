@file:Suppress("NOTHING_TO_INLINE")

package com.shakbari.clean.base.extension

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.Toast
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.shakbari.clean.BuildConfig

//==================================================================================================> TOAST
fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
fun Context.toast(resId: Int, ) = Toast.makeText(this, resources.getString(resId), Toast.LENGTH_SHORT).show()

fun Context.toast(message: CharSequence, isLengthLong: Boolean = true) =
        Toast.makeText(this, message, if (isLengthLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()

fun Context.toast(resId: Int, isLengthLong: Boolean = true) =
        Toast.makeText(this, resources.getString(resId), if (isLengthLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()

//==================================================================================================> LOG
fun Any.logE(message: String?) {
    if (BuildConfig.DEBUG) {
        Log.e("ExtensionLog", " --> $message")
    }
}

fun Any.logD(message: String?) {
    if (BuildConfig.DEBUG) {
        Log.d("ExtensionLog", " --> $message")
    }
}


//==================================================================================================> Other

fun Context.getAnimatedVectorDrawable(@DrawableRes resId: Int): AnimatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(this, resId)!!
fun Context.getDrawableByResId(@DrawableRes resId: Int): Drawable? = ContextCompat.getDrawable(this, resId)
fun Context.getColorByResId(@ColorRes resId: Int): Int = ContextCompat.getColor(this, resId)
fun Context.getDimenByResId(@DimenRes resId: Int): Int = resources.getDimensionPixelSize(resId)
fun Context.getStringByResId(@StringRes resId: Int): String = resources.getString(resId)


fun Context.copyToClipboard(key: String, text: CharSequence) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(key, text)
    clipboard.setPrimaryClip(clip)
}

