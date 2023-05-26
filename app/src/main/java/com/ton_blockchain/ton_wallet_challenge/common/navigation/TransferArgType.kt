package com.ton_blockchain.ton_wallet_challenge.common.navigation

import com.google.gson.Gson
import com.ton_blockchain.ton_wallet_challenge.domain.model.dto.TransferObject

class TransferArgType : JsonNavType<TransferObject>() {

    override fun fromJsonParse(value: String): TransferObject = Gson().fromJson(value, TransferObject::class.java)

    override fun TransferObject.getJsonParse(): String = Gson().toJson(this)
}