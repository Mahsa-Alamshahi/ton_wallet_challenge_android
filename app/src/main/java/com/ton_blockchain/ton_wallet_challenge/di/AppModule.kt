package com.ton_blockchain.ton_wallet_challenge.di

import com.ton_blockchain.ton_wallet_challenge.data.data_source.RecoveryPhraseProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRecoveryPhraseProvider(): RecoveryPhraseProvider = RecoveryPhraseProvider()

}