package com.andrewmeli.libraries.uicomponents

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andrewmeli.libraries.model.IComparer


abstract class BaseListAdapter<T, V> :
    ListAdapter<T, V>(AssetComparator<T>()) where V : RecyclerView.ViewHolder, T : IComparer {

    protected var list = listOf<T>()

    protected var onViewClickListeners: (viewId: Int, data: Any?) -> Unit = { _, _ -> }

    fun <D> setOnViewClickListener(callback: (viewId: Int, data: D) -> Unit) {
        onViewClickListeners = { viewId, any ->
            callback(viewId, any as D)
        }
    }


    fun setData(list: List<T>?) {
        this.list = list ?: listOf()
        submitList(list)
    }


    class AssetComparator<T> : DiffUtil.ItemCallback<T>() where T : IComparer {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
            oldItem.areItemsTheSame(newItem)

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
            oldItem.areContentsTheSame(newItem)
    }
}