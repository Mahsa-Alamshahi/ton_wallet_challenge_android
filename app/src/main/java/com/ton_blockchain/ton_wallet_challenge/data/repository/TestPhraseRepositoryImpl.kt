package com.ton_blockchain.ton_wallet_challenge.data.repository

import com.ton_blockchain.ton_wallet_challenge.data.data_source.DataProvider
import com.ton_blockchain.ton_wallet_challenge.domain.repository.TestPhraseRepository
import javax.inject.Inject


class TestPhraseRepositoryImpl @Inject constructor(private val dataProvider: DataProvider): TestPhraseRepository {

    override fun generateRandomNumber(): List<Int> = dataProvider.generateRandomNumber()

}