package com.example.prova1

import java.io.Serializable

open class Fazenda(nome: String, cnpj: String, car : String, caixa: Double) : Serializable {

    val nome : String
    val cnpj : String
    val car : String
    val caixa : Double

    init {
        this.nome = nome
        this.cnpj = cnpj
        this.car = car
        this.caixa = caixa
    }
}