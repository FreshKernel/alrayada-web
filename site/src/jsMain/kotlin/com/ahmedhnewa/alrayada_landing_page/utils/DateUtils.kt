package com.ahmedhnewa.alrayada_landing_page.utils

import kotlin.js.Date

// Programmers only date bugs

fun isLastDayOfTheYear(): Boolean {
    val currentDate = Date()
    val currentYear = currentDate.getFullYear()
    val december31 = Date(currentYear, 11, 31)

    return currentDate.getTime() == december31.getTime()
}