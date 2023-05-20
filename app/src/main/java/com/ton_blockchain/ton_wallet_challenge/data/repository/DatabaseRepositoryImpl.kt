package com.ton_blockchain.ton_wallet_challenge.data.repository

import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.WalletDao
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.WalletEntity
import com.ton_blockchain.ton_wallet_challenge.domain.repository.DatabaseRepository
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(private val walletDao: WalletDao): DatabaseRepository {


    override suspend fun getWallet(): List<WalletEntity> =
       walletDao.getWallets()


}