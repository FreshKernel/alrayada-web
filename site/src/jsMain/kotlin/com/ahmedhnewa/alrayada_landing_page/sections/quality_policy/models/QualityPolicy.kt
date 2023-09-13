package com.ahmedhnewa.alrayada_landing_page.sections.quality_policy.models

import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes

enum class QualityPolicy(
    val number: String,
    val descRes: StringRes
) {
    One(
        number = "01",
        descRes = StringRes.QualityPolicyDesc1,
    ),
    Two(
        number = "02",
        descRes = StringRes.QualityPolicyDesc2,
    ),
    Three(
        number = "03",
        descRes = StringRes.QualityPolicyDesc3,
    ),
}