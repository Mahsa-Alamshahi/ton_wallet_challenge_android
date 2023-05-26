package com.ton_blockchain.ton_wallet_challenge.di

import android.content.Context
import androidx.room.Room
import com.ton_blockchain.ton_wallet_challenge.common.Constants.DB_NAME
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.AppDatabase
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.BalanceDao
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.WalletDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext application: Context): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, DB_NAME)
            .allowMainThreadQueries().build()
    }


    @Singleton
    @Provides
    fun provideWalletDao(db: AppDatabase): WalletDao? = db.walletDao()

    @Singleton
    @Provides
    fun provideBalanceDao(db: AppDatabase): BalanceDao? = db.balanceDao()

}