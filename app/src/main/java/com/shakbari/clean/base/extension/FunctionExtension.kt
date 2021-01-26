@file:Suppress("NOTHING_TO_INLINE")

package com.shakbari.clean.base.extension


fun tryCatch(body: () -> Unit): Boolean {
    return try {
        body()
        true
    } catch (e: Throwable) {
        body.logE(e.message)
        false
    }
}