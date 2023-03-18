package com.example.lotteryticketappmvvm.data

import com.example.lotteryticketappmvvm.R
import com.example.lotteryticketappmvvm.presentation.ManageResources
import com.example.lotteryticketappmvvm.presentation.NumberUi
import com.example.lotteryticketappmvvm.presentation.ResultUi


interface Repository {

    fun init(): ResultUi

    fun winMessage(): String

    fun lossMessage(): String

    fun errorMessage(): String

    fun winCase(): Boolean

    class Base(
        private val manageResources: ManageResources,
        private val lotteryTicket: LotteryTicket
    ) : Repository {

        private var lastMessage = manageResources.string(0)

        override fun winCase(): Boolean = lotteryTicket.isWinner()

        override fun init(): ResultUi = ResultUi(lastMessage, NumberUi.Empty)

        override fun winMessage(): String = manageResources.string(R.string.win)

        override fun lossMessage(): String = manageResources.string(R.string.loss)

        override fun errorMessage(): String = manageResources.string(R.string.incorrect_number)
    }
}