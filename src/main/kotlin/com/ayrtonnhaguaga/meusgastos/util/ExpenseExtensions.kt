package com.ayrtonnhaguaga.meusgastos.util

import com.ayrtonnhaguaga.meusgastos.dto.request.ExpenseRequest
import com.ayrtonnhaguaga.meusgastos.dto.request.ExpenseUpdateRequest
import com.ayrtonnhaguaga.meusgastos.dto.response.ExpenseResponse
import com.ayrtonnhaguaga.meusgastos.model.Expense

fun ExpenseRequest.toEntity(): Expense {
    return Expense(
        description = this.description,
        amount = this.amount,
        category = this.category,
        expenseDate = this.expenseDate,
        paymentMethod = this.paymentMethod,
        notes = this.notes

    )
}

fun ExpenseUpdateRequest.toEntity(id: Long): Expense {
    return Expense(
        id = id,
        description = this.description,
        amount = this.amount,
        category = this.category,
        expenseDate = this.expenseDate,
        paymentMethod = this.paymentMethod,
        notes = this.notes

    )
}

fun Expense.toResponse(): ExpenseResponse {
    return ExpenseResponse(
        id = this.id,
        description = this.description,
        amount = this.amount,
        category = this.category,
        expenseDate = this.expenseDate,
        paymentMethod = this.paymentMethod,
        notes = this.notes,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}


fun List<Expense>.toResponseList(): List<ExpenseResponse> {
    return this.map { it.toResponse() }
}