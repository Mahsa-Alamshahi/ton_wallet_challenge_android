package com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "transaction")
data class Transaction(
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "pending")
    var pending: Float,
    @ColumnInfo(name = "unspent")
    var unspent: Float,
    @ColumnInfo(name = "spent")
    var spent: Float,
    @ColumnInfo(name = "dead")
    var dead: Float
): Parcelable
