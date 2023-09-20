package com.ahmedhnewa.alrayada_landing_page.styles

import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.focus
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val MySelectStyle by ComponentStyle {
    base {
        Modifier
            .minHeight(60.px)
            .minWidth(80.px)
            .border(width = 2.px, style = LineStyle.Solid, color = ThemeColors.LightGray.colorValue)
            .backgroundColor(ThemeColors.LighterGray.colorValue)
            .borderRadius(8.px)
            .fontSize(18.px)
            .padding(leftRight = 12.px)
            .transition(
                CSSTransition(property = "border-color", duration = 150.ms),
                CSSTransition(property = "border-shadow", duration = 200.ms),
            )
    }
    focus {
        Modifier
            .border(width = 3.px, style = LineStyle.Solid, color = ThemeColors.Primary.colorValue)
            .outline(style = LineStyle.None)
            .boxShadow(
                color = ThemeColors.Primary.colorValue,
                spreadRadius = 1.px
            )
    }
}