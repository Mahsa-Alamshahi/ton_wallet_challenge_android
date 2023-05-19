package com.ton_blockchain.ton_wallet_challenge.domain.repository

interface RecoveryPhraseRepository {
    suspend fun generateRecoveryPhrase(): MutableList<Pair<Int, String>>
}