package com.example.sqlite_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_rec_item.view.*

class AdapterForRecycler(val item :List<UserData>) : RecyclerView.Adapter<AdapterForRecycler.MyViewHolder>() {


    inner class  MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.custom_rec_item,parent,false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.NameText_rec.text = item[position].Name
        holder.itemView.AgeText_rec.text = item[position].Age
    }

    override fun getItemCount(): Int {
        return item.count()

    }
}