package com.example.driverlog.data.repo

import com.example.driverlog.data.local.dao.TransactionDao
import com.example.driverlog.data.local.entity.Transaction
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionRepository @Inject constructor(private val dao: TransactionDao) {
    val allTransactions: Flow<List<Transaction>> = dao.getAllTransactions()
    val totalIncome: Flow<Double?> = dao.getTotalIncome()
    val totalExpense: Flow<Double?> = dao.getTotalExpense()

    suspend fun addTransaction(transaction: Transaction) = dao.insertTransaction(transaction)
    suspend fun deleteTransaction(transaction: Transaction) = dao.deleteTransaction(transaction)
}