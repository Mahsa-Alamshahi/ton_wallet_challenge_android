package com.ton_blockchain.ton_wallet_challenge.common.navigation

import android.os.Bundle
import androidx.navigation.NavType



abstract class JsonNavType<T> : NavType<T>(isNullableAllowed = false) {

    abstract fun fromJsonParse(value: String): T
    abstract fun T.getJsonParse(): String

    override fun get(bundle: Bundle, key: String): T? =
        bundle.getString(key)?.let { parseValue(it) }

    override fun parseValue(value: String): T = fromJsonParse(value)

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putString(key, value.getJsonParse())
    }
}