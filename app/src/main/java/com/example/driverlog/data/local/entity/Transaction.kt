package com.example.driverlog.data.local.entity

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.DirectionsCar
import androidx.compose.material.icons.rounded.LocalGasStation
import androidx.compose.material.icons.rounded.Newspaper
import androidx.compose.material.icons.rounded.PictureAsPdf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val type: TransactionType,
    val category: String,
    val amount: Double,
    val description: String,
    val date: Long,
    val timestamp: Long = System.currentTimeMillis()
)

enum class TransactionType {
    INCOME,
    EXPENSE
}

enum class ExpenseCategory(val label: String, val icon: ImageVector) {
    FUEL("Fuel/Petrol/Diesel", Icons.Rounded.LocalGasStation),
    CNG("CNG", Icons.Rounded.LocalGasStation),
    SERVICE("Car Service", Icons.Rounded.Build),
    MAINTENANCE("Maintenance", Icons.Rounded.Build),
    INSURANCE("Insurance", Icons.Rounded.PictureAsPdf),
    TAX("Tax", Icons.Rounded.Newspaper),
    TOLL("Toll/Parking", Icons.Rounded.DirectionsCar),
    OTHER("Other", Icons.Default.MoreHoriz),
    INCOME("Trip Fare", Icons.Rounded.AttachMoney) // Used for Income type
}
