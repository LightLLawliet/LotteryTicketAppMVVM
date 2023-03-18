package com.example.lotteryticketappmvvm.presentation

data class ResultUi(
    private val message: String,
    private val ui: NumberUi,
) {
    fun map() = ui.map(message)
}