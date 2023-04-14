package com.example.prova1

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.prova1.databinding.TelaExcluirBinding

class TelaExcluir : AppCompatActivity() {

    lateinit var binding: TelaExcluirBinding
    lateinit var lista : ArrayList<Fazenda>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaExcluirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lista = intent.getSerializableExtra("111") as ArrayList<Fazenda>
        var cod = 0

        binding.btnBuscarTelaExcluir.setOnClickListener {
            val fazenda = lista.find { it.cnpj == binding.etCnpjExcluir.text.toString() } as Fazenda
            if (fazenda != null) {
                cod = lista.indexOfFirst { it.cnpj == fazenda.cnpj }
            }

            binding.etExcluir.setText(fazenda.toString())
        }

        binding.btnExluir.setOnClickListener {
            Intent().apply {
                putExtra("444", lista[cod] as java.io.Serializable)
                setResult(RESULT_OK, this)
            }

            Toast.makeText(applicationContext, "Removido com Sucesso", Toast.LENGTH_SHORT).show()
        }

        binding.btnExluir.setOnClickListener {
            finish()
        }
    }
}