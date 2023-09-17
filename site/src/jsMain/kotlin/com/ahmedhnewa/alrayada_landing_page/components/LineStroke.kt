package com.ahmedhnewa.alrayada_landing_page.components

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.width
import org.jetbrains.compose.web.css.px

@Composable
fun LineStroke(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.height(2.px)
            .width(80.px)
            .backgroundColor(ThemeColors.Primary.colorValue)
            .borderRadius(r = 50.px)
            .then(modifier)
    )
}