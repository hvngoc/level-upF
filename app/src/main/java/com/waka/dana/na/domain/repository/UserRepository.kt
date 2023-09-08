package com.waka.dana.na.domain.repository

import com.waka.dana.na.domain.model.NewUser

/**
 * Created by hvngoc on 7/29/22
 */
interface UserRepository {

    @Throws(Throwable::class)
    fun checkUserId(id: Int): Boolean

    @Throws(Throwable::class)
    fun saveUser(newUser: NewUser): Int
}