package com.shakbari.clean.base.extension

import android.content.res.Resources
import android.graphics.Color
import android.util.TypedValue
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.security.MessageDigest
import java.text.DecimalFormat
import java.util.regex.Pattern

var ZERO = 0
var SPACE = " "

fun Int.toPixel(): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()
}

fun Float.toPixel(): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics).toInt()
}

fun Float.roundOff(): String {
    val df = DecimalFormat("##.##")
    return df.format(this)
}

val String.toMd5: String
    get() {
        val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
        return bytes.joinToString("") {
            "%02x".format(it)
        }
    }

val String.toSha1: String
    get() {
        val bytes = MessageDigest.getInstance("SHA-1").digest(this.toByteArray())
        return bytes.joinToString("") {
            "%02x".format(it)
        }
    }

fun String.isEmailValid(): Boolean {
   val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
   val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
   val matcher = pattern.matcher(this)
   return matcher.matches()
}

val String.toJsonObject: JSONObject?
   get() = try {
      JSONObject(this)
   } catch (e: JSONException) {
      null
   }

val String.toJsonArray: JSONArray?
   get() = try {
      JSONArray(this)
   } catch (e: JSONException) {
      null
   }

val String.toHexColor: Int?
   get() = try {
      Color.parseColor(this)
   } catch (e: java.lang.IllegalArgumentException) {
      null
   }