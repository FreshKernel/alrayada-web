package net.freshplatform.alrayada_landing_page.styles

import net.freshplatform.alrayada_landing_page.models.ThemeColors
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.ms

val DescTextStyle1 by ComponentStyle {
    base {
        Modifier
            .color(Color("#898E9A"))
            .transition(CSSTransition(property = "color", duration = 150.ms))
    }
    hover {
        Modifier
            .color(ThemeColors.Secondary.colorValue)
    }
}

val ReadableTextStyleOnWhiteBackground by ComponentStyle.base {
    Modifier
        .styleModifier {
            property("text-shadow", "1px 1px 1px rgba(0, 0, 0, 0.1)")
        }
}