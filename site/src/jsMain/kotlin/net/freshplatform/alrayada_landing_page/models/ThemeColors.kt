package net.freshplatform.alrayada_landing_page.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color

enum class ThemeColors(
    val colorValue: CSSColorValue,
) {
    PreviousPrimary(Color("#00A78E")),
    Primary(Color("#4CA92F")),
    OnPrimary(Color("#39B127")),
    Secondary(Color("#121D34")),
    GoldenOlive(Color("#8C7A2E")),
    Gray(Color("#CFCFCF")),
    LightGray(Color("#EDEDED")),
    LighterGray(Color("#F9F9F9"))
}