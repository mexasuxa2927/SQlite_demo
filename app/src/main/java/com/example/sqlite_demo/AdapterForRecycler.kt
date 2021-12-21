package com.example.sqlite_demo

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custol_select_dialog.view.*
import kotlinx.android.synthetic.main.custom_rec_item.view.*

class AdapterForRecycler(val item :List<UserData>,val context:Context) : RecyclerView.Adapter<AdapterForRecycler.MyViewHolder>() {


    inner class  MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.custom_rec_item,parent,false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemms =  item[position]
        holder.itemView.NameText_rec.text = item[position].Name
        holder.itemView.AgeText_rec.text = item[position].Age
        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val mDialog =  LayoutInflater.from(context).inflate(R.layout.custol_select_dialog,null)
                val mBuilder = AlertDialog.Builder(context).setView(mDialog).setTitle("Edit text")
                val AlertDialog  = mBuilder.show()
                mDialog.DeleteButton_dialog.setOnClickListener(object :View.OnClickListener{
                    override fun onClick(v: View?) {
                        val db = AdapterDB(context)
                        db.deleteUser(itemms.Id.toString())
                        AlertDialog.cancel()

                    }
                })

            }
        })
    }

    override fun getItemCount(): Int {
        return item.count()

    }

}