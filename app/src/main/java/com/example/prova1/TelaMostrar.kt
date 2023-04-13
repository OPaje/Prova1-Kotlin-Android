package com.example.prova1

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.prova1.databinding.TelaMostrarBinding

class TelaMostrar : AppCompatActivity() {

    lateinit var binding : TelaMostrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TelaMostrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra("111")){
            val lista = intent.getStringArrayListExtra("111")
            if(lista != null){
                val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, lista)
                binding.lvTelaMostrar.adapter = adapter
            }
        }

        binding.btnHomeTelaMostrar.setOnClickListener {
            finish()
        }

    }
}