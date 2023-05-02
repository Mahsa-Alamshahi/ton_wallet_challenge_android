package com.ton_blockchain.ton_wallet_challenge.domain.repository

interface TestPhraseRepository {

    fun generateRandomNumber(): List<Int>
    fun checkRandomPhrase(phraseList: List<Pair<Int, String>>, randomNumber: MutableList<Pair<Int, String>>): Boolean
}