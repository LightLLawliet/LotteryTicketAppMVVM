package com.example.lotteryticketappmvvm.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.lotteryticketappmvvm.data.LotteryTicket
import com.example.lotteryticketappmvvm.data.MainInteractor
import com.example.lotteryticketappmvvm.data.ResultCommunication
import com.example.lotteryticketappmvvm.data.TicketFactory

class MainViewModel(
    private val communicationResult: ResultCommunication,
    private val interactor: MainInteractor
) : ViewModel() {

    fun observe(owner: LifecycleOwner, observer: Observer<String>) =
        communicationResult.observe(owner, observer)

    fun init() =
        interactor.init().map()

    fun update(result: Int): LotteryTicket = TicketFactory.Base().ticket(result)
}

