package com.ahmedhnewa.alrayada_landing_page.sections.achievement.models

import androidx.compose.runtime.mutableStateListOf
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes

enum class Achievement(
    val icon: String,
    val number: Int,
    val descriptionRes: StringRes
) {
    Completed(
        icon = "square-check",
        number = 20,
        descriptionRes = StringRes.CompletedProjects
    ),
    Active(
        icon = "circle-dot",
        number = 3,
        descriptionRes = StringRes.ActiveProjects
    ),
    Satisfied(
        icon = "face-smile",
        number = 6,
        descriptionRes = StringRes.SatisfiedClients
    ),
    Team(
        icon = "user",
        number = 1,
        descriptionRes = StringRes.TeamMembers
    );

    companion object {
        // should match the length of enum items
        val animationDefaultValues = mutableStateListOf(0, 0, 0, 0)
    }
}