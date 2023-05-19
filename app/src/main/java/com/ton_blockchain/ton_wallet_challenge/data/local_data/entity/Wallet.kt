package com.ton_blockchain.ton_wallet_challenge.data.local_data.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "wallet")
data class Wallet(@PrimaryKey(autoGenerate = false)
                  @NonNull
                  @ColumnInfo(name = "id")
                  var id: Int,): Parcelable