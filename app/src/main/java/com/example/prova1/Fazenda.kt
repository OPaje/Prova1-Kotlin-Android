package com.example.prova1

import java.io.Serializable

open class Fazenda(nome: String, cnpj: String, car : String, caixa: Double) : Serializable {

    var nome : String
    val cnpj : String
    val car : String
    var caixa : Double

    init {
        this.nome = nome
        this.cnpj = cnpj
        this.car = car
        this.caixa = caixa
    }

    override fun toString(): String {
        return "Nome = $nome Cnpj = $cnpj Car = $car Caixa = $caixa"
    }


}