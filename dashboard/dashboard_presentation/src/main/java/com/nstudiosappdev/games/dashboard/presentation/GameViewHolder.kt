package com.nstudiosappdev.games.dashboard.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nstudiosappdev.core.presentation.extensions.loadImage
import com.nstudiosappdev.core.presentation.recyclerview.DisplayItem
import com.nstudiosappdev.core.presentation.recyclerview.ViewHolder
import com.nstudiosappdev.core.presentation.recyclerview.ViewHolderBinder
import com.nstudiosappdev.core.presentation.recyclerview.ViewHolderFactory
import kotlinx.android.synthetic.main.item_game.view.*
import javax.inject.Inject

class GameViewHolder private constructor(itemView: View) : ViewHolder<GameViewEntity>(itemView) {

    override fun bind(item: GameViewEntity) {
        itemView.textViewName.text = item.name
        item.backgroundImage?.let {
            itemView.imageViewBackground.loadImage(it)
        }

        itemView.setOnClickListener {
            itemClickListener?.invoke(itemView, item)
        }

    }

    internal class GameViewHolderFactory @Inject constructor() : ViewHolderFactory {

        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            GameViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_game,
                    parent,
                    false
                )
            )
    }

    internal class GameViewHolderBinder @Inject constructor() : ViewHolderBinder {

        override fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem) {
            (holder as GameViewHolder).bind(item as GameViewEntity)
        }
    }
}