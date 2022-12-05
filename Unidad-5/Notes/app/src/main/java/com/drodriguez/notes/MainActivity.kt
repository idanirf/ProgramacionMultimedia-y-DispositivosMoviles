package com.drodriguez.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var noteAdapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater){
            setContentView(binding.root)
            val data = mutableListOf(Notes(1, "Hola Primera Nota", false))

            noteAdapter = NoteAdapter(data, {note: Notes ->

            }
        }


}
