package com.drodriguez.reciclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AlumnosAdapter(private val mContacts: List<Alumnos>) : RecyclerView.Adapter<AlumnosAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.contact_name)
        val messageButton = itemView.findViewById<Button>(R.id.message_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnosAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_contact, parent, false)
        return ViewHolder(contactView)
    }


    override fun onBindViewHolder(viewHolder: AlumnosAdapter.ViewHolder, position: Int) {
        val contact: Alumnos = mContacts.get(position)
        val textView = viewHolder.nameTextView
        textView.text = contact.name
        val button = viewHolder.messageButton
        button.text = ("Datos Alumno/a")
        button.isEnabled = contact.isOnline
    }


    override fun getItemCount(): Int {
        return mContacts.size
    }
}