package com.example.lotteryticketappmvvm

import android.app.Application
import com.example.lotteryticketappmvvm.data.LotteryTicket
import com.example.lotteryticketappmvvm.data.MainInteractor
import com.example.lotteryticketappmvvm.data.Repository
import com.example.lotteryticketappmvvm.data.ResultCommunication
import com.example.lotteryticketappmvvm.presentation.MainViewModel
import com.example.lotteryticketappmvvm.presentation.ManageResources

class NumberApp : Application() {
    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(
            ResultCommunication.Base(),
            MainInteractor()
        )
    }
}