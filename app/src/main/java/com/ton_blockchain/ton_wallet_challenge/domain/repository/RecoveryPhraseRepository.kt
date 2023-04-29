package com.ton_blockchain.ton_wallet_challenge.domain.repository

interface RecoveryPhraseRepository {

    fun generateRecoveryPhrase(): List<Pair<Int, String>>
}