package com.drodriguez.examendanielrodriguez

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.drodriguez.examendanielrodriguez.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentUno: Fragment
    private lateinit var fragmentDos: Fragment
    private lateinit var fragmentTres: Fragment
    private lateinit var fragmentCuatro: Fragment

    //Creamos la lista de regalos
    var lista = ArrayList<Shop>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentUno = FirstFragment()
        fragmentDos = SecondFragment()
        fragmentTres = AddShopping()
        fragmentCuatro = EditShopping()


        supportFragmentManager.beginTransaction().replace(R.id.layoutPrincipal, FirstFragment()).commit()


        }
    fun onClickNuevoAdd(view: View) {
        supportFragmentManager.beginTransaction().replace(R.id.layoutPrincipal, fragmentTres).commit()
    }

    fun onClickInsertar(view: View) {
        //Obtenemos los datos
        var nameData = findViewById<EditText>(R.id.tName).text.toString()
        var giftData = findViewById<EditText>(R.id.tGift).text.toString()
        var moneyData = findViewById<EditText>(R.id.tMoney).text.toString()
        var noteData = findViewById<EditText>(R.id.tNotes).text.toString()
        var shop = Shop(UUID.randomUUID().toString(),nameData, giftData, moneyData, noteData, false)
        lista.add(shop)
        println(lista.toString())
        println(shop.name)

        var fragmentoLista = FirstFragment()

        fragmentoLista.llenarLista(lista)

        if(lista.size ==0){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Opcion no disponible")
                .setMessage("No existen regalos, \n" +
                        "Necesitas crear regalos")
                .setNegativeButton("Volver") { dialog, which -> dialog.dismiss() }
            builder.show()
        }else {
            println("hemos llegado hasta la opcion de crear recicler")

           var s = supportFragmentManager.beginTransaction()
                   s.addToBackStack(null)
               s.replace(R.id.layoutPrincipal, fragmentoLista).commit()


        }
    }

    fun filtroCompletado(view: View) {
        var listaFiltrada = ArrayList<Shop>()
        for (i in lista) {
            if (i.isComplete == true) {
                listaFiltrada.add(i)
            }
        }
        var fragmentoLista = FirstFragment()

        fragmentoLista.llenarLista(listaFiltrada)

        if (listaFiltrada.size == 0) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Opcion no disponible")
                .setMessage(
                    "No existen regalos completados, \n" +
                            "Necesitas crear regalos"
                )
                .setNegativeButton("Volver") { dialog, which -> dialog.dismiss() }
            builder.show()
        } else {
            println("hemos llegado hasta la opcion de crear recicler")

            var s = supportFragmentManager.beginTransaction()
            s.addToBackStack(null)
            s.replace(R.id.layoutPrincipal, fragmentoLista).commit()
        }
    }
    fun filtroSinCompletar(view: View) {
        //Filtramos los regalos por aquellos que solo tienen el checkbox en true

    }
    }



