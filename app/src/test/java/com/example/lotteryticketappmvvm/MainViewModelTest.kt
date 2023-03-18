package com.example.lotteryticketappmvvm

import com.example.lotteryticketappmvvm.data.TicketFactory
import org.junit.Assert.assertEquals
import org.junit.Test

class MainViewModelTest {

    @Test
    fun `test success`() {
        val list = listOf(11, 1111, 5656, 8686, 101101, 908188)
        val factory = TicketFactory.Base()
        val expected = true
        list.forEach { number ->
            val ticket = factory.ticket(number)
            assertEquals(false, ticket.isFake())
            val actual = ticket.isWinner()
            assertEquals(expected, actual)
        }
    }

    @Test
    fun `test failure`() {
        val list = listOf(12, 34, 56, 5678, 9101, 101102)
        val factory = TicketFactory.Base()
        val expected = false
        list.forEach { number ->
            val ticket = factory.ticket(number)
            assertEquals(false, ticket.isFake())
            val actual = ticket.isWinner()
            assertEquals(expected, actual)
        }
    }

    @Test
    fun `test invalid`() {
        val factory = TicketFactory.Base()
        val list = listOf(
            0,
            1,
            2,
            -1,
            -2,
            -3,
            1241251522,
            131,
            11141,
            1114191,
            Int.MIN_VALUE,
            Int.MAX_VALUE
        )
        list.forEach { number ->
            val actual = factory.ticket(number = number)
            assertEquals(true, actual.isFake())
        }
    }
}