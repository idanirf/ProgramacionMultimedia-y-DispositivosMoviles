package com.drodriguez.examendanielrodriguez

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private var dataList: List<Shop>,
): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.reName)
        var gift: TextView = view.findViewById(R.id.reGift)
        var money: TextView = view.findViewById(R.id.reMoney)
        var note: TextView = view.findViewById(R.id.reNotes)
        var isComplete: CheckBox = view.findViewById(R.id.reComplete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.name.setText("${item.name.toString()}")
        holder.gift.setText("${item.gift.toString()}")
        holder.money.setText("${item.money.toString()}")
        holder.note.setText("${item.note.toString()}")
        holder.isComplete.isChecked = item.isComplete
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(list:List<Shop>){
        this.dataList = list
    }
}