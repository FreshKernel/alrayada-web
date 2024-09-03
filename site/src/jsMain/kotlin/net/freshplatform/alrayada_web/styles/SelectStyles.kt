package net.freshplatform.alrayada_web.styles

import net.freshplatform.alrayada_web.models.ThemeColors
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.focus
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val MySelectStyle = CssStyle {
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
                Transition.of(property = "border-color", duration = 150.ms),
                Transition.of(property = "border-shadow", duration = 200.ms),
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