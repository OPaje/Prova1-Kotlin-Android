package com.example.prova1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.prova1.databinding.TelaInserirBinding

class TelaInserir : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding : TelaInserirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaInserirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val opcoesSpinner = resources.getStringArray(R.array.opcoes_fazenda)
        val adaptador = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, opcoesSpinner)
        binding.spOpcoesFazenda.adapter = adaptador

        binding.spOpcoesFazenda.onItemSelectedListener = this

    }

    private fun mudaHint(movel: String){
        if(movel == "Porcos"){
            binding.etValor5.hint = "Bacon Estocado"

        }
        if(movel == "Cama"){
            binding.etValor5.hint = "Produção Diária"


        }
        if(movel == "Estante"){
            binding.etValor5.hint = "Presença de Silo"
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val valorSelecionado = parent.getItemAtPosition(position).toString()

        mudaHint(valorSelecionado)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}