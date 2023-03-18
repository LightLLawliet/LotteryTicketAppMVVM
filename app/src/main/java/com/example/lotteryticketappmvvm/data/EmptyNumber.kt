package com.example.lotteryticketappmvvm.data

import com.example.lotteryticketappmvvm.presentation.NumberUi

abstract class EmptyNumber : NumberUi() {

    override fun map(message: String) = Unit
}