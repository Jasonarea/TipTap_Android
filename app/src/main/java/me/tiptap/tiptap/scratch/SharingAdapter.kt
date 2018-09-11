package me.tiptap.tiptap.scratch


import android.databinding.ObservableField
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.tiptap.tiptap.R
import me.tiptap.tiptap.data.Sharing

class SharingAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataSet: MutableList<Sharing> = mutableListOf()

    var isCheckboxAvailable: ObservableField<Boolean> = ObservableField(false)

    private val ITEM = 1


    fun addItem(item: Sharing) = dataSet.add(item)

    fun addItems(items: MutableList<Sharing>) {
        dataSet.addAll(items)
        notifyDataSetChanged()
    }

    //test
    override fun getItemViewType(position: Int): Int =
            ITEM

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            SharingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_sharing, parent, false))



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        if (holder is SharingViewHolder) {
            holder.apply {
                binding?.sharing = item
                binding?.adapter = this@SharingAdapter
            }
        }
    }

    override fun getItemCount(): Int = dataSet.size
    //get item by position
    private fun getItem(position: Int) = dataSet[position]


}