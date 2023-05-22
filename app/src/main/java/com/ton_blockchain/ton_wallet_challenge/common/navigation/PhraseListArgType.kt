package com.ton_blockchain.ton_wallet_challenge.common.navigation

import com.google.gson.Gson
import com.ton_blockchain.ton_wallet_challenge.domain.model.PhraseList

class PhraseListArgType : JsonNavType<PhraseList>() {

    override fun fromJsonParse(value: String): PhraseList = Gson().fromJson(value, PhraseList::class.java)

    override fun PhraseList.getJsonParse(): String  = Gson().toJson(this)
}