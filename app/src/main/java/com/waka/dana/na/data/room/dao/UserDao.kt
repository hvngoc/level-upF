package com.waka.dana.na.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.waka.dana.na.data.room.entities.UserEntity

/**
 * Created by hvngoc on 9/8/23
 */
@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    fun insertUser(user: UserEntity): UserEntity

    @Update(onConflict = REPLACE)
    fun updateUser(user: UserEntity)

    @Query("select * from User where userId = :id")
    fun findUserById(id: Int): UserEntity?

    @Query("select * from User")
    fun getAllUser(): List<UserEntity>
}