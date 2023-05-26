package com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.Balance


@Dao
interface BalanceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBalance(balance: Balance)


    @Query("SELECT * from balance")
    fun getBalances(): List<Balance>


    @Query("DELETE FROM balance")
    suspend fun delete()


    suspend fun insertOrUpdate(balance: Balance) {
        val balanceList = getBalances()
        if (balanceList.isEmpty()) {
            insertBalance(balance)
        } else {
            delete()
            insertBalance(balance)
        }
    }
}