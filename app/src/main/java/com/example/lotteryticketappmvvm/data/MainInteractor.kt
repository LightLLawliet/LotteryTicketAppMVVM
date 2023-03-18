package com.example.lotteryticketappmvvm.data

import com.example.lotteryticketappmvvm.R
import com.example.lotteryticketappmvvm.presentation.ManageResources
import com.example.lotteryticketappmvvm.presentation.NumberUi
import com.example.lotteryticketappmvvm.presentation.ResultUi

interface MainInteractor {

    fun handle(): ResultUi

    fun init(): ResultUi

    class Base(
        private val repository: Repository,
        private val lotteryTicket: LotteryTicket,
        private val manageResources: ManageResources
    ) : MainInteractor {
        override fun handle(): ResultUi =
            if (lotteryTicket.isWinner()) {
                ResultUi(manageResources.string(R.string.win), NumberUi.Empty)
            } else {
                ResultUi(manageResources.string(R.string.loss), NumberUi.Empty)
            }


        override fun init() = repository.init()
    }
}