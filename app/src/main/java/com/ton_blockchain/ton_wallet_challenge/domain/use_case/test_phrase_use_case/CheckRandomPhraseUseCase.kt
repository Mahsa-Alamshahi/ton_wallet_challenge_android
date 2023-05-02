package com.ton_blockchain.ton_wallet_challenge.domain.use_case.test_phrase_use_case

import com.ton_blockchain.ton_wallet_challenge.domain.repository.TestPhraseRepository
import javax.inject.Inject

class CheckRandomPhraseUseCase @Inject constructor(private val testPhraseRepository: TestPhraseRepository) {

    operator fun invoke(phraseList: List<Pair<Int, String>>, randomNumber: MutableList<Pair<Int, String>>): Boolean =
        testPhraseRepository.checkRandomPhrase(phraseList, randomNumber)
}