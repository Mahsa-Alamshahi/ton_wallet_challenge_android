package com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.BalanceDao
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.WalletDao
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.Balance
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.WalletEntity

@Database(
    entities = [WalletEntity::class, Balance::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun walletDao(): WalletDao?
    abstract fun balanceDao(): BalanceDao?
}