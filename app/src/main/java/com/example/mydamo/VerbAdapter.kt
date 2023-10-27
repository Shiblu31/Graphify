package com.example.mydamo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VerbAdapter( private val damoVerbList:List<Damo1>) : RecyclerView.Adapter<VerbAdapter.MyverHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyverHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.verb_item, parent, false)
        return MyverHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyverHolder, position: Int) {
        val damo = damoVerbList[position]
        holder.verb.text = damo.item

    }

    override fun getItemCount(): Int {
        return damoVerbList.size

    }

    inner class MyverHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val verb = itemView.findViewById<TextView>(R.id.tvVerb)
    }
}