package com.shakbari.clean.base.common.view

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class EmptyView(view: View) : RecyclerView.ViewHolder(view) {
    companion object {
        fun create(parent: ViewGroup): EmptyView {
            return EmptyView(LinearLayout(parent.context))
        }
    }
}