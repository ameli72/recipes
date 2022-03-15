package com.andrewmeli.libraries.uicomponents

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andrewmeli.libraries.model.IComparer


abstract class BaseListAdapter<T, V> :
    ListAdapter<T, V>(AssetComparator<T>()) where V : RecyclerView.ViewHolder, T : IComparer {

    protected var list = listOf<T>()

    protected var onViewClickListeners: (data: Any, view: View) -> Unit = { _, _ -> }

    @Suppress("UNCHECKED_CAST")
    fun <D> setOnViewClickListener(callback: (data: D, view: View) -> Unit) {
        onViewClickListeners = { data, view ->
            callback(data as D, view)
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