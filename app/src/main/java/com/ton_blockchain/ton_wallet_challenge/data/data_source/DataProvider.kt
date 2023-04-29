package com.ton_blockchain.ton_wallet_challenge.data.data_source

import kotlin.random.Random

class DataProvider {

    fun generateRandomNumber(): List<Int> {
        val someRandomInts: List<Int> =
            randomGenerator(1, 24)
                .distinct()
                .take(3)
                .toList().sorted()
        println(someRandomInts)
        return someRandomInts
    }


    private fun randomGenerator(from: Int,
                        until: Int,
                        random: Random = Random.Default): Sequence<Int> = sequence {
        while(true) {
            yield(random.nextInt(from, until))
        }
    }





}