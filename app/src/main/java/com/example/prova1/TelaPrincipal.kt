package com.example.prova1

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.example.prova1.databinding.TelaPrincipalBinding

class TelaPrincipal : AppCompatActivity() {

    lateinit var binding: TelaPrincipalBinding
    val listaFazenda = mutableListOf<Fazenda>()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val opcoesExec = resources.getStringArray(R.array.opcoes_exec)
        val adaptador =
            ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, opcoesExec)
        binding.lvOpcoesExerc.adapter = adaptador

        val register =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    result.data?.let {
                        if (it.hasExtra("555")) {
                            val fazenda = it.getSerializableExtra("555", Fazenda::class.java)
                            if (fazenda != null) {
                                listaFazenda.add(fazenda)
                            }
                        }
                        if (it.hasExtra("444")) {
                            val fazenda : Fazenda? = it.getSerializableExtra("444", Fazenda::class.java)
                            if (fazenda != null) {
                                val indice = listaFazenda.indexOfFirst { fazenda.cnpj == it.cnpj }
                                listaFazenda[indice] = fazenda
                            }
                        }
                        if (it.hasExtra("888")) {
                            val fazenda : Fazenda? = it.getSerializableExtra("888", Fazenda::class.java)
                            if (fazenda != null) {
                                val indice = listaFazenda.indexOfFirst {  fazenda.cnpj == it.cnpj }
                                listaFazenda.removeAt(indice)
                            }
                        }
                    }
                }
            }

        val opcoes = hashMapOf(
            "Inserir Fazenda" to {register.launch(Intent(applicationContext, TelaInserir::class.java))},
            "Mostrar Fazendas" to {startActivity(Intent(applicationContext, TelaMostrar::class.java).let {
                it.putExtra("111", mostrarFazendasList())
            })},

            "Alterar Fazenda" to {register.launch(Intent(applicationContext, TelaAtualizar::class.java).let {
                it.putExtra("111", mostrarFazendasList())
            })},

            "Valor total em caixa" to {
                val totalCaixa = listaFazenda.sumOf { it.caixa }
                Toast.makeText(applicationContext, "Total Caixa: $totalCaixa", Toast.LENGTH_LONG).show()
            },

            "Remover Fazenda" to {register.launch(Intent(applicationContext, TelaExcluir::class.java).let {
                it.putExtra("111", mostrarFazendasList())
            })}

        )

        binding.lvOpcoesExerc.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val textoSelecionado = parent.getItemAtPosition(position)
            opcoes[textoSelecionado]?.invoke()
        }
    }

    fun mostrarFazendasList() : ArrayList<Fazenda>{
        return listaFazenda as ArrayList<Fazenda>
    }
    fun mostrarFazendas() : String{
        return listaFazenda.toString()
    }
}