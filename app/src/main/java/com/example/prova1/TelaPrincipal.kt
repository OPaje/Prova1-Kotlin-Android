package com.example.prova1

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
                    }
                }
            }

        val opcoes = hashMapOf(
            "Inserir Fazenda" to {register.launch(Intent(applicationContext, TelaInserir::class.java))},
            "Mostrar Fazendas" to {startActivity(Intent(applicationContext, TelaMostrar::class.java).let {
                it.putExtra("111", mostrarFazendasList())
            })},
            "Alterar Fazenda" to {register.launch(Intent(applicationContext, TelaAtualizar::class.java).let {
                it.putStringArrayListExtra("111", arrayListOf<String>(mostrarFazendas()))
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