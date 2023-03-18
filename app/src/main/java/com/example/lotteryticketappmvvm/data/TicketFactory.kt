package com.example.lotteryticketappmvvm.data

interface TicketFactory {

    fun ticket(number: Int): LotteryTicket

    class Base : TicketFactory {
        override fun ticket(number: Int): LotteryTicket {
            if (number < 10 || number > 9999_9999)
                return LotteryTicket.Fake

            val digits = mutableListOf<Int>()

            var temp = number
            while (temp > 0) {
                val rest = temp % 10
                digits.add(rest)
                temp /= 10
            }

            if (digits.size % 2 == 1)
                return LotteryTicket.Fake

            return LotteryTicket.Base(digits)
        }
    }
}