package com.example.prova1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prova1.databinding.TelaPrincipalBinding

class TelaPrincipal : AppCompatActivity() {

    lateinit var binding : TelaPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}