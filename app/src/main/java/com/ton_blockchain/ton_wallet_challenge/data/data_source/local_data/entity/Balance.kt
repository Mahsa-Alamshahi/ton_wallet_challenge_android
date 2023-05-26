package com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "balance")
data class Balance(

    @ColumnInfo(name = "estimated")
    var estimated: String,
    @ColumnInfo(name = "available")
    var available: String,
    @ColumnInfo(name = "estimated_spendable")
    var estimatedSpendable: String,
    @ColumnInfo(name = "available_spendable")
    var availableSpendable: String

) : Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var balanceId: Int = 0
}