package com.ton_blockchain.ton_wallet_challenge.di

import android.content.Context
import androidx.room.Room
import com.ton_blockchain.ton_wallet_challenge.common.Constants.DB_NAME
import com.ton_blockchain.ton_wallet_challenge.data.local_data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    fun provideDatabase(@ApplicationContext application: Context): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, DB_NAME)
            .allowMainThreadQueries()
            .build()
    }



}