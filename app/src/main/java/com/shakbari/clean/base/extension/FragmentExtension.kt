@file:Suppress("NOTHING_TO_INLINE")

package com.shakbari.clean.base.extension

import android.content.Context
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

inline fun <T : Fragment> T.withArguments(vararg params: Pair<String, Any>): T {
    arguments = bundleOf(*params)
    return this
}

inline val Fragment.ctx: Context
    get() = requireActivity()

inline val Fragment.act: FragmentActivity
    get() = requireActivity()

@Suppress("UNCHECKED_CAST")
inline fun <T> Fragment.getArgument(key: String): T {
    return arguments!!.get(key) as T
}

inline fun FragmentActivity.fragmentTransaction(crossinline func: FragmentTransaction.() -> FragmentTransaction) {
    supportFragmentManager
            .beginTransaction()
            .func()
            .commit()
}

fun FragmentManager.getTopFragment(): Fragment? {
    val topFragment = this.backStackEntryCount - 1
    if (topFragment > -1) {
        val tag = this.getBackStackEntryAt(topFragment).name
        return this.findFragmentByTag(tag)
    }
    return null
}
