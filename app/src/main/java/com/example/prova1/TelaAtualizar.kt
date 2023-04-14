package com.example.prova1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prova1.databinding.TelaAtualizarBinding
import com.example.prova1.databinding.TelaMostrarBinding

class TelaAtualizar : AppCompatActivity() {

    lateinit var binding: TelaAtualizarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaAtualizarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lista = intent.getSerializableExtra("111") as ArrayList<Fazenda>

        binding.btnBuscarAtualizar.setOnClickListener {

        }

    }
}