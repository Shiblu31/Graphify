package com.example.mydamo


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DemoAdapter( private val damoList:List<Damo>) : RecyclerView.Adapter<DemoAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.damo_item, parent, false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val damo = damoList[position]
        holder.subject.text = damo.item

    }

    override fun getItemCount(): Int {
        return damoList.size

    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subject = itemView.findViewById<TextView>(R.id.tvSub)
    }
}