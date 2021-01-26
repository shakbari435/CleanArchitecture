package com.shakbari.clean.base.common

import androidx.recyclerview.widget.RecyclerView
import com.shakbari.clean.base.extension.tryCatch

abstract class BaseAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list:ArrayList<Any> = ArrayList()
    var isLoading:Boolean = false
    val loading = -1

    override fun getItemCount(): Int = list.size

    fun getItems() = list

    fun getItem(position: Int) = list[position]

    fun addItems(list: ArrayList<Any>){
        hideLoading()
        this.list.apply {
            clear()
            addAll(list)
            notifyDataSetChanged()
        }
    }

    fun addItemsRangeChange(list: ArrayList<Any>){
        hideLoading()
        this.list.apply {
            addAll(list)
            notifyItemRangeChanged(itemCount, list.size)
        }
    }


    fun addItem(item: Any){
        list.let {
            it.add(item)
            notifyItemRangeChanged(itemCount, it.size)
        }
    }

    fun addItem(item: Any,position: Int){
        list.let {
            it.add(position,item)
            notifyItemInserted(position)
        }
    }

    fun removeItem(position: Int){
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    fun removeItem(item: Any, position: Int){
        list.remove(item)
        notifyItemRemoved(position)
    }

    fun showLoading() {
        tryCatch {
            if(!isLoading) {
                list.add(loading)
                notifyItemInserted(list.size - 1)
                isLoading = true
            }
        }
    }

    fun hideLoading() {
        tryCatch {
            if(list[list.size - 1] == loading) {
                list.removeAt(list.size - 1)
                notifyItemRemoved(list.size)
                isLoading =  false
            }
        }
    }


}