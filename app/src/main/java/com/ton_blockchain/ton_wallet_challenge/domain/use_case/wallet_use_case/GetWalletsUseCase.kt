package com.ton_blockchain.ton_wallet_challenge.domain.use_case.wallet_use_case

import com.ton_blockchain.ton_wallet_challenge.data.data_source.local_data.entity.WalletEntity
import com.ton_blockchain.ton_wallet_challenge.domain.repository.DatabaseRepository
import javax.inject.Inject

class GetWalletsUseCase @Inject constructor(private val databaseRepository: DatabaseRepository) {

    suspend operator fun invoke(): List<WalletEntity> = databaseRepository.getWallet()

}