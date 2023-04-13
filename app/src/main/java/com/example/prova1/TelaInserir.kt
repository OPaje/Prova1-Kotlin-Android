package com.example.prova1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
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

        binding.btnInserir.setOnClickListener {
            val fazenda = criaFazenda(binding.spOpcoesFazenda.selectedItem.toString())

            val result = Intent()
            result.putExtra("555", fazenda)
            setResult(Activity.RESULT_OK, result)

            binding.etNome.text.clear()
            binding.etCnpj.text.clear()
            binding.etCar.text.clear()
            binding.etCaixa.text.clear()
            binding.etValor5.text.clear()

            Toast.makeText(applicationContext, "Fazenda cadastrada com sucesso", Toast.LENGTH_SHORT).show()
        }

        binding.btnHomeTelaInserir.setOnClickListener {
            finish()
        }
    }

    private fun mudaHint(movel: String){
        if(movel == "Porcos"){
            binding.etValor5.hint = "Bacon Estocado"

        }
        if(movel == "Vacas leiteiras"){
            binding.etValor5.hint = "Produção Diária"


        }
        if(movel == "Lavoura de soja"){
            binding.etValor5.setText("Com Silo")
        }
    }

    fun criaFazenda(tipo:String) : Fazenda{
        var fazenda = Fazenda(binding.etNome.text.toString(), binding.etCnpj.text.toString(), binding.etCar.text.toString(), binding.etCaixa.text.toString().toDouble())
        if(tipo == "Porcos"){
            fazenda = Porcos(binding.etValor5.text.toString().toDouble(), binding.etNome.text.toString(), binding.etCnpj.text.toString(), binding.etCar.text.toString(),
                binding.etCaixa.text.toString().toDouble())
            return fazenda
        }else if(tipo == "Vacas leiteiras"){
            fazenda = VacasLeiteiras(binding.etValor5.text.toString().toDouble(), binding.etNome.text.toString(), binding.etCnpj.text.toString(), binding.etCar.text.toString(),
                binding.etCaixa.text.toString().toDouble())
            return fazenda
        }else if(tipo == "Estante"){
            fazenda = LavouraDeSoja(true, binding.etNome.text.toString(), binding.etCnpj.text.toString(), binding.etCar.text.toString(),
                binding.etCaixa.text.toString().toDouble())
            return fazenda
        }
        return fazenda
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        val valorSelecionado = parent.getItemAtPosition(position).toString()

        mudaHint(valorSelecionado)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}