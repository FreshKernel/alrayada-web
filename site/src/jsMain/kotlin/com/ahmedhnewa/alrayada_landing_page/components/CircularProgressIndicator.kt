package com.ahmedhnewa.alrayada_landing_page.components

import androidx.compose.runtime.*
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.CSSAnimation
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.theme.shapes.clip
import kotlinx.browser.document
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun CircularProgressIndicator(modifier: Modifier = Modifier) {
    Div(
        attrs = Modifier
            .size(100.px)
            .position(Position.Relative)
            .then(modifier)
            .toAttrs()
    ) {

        Div(
            attrs = Modifier
                .fillMaxSize()
                .border(8.px, LineStyle.Solid, ThemeColors.Primary.colorValue)
                .borderTop(color = Color("#007bff"))
                .borderRadius(50.percent)
                .animation(
                    CSSAnimation("spin", 1.1.s, AnimationTimingFunction.Linear, iterationCount = AnimationIterationCount.Infinite)
                )
                .toAttrs()
        )
    }
}