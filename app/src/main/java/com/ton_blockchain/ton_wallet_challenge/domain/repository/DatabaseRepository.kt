package com.ton_blockchain.ton_wallet_challenge.domain.repository

import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.Balance
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.WalletEntity

interface DatabaseRepository {

    suspend fun getWallet(): List<WalletEntity>
    suspend fun getBalances(): List<Balance>

}