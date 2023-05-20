package com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "balance")
data class Balance(
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "estimated")
    var estimated: Float,
    @ColumnInfo(name = "available")
    var available: Float,
    @ColumnInfo(name = "estimated_spendable")
    var estimatedSpendable: Float,
    @ColumnInfo(name = "available_spendable")
    var availableSpendable: Float
) : Parcelable