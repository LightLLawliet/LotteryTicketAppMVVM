package com.example.lotteryticketappmvvm.presentation

import com.example.lotteryticketappmvvm.data.EmptyNumber

abstract class NumberUi {
    abstract fun map(
        message: String
    )

    object Empty : EmptyNumber()
}