package com.example.prova1

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.prova1.databinding.TelaAtualizarBinding
import com.example.prova1.databinding.TelaMostrarBinding

class TelaAtualizar : AppCompatActivity() {

    lateinit var binding: TelaAtualizarBinding
    lateinit var lista : ArrayList<Fazenda>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaAtualizarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lista = intent.getSerializableExtra("111") as ArrayList<Fazenda>
        var cod = 0

        binding.btnBuscarAtualiza.setOnClickListener {
            val fazenda = lista.find { it.cnpj == binding.etCnpjAtualiza.text.toString() } as Fazenda
            if (fazenda != null) {
                cod = lista.indexOfFirst { it.cnpj == fazenda.cnpj }
            }
        }

        binding.btnAtualizar.setOnClickListener {
            lista[cod].nome = binding.etNomeAtualiza.text.toString()
            lista[cod].caixa = binding.etCaixaAtualiza.text.toString().toDouble()

            Intent().apply {
                putExtra("444", lista[cod] as java.io.Serializable)
                setResult(RESULT_OK, this)
            }

            Toast.makeText(applicationContext, "Fazenda Atualizada com Sucesso", Toast.LENGTH_SHORT).show()

        }

        binding.btnHomeAtualiza.setOnClickListener {
            finish()
        }

    }
}