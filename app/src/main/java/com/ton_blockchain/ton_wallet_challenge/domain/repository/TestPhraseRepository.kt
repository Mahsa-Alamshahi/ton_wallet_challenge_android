package com.ton_blockchain.ton_wallet_challenge.domain.repository

interface TestPhraseRepository {

    fun generateRandomNumber(): List<Int>
}