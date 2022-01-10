package com.carlostena.examenpmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.carlostena.examenpmdm.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var lista = listOf("Amarillo", "Verde", "Rojo")
    var listaOrdenada = listOf<String>()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bAlfa.setOnClickListener {
            listaOrdenada = lista.sorted()
            println("Orden Alfa = $listaOrdenada")
        }

        binding.bLong.setOnClickListener {
            listaOrdenada = lista.sortedBy {
                it.length
            }
            println("Orden Long = $listaOrdenada")
        }

        binding.bAleatorio.setOnClickListener {
            listaOrdenada = lista.shuffled()
        }

        binding.bIniciar.setOnClickListener {
            if (listaOrdenada.isEmpty()) {
                Toast.makeText(this,"Elije un orden", Toast.LENGTH_LONG).show()
            } else {
                binding.bAlfa.visibility = View.INVISIBLE
                binding.bLong.visibility = View.INVISIBLE
                binding.bAleatorio.visibility = View.INVISIBLE
                binding.bDescubirLetra.visibility = View.VISIBLE
                binding.tvAsteriscos.visibility = View.VISIBLE
                binding.tvAsteriscos.text = obtenerAsteriscos(listaOrdenada[0])
            }
        }

        binding.bDescubirLetra.setOnClickListener {
            binding.tvAsteriscos.text = obtenerAsteriscos(listaOrdenada[0], 4)
            // TODO: Saber que palabra estamos mostrando.
            // TODO: Saber que letra estamos mostrando.
        }

    }

    private fun obtenerAsteriscos(texto: String, comienzo : Int = 0) : String {
        var out = ""
        texto.forEachIndexed { index, c ->
            if (index < comienzo)
                out+=c
            else
                out+="*"
        }
        return out
    }
}