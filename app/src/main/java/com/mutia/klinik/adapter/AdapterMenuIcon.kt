package com.mutia.klinik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mutia.klinik.R
import com.mutia.klinik.model.ModelIcon

class AdapterMenuIcon
    (private val itemMenuList: List<ModelIcon>) :
    RecyclerView.Adapter<AdapterMenuIcon.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate layout item_destination.xml (pastikan file XML ini ada)
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MyViewHolder(nView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemMenuList[position]
        holder.imgMenuIcon.setImageResource(currentItem.iconImage)
        holder.txtNamaMenu.setText(currentItem.iconName)
    }

    override fun getItemCount(): Int
    {
        return itemMenuList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMenuIcon: ImageView = itemView.findViewById(R.id.imgitemDoctors)
        val txtNamaMenu: TextView = itemView.findViewById(R.id.txtitemNamaDr)

    }
}