package com.example.prova1

class LavouraDeSoja(presencaSilo : Boolean, nome: String, cnpj : String, car: String, caixa: Double) : Fazenda(nome, cnpj, car, caixa) {

    val presencaSilo : Boolean

    init {
        this.presencaSilo = presencaSilo
    }

    override fun toString(): String {
        return "Nome = $nome Cnpj = $cnpj Car = $car Caixa = $caixa presenca Silo = $presencaSilo"
    }


}