package com.shakbari.clean.base.extension

import android.app.Activity
import android.graphics.Point

fun Activity.getDisplayDimens():DisplayParams  {
    val display = windowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    return DisplayParams(size.x, size.y)
}
class DisplayParams internal constructor(var x: Int, var y: Int)
