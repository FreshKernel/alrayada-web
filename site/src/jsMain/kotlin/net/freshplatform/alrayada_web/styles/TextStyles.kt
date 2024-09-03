package net.freshplatform.alrayada_web.styles

import net.freshplatform.alrayada_web.models.ThemeColors
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms

val DescTextStyle1 = CssStyle {
    base {
        Modifier
            .color(Color("#898E9A"))
            .transition(Transition.of(property = "color", duration = 150.ms))
    }
    hover {
        Modifier
            .color(ThemeColors.Secondary.colorValue)
    }
}

val ReadableTextStyleOnWhiteBackground = CssStyle.base {
    Modifier
        .styleModifier {
            property("text-shadow", "1px 1px 1px rgba(0, 0, 0, 0.1)")
        }
}