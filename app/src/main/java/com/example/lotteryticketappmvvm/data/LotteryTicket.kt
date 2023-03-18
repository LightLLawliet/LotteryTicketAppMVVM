package com.example.lotteryticketappmvvm.data

interface LotteryTicket {

    fun isWinner(): Boolean

    fun isFake(): Boolean

    class Base(private val digits: List<Int>) : LotteryTicket {

        override fun isWinner(): Boolean {
            var sum = 0
            digits.forEachIndexed { index, digit ->
                if (index < digits.size / 2)
                    sum += digit
                else {
                    sum -= digit
                    if (sum < 0) return false
                }
            }
            return sum == 0
        }

        override fun isFake(): Boolean {
            return false
        }
    }

    object Fake : LotteryTicket {
        override fun isWinner(): Boolean {
            throw IllegalStateException()
        }

        override fun isFake(): Boolean {
            return true
        }
    }
}