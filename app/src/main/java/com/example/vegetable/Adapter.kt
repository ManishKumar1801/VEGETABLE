package com.example.vegetable

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class Adapter(private val vegList:ArrayList<VEG>,private val context: Context):
    RecyclerView.Adapter<Adapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem=vegList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.vegHeading.text=currentItem.heading
        holder.cost.text=currentItem.cost


    }

    override fun getItemCount(): Int {
       return vegList.size
    }
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val titleImage: ImageView =itemView.findViewById(R.id.title_image)
        val vegHeading: TextView=itemView.findViewById(R.id.vegHeading)
        val cost:TextView=itemView.findViewById(R.id.cost)
    }

}