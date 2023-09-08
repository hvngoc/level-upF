package com.waka.dana.na.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.waka.dana.na.data.room.dao.UserDao
import com.waka.dana.na.data.room.entities.UserEntity

/**
 * Created by hvngoc on 9/7/23
 */
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

}