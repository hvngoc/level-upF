package com.waka.dana.na.presentation.di

import com.google.gson.Gson
import com.waka.dana.na.presentation.screen.MainViewModel
import com.waka.dana.na.presentation.screen.home.HomeViewModel
import com.waka.dana.na.presentation.screen.new.NewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by hvngoc on 7/29/22
 */
val appModule = module {
    single { Gson() }

    viewModel { MainViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { NewViewModel(get(), get()) }
}