package com.ayrtonnhaguaga.meusgastos.model

enum class ExpenseCategory {

    ALIMENTACAO,
    MORADIA,
    TRANSPORTE,
    SAUDE,


    LAZER,
    EDUCACAO,
    VIAGENS,
    ROUPAS,


    INVESTIMENTOS,
    SERVICOS,
    PRESENTES,


    OUTROS;

    companion object {
        fun fromString(value: String): ExpenseCategory {
            return try {
                valueOf(value.uppercase())
            } catch (e: IllegalArgumentException) {
                OUTROS
            }
        }
    }
}