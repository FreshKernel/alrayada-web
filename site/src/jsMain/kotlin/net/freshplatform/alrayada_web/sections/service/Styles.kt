package net.freshplatform.alrayada_web.sections.service

import net.freshplatform.alrayada_web.models.ThemeColors
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ServiceCardStyle = CssStyle {
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
                Transition.of(property = "border", duration = 100.ms),
                Transition.of(property = "background", duration = 100.ms),
                Transition.of(property = "box-shadow", duration = 100.ms),
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
                Transition.of(property = "background", duration = 100.ms),
            )
    }

    cssRule(":hover > #iconBox") {
        Modifier.backgroundColor(Colors.White)
    }

    cssRule(" > p") {
        Modifier
            .color(ThemeColors.Secondary.colorValue)
            .transition(
                Transition.of(property = "color", duration = 100.ms),
            )
    }

    cssRule(":hover > p") {
        Modifier.color(Colors.White)
    }
}