package com.drodriguez.tienda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drodriguez.tienda.databinding.ItemTiendaBinding

class TiendaAdapter(private var stores: MutableList<Tienda>, private var listener: TiendaOnClickListener) :
    RecyclerView.Adapter<TiendaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_tienda, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return stores.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = stores.get(position)
        holder.bind(store)
        holder.setListener(store)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemTiendaBinding.bind(view)
        fun setListener(store: Tienda) {
            binding.root.setOnClickListener { (listener.onClick(store)) }
        }

        fun bindView(store: Tienda) {
            binding.textName = store.name
        }
    }


}