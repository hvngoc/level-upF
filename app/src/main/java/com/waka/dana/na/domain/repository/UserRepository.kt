package com.waka.dana.na.domain.repository

/**
 * Created by hvngoc on 7/29/22
 */
interface UserRepository {

    @Throws(Throwable::class)
    fun checkUserId(id: Int): Boolean
}