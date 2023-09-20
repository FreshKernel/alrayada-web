package com.ahmedhnewa.alrayada_landing_page.models

import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.utils.extensions.asFragmentIdentifier

sealed class NavigationLink(
    val titleRes: StringRes,
    val path: String
) {
    data class HomePageSection(
        val section: HomePageSections
    ) : NavigationLink(
        path = section.id.asFragmentIdentifier(),
        titleRes = section.titleRes
    )

    data class HomePageSectionWithAlternativeTitle(
        val section: HomePageSections,
        val alternativeTitleRes: StringRes
    ) : NavigationLink(
        path = section.id.asFragmentIdentifier(),
        titleRes = alternativeTitleRes
    )

    data class Page(
        val pageTitle: StringRes,
        val pagePath: String
    ) : NavigationLink(
        path = pagePath,
        titleRes = pageTitle
    )
}