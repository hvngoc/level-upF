package com.waka.dana.na.domain.di

import com.waka.dana.na.domain.usecase.CheckReferralUserUseCase
import com.waka.dana.na.domain.usecase.GetListWeatherByNameUseCase
import com.waka.dana.na.domain.usecase.SaveNewUserUseCase
import org.koin.dsl.module

/**
 * Created by hvngoc on 7/29/22
 */
val useCaseModule = module {
    single<GetListWeatherByNameUseCase> { GetListWeatherByNameUseCase(get()) }
    single { SaveNewUserUseCase(get()) }
    single { CheckReferralUserUseCase(get()) }
}