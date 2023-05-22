package com.ton_blockchain.ton_wallet_challenge.domain.use_case.test_phrase_use_case

import com.ton_blockchain.ton_wallet_challenge.domain.repository.TestPhraseRepository
import javax.inject.Inject

class GenerateRandomNumberUseCase @Inject constructor(private val testPhraseRepository: TestPhraseRepository) {

    operator fun invoke(): List<Int> = testPhraseRepository.generateRandomNumber()

}