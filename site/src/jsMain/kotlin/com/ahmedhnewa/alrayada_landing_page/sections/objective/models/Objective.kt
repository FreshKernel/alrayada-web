package com.ahmedhnewa.alrayada_landing_page.sections.objective.models

import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes

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