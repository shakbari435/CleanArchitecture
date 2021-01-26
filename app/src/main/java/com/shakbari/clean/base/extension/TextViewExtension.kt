package com.shakbari.clean.base.extension

import android.widget.TextView
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


private var RoundedCorner: Int = 50.toPixel()

fun TextView.toRial() {
    var prezzo = text.toString()
    tryCatch {
        val symbols = DecimalFormatSymbols()
        symbols.decimalSeparator = ','
        val decimalFormat = DecimalFormat("###,###,###,###", symbols)
        prezzo = decimalFormat.format(text.toString().toInt().toLong()) + " " + " تومان"
    }
}
fun TextView.toRial(price:Int) {
    text = price.toString()
    tryCatch {
        val symbols = DecimalFormatSymbols()
        symbols.decimalSeparator = ','
        val decimalFormat = DecimalFormat("###,###,###,###", symbols)
        val rialText = decimalFormat.format(text.toString().toInt().toLong()) + " " + "تومان"
        text = rialText
    }
}