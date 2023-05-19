package com.ton_blockchain.ton_wallet_challenge.data.local_data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
}