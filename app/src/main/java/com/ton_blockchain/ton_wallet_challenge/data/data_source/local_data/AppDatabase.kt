package com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao.WalletDao
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.WalletEntity

@Database(
    entities = [WalletEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun walletDao(): WalletDao?
}