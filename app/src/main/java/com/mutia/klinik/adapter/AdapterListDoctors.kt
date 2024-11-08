package com.mutia.klinik.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mutia.klinik.Detail_Doctor
import com.mutia.klinik.R
import com.mutia.klinik.model.ModelListDoctors

class AdapterListDoctors(
    val itemListDoctors: List<ModelListDoctors>
): RecyclerView.Adapter<AdapterListDoctors.MyviewHolder>() {
    class MyviewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var txtNamaDoktor : TextView = itemView.findViewById(R.id.txtitemNamaDr)
        var imgDoctor : ImageView = itemView.findViewById(R.id.imgitemDoctors)
        var txtBidang : TextView = itemView.findViewById(R.id.textitemBidangDr)
        var txtTotalRating : TextView = itemView.findViewById(R.id.tvRating)
        var txtTotalReview : TextView = itemView.findViewById(R.id.tvAngka)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor,parent,false)
        return MyviewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemListDoctors.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentItem = itemListDoctors[position]
        holder.txtNamaDoktor.setText(currentItem.namaDr)
        holder.imgDoctor.setImageResource(currentItem.imageDr)
        holder.txtBidang.setText(currentItem.bidangDr)
        holder.txtTotalRating.setText(currentItem.totalReview)
        holder.txtTotalReview.setText(currentItem.angkaReview)
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, Detail_Doctor::class.java).apply {
                // Mengirim data melalui intent
                putExtra("namaDokter", currentItem.namaDr)
                putExtra("photoDokter", currentItem.imageDr)
                putExtra("bidangDr", currentItem.bidangDr)
                putExtra("totalReview", currentItem.totalReview)
                putExtra("angkaReview", currentItem.angkaReview)

            }
            context.startActivity(intent)
        }

    }
}