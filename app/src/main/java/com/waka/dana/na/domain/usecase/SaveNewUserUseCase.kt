package com.waka.dana.na.domain.usecase

import com.waka.dana.na.domain.model.NewUser
import com.waka.dana.na.domain.repository.UserRepository

/**
 * Created by hvngoc on 8/14/23
 */
class SaveNewUserUseCase(
    private val userRepository: UserRepository
) : BaseUseCase<NewUser, Boolean>() {

    override suspend fun loadData(params: NewUser?): Boolean? {
        val param = params ?: return false
        userRepository.saveUser(param)
        return true
    }
}