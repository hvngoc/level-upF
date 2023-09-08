package com.waka.dana.na.data.repository

import com.google.gson.Gson
import com.waka.dana.na.data.room.AppDatabase
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

}