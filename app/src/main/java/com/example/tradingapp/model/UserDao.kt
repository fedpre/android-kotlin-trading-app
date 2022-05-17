package com.example.tradingapp.model

import androidx.room.*
import java.util.concurrent.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUserById(id: Int): User

    @Query("SELECT * FROM user WHERE client_username LIKE :username LIMIT 1")
    fun findByUsername(username: String): User

    @Query("SELECT client_balance from user WHERE client_username = :username")
    fun getClientBalance(username: String): Double

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg users: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}