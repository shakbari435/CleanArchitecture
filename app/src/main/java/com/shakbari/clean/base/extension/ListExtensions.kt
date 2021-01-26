@file:Suppress("NOTHING_TO_INLINE")

package com.shakbari.clean.base.extension

import java.util.*

fun <T> List<T>.swap(i: Int, j: Int): List<T> {
    if (isInBounds(i) && isInBounds(j)){
        Collections.swap(this, i, j)
    }
    return this
}

fun <T> List<T>.isInBounds(index: Int): Boolean {
    return index in 0..lastIndex
}

fun <T> List<T>.startWith(item: T): List<T> {
    val list = this.toMutableList()
    list.add(0, item)
    return list
}

fun <T> List<T>.startWith(data: List<T>): List<T> {
    val list = this.toMutableList()
    list.addAll(0, data)
    return list
}

fun <T> List<T>.startWithIfNotEmpty(item: T): List<T> {
    if (this.isNotEmpty()){
        return startWith(item)
    }
    return this
}

fun <T> List<T>.startWithIfNotEmpty(item: List<T>): List<T> {
    if (this.isNotEmpty()){
        return startWith(item)
    }
    return this
}

fun <T> MutableList<T>.doIf(predicate: Boolean, action: MutableList<T>.() -> Any): MutableList<T> {
    if (predicate){
        this.action()
    }
    return this
}

fun <T> MutableList<T>.removeFirst(predicate: (T) -> Boolean): Boolean {
    for (t in this) {
        if (predicate(t)) {
            this.remove(t)
            return true
        }
    }
    return false
}

