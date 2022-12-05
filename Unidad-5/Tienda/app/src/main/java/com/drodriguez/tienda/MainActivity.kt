package com.drodriguez.tienda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.drodriguez.tienda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TiendaOnClickListener {
    private lateinit var binding = ActivityMainBinding
    private lateinit var mAdapter: TiendaAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mAdapter = TiendaAdapter(this)
        mGridLayout = GridLayoutManager(this, 2)

    }

    override fun onClick(tienda: Tienda) {

    }
}