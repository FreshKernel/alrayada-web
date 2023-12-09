package net.freshplatform.alrayada_landing_page.sections.our_customers.models

import net.freshplatform.alrayada_landing_page.core.data.StringRes

enum class OurCustomer(
    val icon: String,
    val title: StringRes
) {
    One(
        "school",
        StringRes.MinistryOfHigherEducationAndScientificResearch,
    ),
    Two(
        "oil-well",
        StringRes.OilMinistry,
    ),
    Three(
        "tree",
        StringRes.MinistryOfHealth,
    ),
    Four(
        "handshake",
        StringRes.PrivateSector,
    ),
    Five(
        "globe",
        StringRes.NonGovernmentalOrganization,
    ),
}