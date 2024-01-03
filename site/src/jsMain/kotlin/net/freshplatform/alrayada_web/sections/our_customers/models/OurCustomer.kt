package net.freshplatform.alrayada_web.sections.our_customers.models

import net.freshplatform.alrayada_web.core.data.StringRes

enum class OurCustomer(
    val icon: String,
    val title: StringRes
) {
    MinistryOfHealth(
        "tree",
        StringRes.MinistryOfHealth,
    ),
    OilMinistry(
        "oil-well",
        StringRes.OilMinistry,
    ),
    MinistryOfHigherEducationAndScientificResearch(
        "school",
        StringRes.MinistryOfHigherEducationAndScientificResearch,
    ),
    PrivateSector(
        "handshake",
        StringRes.PrivateSector,
    ),
    NonGovernmentalOrganization(
        "globe",
        StringRes.NonGovernmentalOrganization,
    ),
}