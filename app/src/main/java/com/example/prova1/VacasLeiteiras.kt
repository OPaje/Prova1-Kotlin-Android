package com.example.prova1

class VacasLeiteiras(producaoDiaria: Double, nome: String, cnpj : String, car: String, caixa: Double) : Fazenda(nome, cnpj, car, caixa) {

    val producaoDiaria : Double

    init{
        this.producaoDiaria = producaoDiaria
    }

    override fun toString(): String {
        return "Nome = $nome Cnpj = $cnpj Car = $car Caixa = $caixa producao Diaria = $producaoDiaria"
    }


}