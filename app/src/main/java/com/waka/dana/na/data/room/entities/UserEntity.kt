package com.waka.dana.na.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by hvngoc on 9/8/23
 */
@Entity(tableName = "User")
data class UserEntity(
    @ColumnInfo(name = "userId")
    @PrimaryKey(autoGenerate = true)
    val userId: Int,
    @ColumnInfo(name = "referralId")
    val referralId: Int?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "numPrice")
    val numPrice: String?,
    @ColumnInfo(name = "numSell")
    val numSell: String?,
)