package net.freshplatform.alrayada_web.components

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.fa.FaCheck
import net.freshplatform.alrayada_web.components.fa.IconSize
import net.freshplatform.alrayada_web.models.ThemeColors
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val CheckIndicatorStyle = CssStyle {
    val borderColor = Color("#7F7F7F")
    base {
        Modifier
            .color(ThemeColors.Primary.colorValue)
            .border(width = 2.px, style = LineStyle.Solid, color = borderColor)
            .transition(
                Transition.of(
                    property = "color",
                    duration = 200.ms,
                ),
                Transition.of(
                    property = "border-color",
                    duration = 200.ms,
                ),
                Transition.of(
                    property = "border-width",
                    duration = 200.ms,
                ),
            )
    }
    hover {
        Modifier
            .color(borderColor)
            .borderRadius(r = 50.px)
            .border(width = 4.px, style = LineStyle.Solid, color = ThemeColors.Primary.colorValue)
    }
}

@Composable
fun CheckIndicator(
    modifier: Modifier = Modifier,
    iconSize: IconSize = IconSize.X1,
) {
    Box(
        modifier = CheckIndicatorStyle
            .toModifier()
            .padding(3.px)
            .borderRadius(r = 2.px)
            .then(modifier)
    ) {
        FaCheck(
            size = iconSize
        )
    }
}