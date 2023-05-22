package com.ton_blockchain.ton_wallet_challenge.domain.model

import android.net.Uri
import com.google.gson.Gson


data class PhraseList(var phrases: List<Pair<Int, String>>) {
    override fun toString(): String = Uri.encode(Gson().toJson(this))
}
