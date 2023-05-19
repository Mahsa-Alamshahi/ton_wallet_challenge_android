package com.ton_blockchain.ton_wallet_challenge.presentation.recovery_phrase.components

data class RecoveryPhraseState(
    val isLoading: Boolean = false,
    val data: List<Pair<Int, String>> = emptyList(),
    val error: String = ""
)
