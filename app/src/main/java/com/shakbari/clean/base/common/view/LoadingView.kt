package com.shakbari.clean.base.common.view

import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView

class LoadingView(view: View) : RecyclerView.ViewHolder(view) {
    companion object {
        fun create(parent: ViewGroup): LoadingView {
            val params: RelativeLayout.LayoutParams =
                    RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT
                            , RelativeLayout.LayoutParams.MATCH_PARENT)
            val layout = RelativeLayout(parent.context)
            val progressBar = ProgressBar(parent.context)
            params.addRule(RelativeLayout.CENTER_IN_PARENT)
            layout.addView(progressBar, params)
            return LoadingView(layout)
        }
    }
}