package com.brsu.mendelyev.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brsu.mendelyev.R

class AdapterListInfoElement(val elementList: Array<String>): RecyclerView.Adapter<AdapterListInfoElement.ItemOfList>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemOfList =
        ItemOfList(LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_item_info_element,parent,false))

    override fun getItemCount(): Int = elementList.size

    override fun onBindViewHolder(holder: ItemOfList, position: Int) {
        holder.bind(elementList[position])
    }

    class ItemOfList(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val textpole = itemView.findViewById<TextView>(R.id.item)

        fun bind(text:String)
        {
            textpole.text = text
        }
    }
}