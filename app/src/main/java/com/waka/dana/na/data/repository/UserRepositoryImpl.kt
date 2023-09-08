package com.waka.dana.na.data.repository

import com.google.gson.Gson
import com.waka.dana.na.data.room.AppDatabase
import com.waka.dana.na.data.room.entities.UserEntity
import com.waka.dana.na.domain.model.NewUser
import com.waka.dana.na.domain.repository.UserRepository

/**
 * Created by hvngoc on 7/29/22
 */
class UserRepositoryImpl(
    private val gson: Gson,
    private val database: AppDatabase
) : BaseRepository(gson), UserRepository {

    override fun checkUserId(id: Int): Boolean {
        return database.userDao().findUserById(id) != null
    }

    override fun saveUser(newUser: NewUser): Int {
        val entity =
            UserEntity(0, newUser.referralId, newUser.name, newUser.numPrice, newUser.numSell)
        val res = database.userDao().insertUser(entity)
        return res.userId
    }

}