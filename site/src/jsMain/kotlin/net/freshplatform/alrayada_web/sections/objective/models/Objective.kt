package net.freshplatform.alrayada_web.sections.objective.models

import net.freshplatform.alrayada_web.core.data.StringRes

enum class Objective(
    val titleRes: StringRes,
    val descRes: StringRes,
) {
    One(
        StringRes.OurVision,
        StringRes.OurVisionText
    ),
    Two(
        StringRes.OurMission,
        StringRes.OurMissionText
    ),
}