package com.ton_blockchain.ton_wallet_challenge.data.repository

import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.BalanceDao
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.WalletDao
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.Balance
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.WalletEntity
import com.ton_blockchain.ton_wallet_challenge.domain.repository.DatabaseRepository
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val walletDao: WalletDao,
    private val balanceDao: BalanceDao
) : DatabaseRepository {


    override suspend fun getWallet(): List<WalletEntity> =
        walletDao.getWallets()

    override suspend fun getBalances(): List<Balance> =
    balanceDao.getBalances()


}