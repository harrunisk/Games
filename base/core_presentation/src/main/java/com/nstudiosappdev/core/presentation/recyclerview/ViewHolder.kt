package com.nstudiosappdev.core.presentation.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nstudiosappdev.core.presentation.entity.ViewEntity

abstract class ViewHolder<T : ViewEntity>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}