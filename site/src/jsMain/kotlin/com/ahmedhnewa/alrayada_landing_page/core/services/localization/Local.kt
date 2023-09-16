package com.ahmedhnewa.alrayada_landing_page.core.services.localization

import org.jetbrains.compose.web.attributes.DirType

enum class Local(
    val value: String,
    val dir: DirType
) {
    English("en", DirType.Ltr),
    Arabic("ar", DirType.Rtl),
    Turkey("tr", DirType.Auto)
}