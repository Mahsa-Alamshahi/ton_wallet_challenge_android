package com.ton_blockchain.ton_wallet_challenge.di

import com.ton_blockchain.ton_wallet_challenge.data.data_source.DataProvider
import com.ton_blockchain.ton_wallet_challenge.data.data_source.RecoveryPhraseProvider
import com.ton_blockchain.ton_wallet_challenge.data.data_source.WalletProvider
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.BalanceDao
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.WalletDao
import com.ton_blockchain.ton_wallet_challenge.data.repository.DatabaseRepositoryImpl
import com.ton_blockchain.ton_wallet_challenge.data.repository.ImportExistingWalletRepositoryImpl
import com.ton_blockchain.ton_wallet_challenge.data.repository.RecoveryPhraseRepositoryImpl
import com.ton_blockchain.ton_wallet_challenge.data.repository.TestPhraseRepositoryImpl
import com.ton_blockchain.ton_wallet_challenge.domain.repository.DatabaseRepository
import com.ton_blockchain.ton_wallet_challenge.domain.repository.ImportExistingWalletRepository
import com.ton_blockchain.ton_wallet_challenge.domain.repository.RecoveryPhraseRepository
import com.ton_blockchain.ton_wallet_challenge.domain.repository.TestPhraseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.annotation.Nullable

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideRecoveryPhraseRepository(recoveryPhraseProvider: RecoveryPhraseProvider): RecoveryPhraseRepository =
        RecoveryPhraseRepositoryImpl(recoveryPhraseProvider)


    @Provides
    fun provideTestPhraseRepository(dataProvider: DataProvider): TestPhraseRepository =
        TestPhraseRepositoryImpl(dataProvider)


    @Provides
    fun provideDataProvider(): DataProvider = DataProvider()


    @Provides
    fun provideWalletProvider(@Nullable walletDao: WalletDao?, @Nullable balanceDao: BalanceDao?): WalletProvider = WalletProvider(
        walletDao!!, balanceDao!!
    )


    @Provides
    fun provideImportExistingWalletRepository(
        recoveryPhraseProvider: RecoveryPhraseProvider,
        walletProvider: WalletProvider
    ): ImportExistingWalletRepository =
        ImportExistingWalletRepositoryImpl(recoveryPhraseProvider, walletProvider)


    @Provides
    fun provideDatabaseRepository(@Nullable walletDao: WalletDao?, @Nullable balanceDao: BalanceDao?): DatabaseRepository =
       DatabaseRepositoryImpl(walletDao!!, balanceDao!!)

}