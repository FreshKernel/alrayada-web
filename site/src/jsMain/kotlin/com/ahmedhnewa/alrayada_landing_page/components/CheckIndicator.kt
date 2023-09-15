package com.ahmedhnewa.alrayada_landing_page.components

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.fa.FaCheck
import com.ahmedhnewa.alrayada_landing_page.components.fa.IconSize
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.padding
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

@Composable
fun CheckIndicator(
    modifier: Modifier = Modifier,
    iconSize: IconSize = IconSize.X1,
    borderColor: CSSColorValue = ThemeColors.Gray.colorValue
) {
    Box(
        modifier = Modifier
            .padding(3.px)
            .border(width = 2.px, style = LineStyle.Solid, color = borderColor)
            .borderRadius(r = 2.px)
            .then(modifier)
    ) {
        FaCheck(
            modifier = Modifier.color(ThemeColors.Primary.colorValue),
            size = iconSize
        )
    }
}