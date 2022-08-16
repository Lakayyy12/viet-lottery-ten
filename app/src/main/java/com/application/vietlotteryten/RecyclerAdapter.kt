package com.application.vietlotteryten

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    val onItemClicked: OnContentClickListener
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    //Title and Description
    private var titles = arrayOf("Trò chơi xổ số", "Trò chơi xổ số các chữ số", "Trò chơi rút thăm nhanh")
    private var details = arrayOf("HƯỚNG DẪN 1", "HƯỚNG DẪN 2", "HƯỚNG DẪN 3")

    private var contents = intArrayOf(R.string.mt11, R.string.mt22, R.string.mt33)

    //Images
    private var images = intArrayOf(R.drawable.lottto,R.drawable.lottto,R.drawable.lottto)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return  titles.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])

        holder.itemView.setOnClickListener{
            onItemClicked.OnContentItemClicked(images[position], contents[position])
        }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.item_image)
        var itemTitle: TextView = itemView.findViewById(R.id.item_title)
        var itemDetail: TextView = itemView.findViewById(R.id.item_detail)
    }
}