package com.example.space.model

interface DateProvider {

    fun getYesterday():String
    fun getDayBeforeYesterday():String

}