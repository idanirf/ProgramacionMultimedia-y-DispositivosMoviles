package com.drodriguez.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(
    private val noteList: MutableList<Notes>,
    private val listener: ((Notes) -> Unit)
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_nota, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = noteList.get(position)
        holder.bind(item)
    }

    fun addNote(note: Notes) {
        noteList.add(note)
        notifyDataSetChanged()
    }

    fun deleteNote(note: Notes) {
        noteList.remove(note)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewNotaBinding.bind(view)

        fun bind(notes: Notes) {
            binding.tvDescription.text = notes.description
            binding.isChecked = notes.checked
        }
    }
}