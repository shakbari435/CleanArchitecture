package com.shakbari.clean.base.extension

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager


fun RecyclerView.verticalLinearLayoutManager(context: Context) {
    this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
}

fun RecyclerView.horizontalLinearLayoutManager(context: Context) {
    this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
}

fun RecyclerView.verticalGridLayoutManager(context: Context, rowCount: Int) {
    this.layoutManager = GridLayoutManager(context, rowCount, GridLayoutManager.VERTICAL, false)
}

fun RecyclerView.horizontalGridLayoutManager(context: Context, rowCount: Int) {
    this.layoutManager = GridLayoutManager(context, rowCount, GridLayoutManager.HORIZONTAL, false)
}

fun RecyclerView.verticalStaggeredGridLayoutManager(rowCount: Int) {
    this.layoutManager = StaggeredGridLayoutManager(rowCount, StaggeredGridLayoutManager.VERTICAL)
}

fun RecyclerView.horizontalStaggeredGridLayoutManager(rowCount: Int) {
    this.layoutManager = StaggeredGridLayoutManager(rowCount, StaggeredGridLayoutManager.HORIZONTAL)
}


fun RecyclerView.onLoadMore(body: () -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            if (recyclerView.layoutManager is StaggeredGridLayoutManager) {
                val currentItems = recyclerView.layoutManager!!.childCount
                val totalItems = recyclerView.layoutManager!!.itemCount
                if ((currentItems + caseStaggeredGrid(recyclerView.layoutManager as StaggeredGridLayoutManager)) >= totalItems) {
                    body()
                }
            } else {
                val currentItems = recyclerView.layoutManager!!.childCount
                val totalItems = recyclerView.layoutManager!!.itemCount
                val scrollOutItems = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                val positionInScroll = currentItems + scrollOutItems
                if ((positionInScroll == totalItems)) {
                    body()
                }
            }
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

        }
    })
}

private fun caseStaggeredGrid(layoutManager: StaggeredGridLayoutManager): Int {
    val lastVisibleItemPositions = layoutManager.findLastVisibleItemPositions(null)
    return getLastVisibleItem(lastVisibleItemPositions!!)
}

private fun getLastVisibleItem(lastVisibleItemPositions: IntArray): Int {
    var maxSize = 0
    for (i in lastVisibleItemPositions.indices) {
        if (i == 0) {
            maxSize = lastVisibleItemPositions[i]
        } else if (lastVisibleItemPositions[i] > maxSize) {
            maxSize = lastVisibleItemPositions[i]
        }
    }
    return maxSize
}