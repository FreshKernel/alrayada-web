package com.ahmedhnewa.alrayada_landing_page.sections.our_values.models

import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes

enum class OurValueModel(
    val value: StringRes,
    val desc: StringRes
) {
    Quality(
        StringRes.Quality,
        StringRes.QualityValueDesc
    ),
    Leadership(
        StringRes.Leadership,
        StringRes.LeadershipValueDesc
    ),
    Diversity(
        StringRes.Diversity,
        StringRes.DiversityValueDesc
    ),
    Concentration(
        StringRes.Concentration,
        StringRes.ConcentrationValueDesc
    )
}