package com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "wallet")
data class WalletEntity(


    @ColumnInfo(name = "seed_birthday")
    var seedBirthday: String?,

    @ColumnInfo(name = "earliest_creation_time")
    var earliestCreationTime: String?,

    @ColumnInfo(name = "transaction")
    var transaction: String?,

    @ColumnInfo(name = "wallet_key")
    var walletKey: String?,

    @ColumnInfo(name = "address")
    var address: String?,

) : Parcelable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var walletId: Int = 0

}