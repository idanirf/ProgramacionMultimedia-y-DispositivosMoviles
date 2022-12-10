package com.drodriguez.examendanielrodriguez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.drodriguez.examendanielrodriguez.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    var lista = ArrayList<Shop>()

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val recycler: RecyclerView
        val vista = inflater.inflate(R.layout.fragment_first, container, false)
        recycler = vista.findViewById(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(context)

        recycler.adapter = Adapter(lista)
        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        }
    fun llenarLista(list: ArrayList<Shop>){
        lista = list
    }
}


