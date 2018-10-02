package com.tuanhv.mvvmarch.base.ui.common

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by hoang.van.tuan on 8/20/18.
 */

abstract class DataBoundAdapter<T, V : ViewDataBinding> : RecyclerView.Adapter<DataBoundViewHolder<V>>() {

    protected var items: MutableList<T> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<V> {
        val binding = createBinding(parent)
        return DataBoundViewHolder(binding)
    }

    protected abstract fun createBinding(parent: ViewGroup): V

    override fun onBindViewHolder(holder: DataBoundViewHolder<V>, position: Int) {
        bind(holder.binding, items[position])
        holder.binding.executePendingBindings()
    }

    protected abstract fun bind(binding: V, item: T)

    override fun getItemCount(): Int {
        return items.size
    }
}
