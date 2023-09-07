package com.waka.dana.na.data.repository

import com.google.gson.Gson
import com.waka.dana.na.domain.repository.UserRepository

/**
 * Created by hvngoc on 7/29/22
 */
class UserRepositoryImpl(
    gson: Gson,
) : BaseRepository(gson), UserRepository {

    override fun checkUerId(id: Int): Boolean {
        TODO("Not yet implemented")
    }

}