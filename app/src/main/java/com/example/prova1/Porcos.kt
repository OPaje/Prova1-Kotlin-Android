package com.example.prova1

class Porcos(kgBaconEstoque : Double, nome: String, cnpj : String, car: String, caixa: Double) : Fazenda(nome, cnpj, car, caixa){

    val kgBaconEstoque : Double

    init {
        this.kgBaconEstoque = kgBaconEstoque
    }

    override fun toString(): String {
        return "kg Bacon Estoque = $kgBaconEstoque"
    }


}