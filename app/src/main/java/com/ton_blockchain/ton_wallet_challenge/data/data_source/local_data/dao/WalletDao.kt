package com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.WalletEntity


@Dao
interface WalletDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWallet(wallet: WalletEntity)


    @Query("SELECT * from wallet")
    fun getWallets(): List<WalletEntity>


    @Query("DELETE FROM wallet")
    suspend fun delete()


    suspend fun insertOrUpdate(wallet: WalletEntity) {
        val walletList = getWallets()
        if (walletList.isEmpty()) {
            insertWallet(wallet)
        } else {
            delete()
            insertWallet(wallet)
        }
    }
}