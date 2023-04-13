package com.example.prova1

open class Fazenda(nome: String, cnpj: String, car : String, caixa: Double) {

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