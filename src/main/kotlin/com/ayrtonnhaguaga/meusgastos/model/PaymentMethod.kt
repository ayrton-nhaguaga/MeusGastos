package com.ayrtonnhaguaga.meusgastos.model


enum class PaymentMethod {
    DINHEIRO,
    CARTAO_CREDITO,
    CARTAO_DEBITO,
    M_PESA,
    TRANSFERENCIA,
    E_MOLA;

    companion object {
        fun fromString(value: String): PaymentMethod {
            return try {
                valueOf(value.uppercase())
            } catch (e: IllegalArgumentException) {
                DINHEIRO
            }
        }
    }
}