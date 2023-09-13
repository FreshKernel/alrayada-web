package com.ahmedhnewa.alrayada_landing_page.styles

import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val MainButtonStyle by ComponentStyle {
    base {
        Modifier.width(100.px)
            .height(40.px)
            .border(width = 0.px)
            .borderRadius(5.px)
            .backgroundColor(ThemeColors.Primary.colorValue)
            .color(Colors.White)
            .cursor(Cursor.Pointer)
            .transition(
                CSSTransition(property = "width", duration = 200.ms),
                CSSTransition(property = "background-color", duration = 200.ms),
            )
    }
    hover {
        Modifier
            .width(120.px)
            .backgroundColor(ThemeColors.OnPrimary.colorValue)
    }

}