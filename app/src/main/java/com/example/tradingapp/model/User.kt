package com.example.tradingapp.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @NonNull @ColumnInfo(name= "client_fullname")
    val clientFullname: String,
    @NonNull @ColumnInfo(name= "client_email")
    val clientEmail: String,
    @NonNull @ColumnInfo(name= "client_username")
    val clientUsername: String,
    @NonNull @ColumnInfo(name="client_password")
    val clientPassword: String,
    @NonNull @ColumnInfo(name="client_balance")
    val clientBalance: Double
    )