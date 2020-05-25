package com.nicco.architectures.android.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nicco.architectures.android.R
import com.nicco.architectures.android.ViewUtil.getDrawableByName
import kotlinx.android.synthetic.main.item_list.view.*

object DiffUtilArch : DiffUtil.ItemCallback<ListArchModelUi>() {
    override fun areItemsTheSame(
        oldItem: ListArchModelUi,
        newItem: ListArchModelUi
    ): Boolean = oldItem.title == newItem.title

    override fun areContentsTheSame(
        oldItem: ListArchModelUi,
        newItem: ListArchModelUi
    ): Boolean = oldItem == newItem
}

interface Interaction {
    fun onClickArchItem(item: ListArchModelUi, imgView: ImageView)
}

class ListArchAdapter(interaction: Interaction) :
    ListAdapter<ListArchModelUi, ListArchAdapter.ViewHolder>(
        DiffUtilArch
    ) {
    private var interaction: Interaction? = interaction

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false), interaction
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private lateinit var imgTop: AppCompatImageView

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (adapterPosition == RecyclerView.NO_POSITION) return

            val clicked = getItem(adapterPosition)
            interaction?.onClickArchItem(clicked, imgTop)
        }

        fun bind(item: ListArchModelUi) = with(itemView) {
            imgTop = imgHeader
            imgTop.setImageDrawable(getDrawableByName(context, item.imgHeader))

            titleType.text = item.title

            title.text = item.title
            subtitle.text = item.subtitle
        }
    }
}