package com.example.lotteryticketappmvvm.data

interface ResultCommunication : Communication<String> {
    class Base : Communication.Base<String>(), ResultCommunication
}