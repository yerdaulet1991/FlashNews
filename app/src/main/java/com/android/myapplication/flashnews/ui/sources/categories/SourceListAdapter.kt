package com.android.myapplication.flashnews.ui.sources.categories

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.android.myapplication.flashnews.R
import com.android.myapplication.flashnews.models.Source
import kotlinx.android.synthetic.main.layout_sources_list_item.view.*

class SourceListAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Source>() {

        override fun areItemsTheSame(oldItem: Source, newItem: Source)= oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: Source, newItem: Source)= oldItem == newItem


    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SourceViewHodel(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_sources_list_item,
                parent,
                false
            ),
            interaction
        )


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SourceViewHodel -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount()= differ.currentList.size


    fun submitList(list: List<Source>) = differ.submitList(list)


    class SourceViewHodel
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Source) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }

            tv_source_name.text = item.name
            tv_source_description.text = item.description
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Source)
    }
}