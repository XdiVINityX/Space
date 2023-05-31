package com.example.space.model

import java.time.LocalDate
import java.time.format.DateTimeFormatter


class DataProviderImpl() : DateProvider {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    override fun getYesterday(): String {
        val yesterday = LocalDate.now().minusDays(1)
        return formatter.format(yesterday)
    }

    override fun getDayBeforeYesterday(): String {
       val dayBeforeYesterday = LocalDate.now().minusDays(2)
        return formatter.format(dayBeforeYesterday)
    }
}