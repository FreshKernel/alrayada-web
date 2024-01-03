package net.freshplatform.alrayada_web.sections.experience.models

import net.freshplatform.alrayada_web.utils.constants.Constants

enum class Experience(
    val number: String,
    val jobPosition: String,
    val description: String,
    val company: String,
    val from: String,
    val to: String,
) {
    First(
        number = "01",
        jobPosition = "Kotlin Multi-Platform Developer",
        description = Constants.LOREM_IPSUM_LONG,
        company = "Google",
        from = "February 2022",
        to = "NOW"
    ),
    Second(
        number = "02",
        jobPosition = "Game developer",
        description = Constants.LOREM_IPSUM_LONG,
        company = "CD Red Project",
        from = "July 2019",
        to = "2022"
    ),
    Third(
        number = "03",
        jobPosition = "Web Developer",
        description = Constants.LOREM_IPSUM_LONG,
        company = "Fresh Platform",
        from = "March 2015",
        to = "2019"
    ),
}