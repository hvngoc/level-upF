package com.waka.dana.na.domain.usecase

import com.waka.dana.na.domain.model.NewUser

/**
 * Created by hvngoc on 8/14/23
 */
class SaveNewUserUseCase: BaseUseCase<NewUser, Boolean>() {

    override suspend fun loadData(params: NewUser?): Boolean? {
        TODO("Not yet implemented")
    }
}