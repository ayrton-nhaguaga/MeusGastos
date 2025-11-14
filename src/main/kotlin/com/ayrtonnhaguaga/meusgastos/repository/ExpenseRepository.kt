package com.ayrtonnhaguaga.meusgastos.repository

import com.ayrtonnhaguaga.meusgastos.model.Expense
import com.ayrtonnhaguaga.meusgastos.model.ExpenseCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface ExpenseRepository : JpaRepository<Expense, Long> {

    fun findByExpenseDateBetween(startDate: LocalDate, endDate: LocalDate): List<Expense>

    fun findByCategoryAndExpenseDateBetween(
        category: ExpenseCategory,
        startDate: LocalDate,
        endDate: LocalDate
    ): List<Expense>

    @Query("SELECT e FROM Expense e WHERE YEAR(e.expenseDate) = :year AND MONTH(e.expenseDate) = :month")
    fun findByYearAndMonth(@Param("year") year: Int, @Param("month") month: Int): List<Expense>
}