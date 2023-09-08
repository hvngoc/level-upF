package com.waka.dana.na.domain.usecase

import com.waka.dana.na.domain.repository.UserRepository

/**
 * Created by hvngoc on 8/14/23
 */
class CheckReferralUserUseCase(private val userRepository: UserRepository) :
    BaseUseCase<Int, Boolean>() {

    override suspend fun loadData(params: Int?): Boolean? {
        val id = params ?: return true
        return userRepository.checkUserId(id)
    }
}