package com.ton_blockchain.ton_wallet_challenge.domain.use_case.import_existing_wallet_use_case

import com.ton_blockchain.ton_wallet_challenge.domain.repository.ImportExistingWalletRepository
import javax.inject.Inject

class ImportExistingWalletUseCase @Inject constructor(private val importExistingWalletRepository: ImportExistingWalletRepository) {

    operator fun invoke(phraseList: MutableList<String>) {
//        var mnemonicString = ""
//        phraseList.forEach { phrase ->
//            mnemonicString += "$phrase "
//        }
//        mnemonicString.dropLast(1)
        importExistingWalletRepository.generateWallet(phraseList)
    }
}