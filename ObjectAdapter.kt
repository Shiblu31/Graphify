package com.example.mydamo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ObjectAdapter ( private val damoObjectList:List<Damo2>) : RecyclerView.Adapter<ObjectAdapter.MyobjectHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyobjectHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.object_item, parent, false)
        return MyobjectHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyobjectHolder, position: Int) {
        val damo = damoObjectList[position]
        holder.objecttv.text = damo.item

    }

    override fun getItemCount(): Int {
        return damoObjectList.size

    }

    inner class MyobjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val objecttv = itemView.findViewById<TextView>(R.id.tvObj)
    }
}