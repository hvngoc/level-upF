package com.waka.dana.na.data.di

import android.content.Context
import androidx.room.Room
import com.waka.dana.na.data.cache.CacheServices
import com.waka.dana.na.data.cache.CacheServicesImpl
import com.waka.dana.na.data.cache.FileServices
import com.waka.dana.na.data.cache.FileServicesImpl
import com.waka.dana.na.data.room.AppDatabase
import org.koin.dsl.module

/**
 * Created by hvngoc on 7/29/22
 */
val cacheModule = module {
    single<FileServices> { FileServicesImpl(get()) }
    single<CacheServices> { CacheServicesImpl(get(), get()) }
    single<AppDatabase> { provideRoom(get()) }
}

internal fun provideRoom(c: Context): AppDatabase {
    return Room.databaseBuilder(c, AppDatabase::class.java, "roomdb")
        .allowMainThreadQueries()
        .build()
}