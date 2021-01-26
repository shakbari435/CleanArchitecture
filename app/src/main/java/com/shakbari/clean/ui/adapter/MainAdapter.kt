package com.shakbari.clean.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shakbari.clean.R
import com.shakbari.clean.base.common.BaseAdapter
import com.shakbari.clean.base.common.view.LoadingView
import com.shakbari.clean.base.extension.inflate
import com.shakbari.clean.base.extension.loadAvatar
import com.shakbari.clean.data.model.User
import kotlinx.android.synthetic.main.item_layout.view.imageViewAvatar
import kotlinx.android.synthetic.main.item_layout.view.textViewUserEmail
import kotlinx.android.synthetic.main.item_layout.view.textViewUserName

class MainAdapter : BaseAdapter() {
    enum class Type { LOADING, NORMAL }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            loading -> Type.LOADING.ordinal
            else -> Type.NORMAL.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Type.LOADING.ordinal -> LoadingView.create(parent)
            else -> DataViewHolder(parent.inflate(R.layout.item_layout))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            Type.NORMAL.ordinal -> (holder as DataViewHolder).bind(getItem(position) as User)
            else -> {}
        }
    }


    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.apply {
                textViewUserName.text = user.name
                textViewUserEmail.text = user.email
                imageViewAvatar.loadAvatar("https://statics.basalam.com/public/users/BkKX/2006/vvUtlPQp3M6JRR0NniFhxqx5PffZT4D4gjohKkaI.jpeg")
            }
        }
    }

}