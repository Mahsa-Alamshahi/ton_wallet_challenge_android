package com.ton_blockchain.ton_wallet_challenge.di

import com.ton_blockchain.ton_wallet_challenge.data.data_source.DataProvider
import com.ton_blockchain.ton_wallet_challenge.data.data_source.RecoveryPhraseProvider
import com.ton_blockchain.ton_wallet_challenge.data.data_source.WalletProvider
import com.ton_blockchain.ton_wallet_challenge.data.repository.RecoveryPhraseRepositoryImpl
import com.ton_blockchain.ton_wallet_challenge.data.repository.TestPhraseRepositoryImpl
import com.ton_blockchain.ton_wallet_challenge.domain.repository.RecoveryPhraseRepository
import com.ton_blockchain.ton_wallet_challenge.domain.repository.TestPhraseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRecoveryPhraseProvider(): RecoveryPhraseProvider = RecoveryPhraseProvider()


    @Provides
    fun provideRecoveryPhraseRepository(recoveryPhraseProvider: RecoveryPhraseProvider): RecoveryPhraseRepository =
        RecoveryPhraseRepositoryImpl(recoveryPhraseProvider)


     @Provides
    fun provideTestPhraseRepository(dataProvider: DataProvider): TestPhraseRepository =
        TestPhraseRepositoryImpl(dataProvider)


    @Provides
    fun provideDataProvider(): DataProvider = DataProvider()


    @Provides
    fun provideWalletProvider(): WalletProvider = WalletProvider()
}