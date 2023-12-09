package net.freshplatform.alrayada_landing_page.sections.service

import net.freshplatform.alrayada_landing_page.models.ThemeColors
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ServiceCardStyle by ComponentStyle {
    base {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = ThemeColors.LighterGray.colorValue
            )
            .borderRadius(r = 6.px)
            .backgroundColor(Colors.White)
            .styleModifier {
                property("box-shadow", "rgba(0, 0, 0, 0.05) 0px 6px 24px 0px, rgba(0, 0, 0, 0.08) 0px 0px 0px 1px")
            }
            .transition(
                CSSTransition(property = "border", duration = 100.ms),
                CSSTransition(property = "background", duration = 100.ms),
                CSSTransition(property = "box-shadow", duration = 100.ms),
            )
    }
    hover {
        Modifier
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = ThemeColors.Primary.colorValue
            )
            .styleModifier {
                property("box-shadow", "rgba(0, 0, 0, 0.24) 0px 3px 8px")
            }
            .backgroundColor(ThemeColors.Primary.colorValue)
    }


    cssRule(" > #iconBox") {
        Modifier
            .backgroundColor(Colors.Transparent)
            .transition(
                CSSTransition(property = "background", duration = 100.ms),
            )
    }

    cssRule(":hover > #iconBox") {
        Modifier.backgroundColor(Colors.White)
    }

    cssRule(" > p") {
        Modifier
            .color(ThemeColors.Secondary.colorValue)
            .transition(
                CSSTransition(property = "color", duration = 100.ms),
            )
    }

    cssRule(":hover > p") {
        Modifier.color(Colors.White)
    }
}