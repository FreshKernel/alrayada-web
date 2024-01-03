package net.freshplatform.alrayada_web.sections.achievement.models

import androidx.compose.runtime.mutableStateListOf
import net.freshplatform.alrayada_web.core.data.StringRes

enum class Achievement(
    val icon: String,
    val number: Int,
    val descriptionRes: StringRes
) {
    Completed(
        icon = "square-check",
        number = 10,
        descriptionRes = StringRes.CompletedProjects
    ),
    Active(
        icon = "circle-dot",
        number = 3,
        descriptionRes = StringRes.ActiveProjects
    ),
    Satisfied(
        icon = "face-smile",
        number = 350,
        descriptionRes = StringRes.SatisfiedClients
    ),
    Team(
        icon = "user",
        number = 25,
        descriptionRes = StringRes.TeamMembers
    );

    companion object {
        // should match the length of enum items
        val animationDefaultValues = mutableStateListOf(0, 0, 0, 0)
    }
}