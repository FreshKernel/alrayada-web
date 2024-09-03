package net.freshplatform.alrayada_web.components

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.fa.FaCircle
import net.freshplatform.alrayada_web.components.fa.IconSize
import net.freshplatform.alrayada_web.components.fa.IconStyle
import net.freshplatform.alrayada_web.models.ThemeColors
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.ms

val NavigationIconStyle = CssStyle {
    base {
        Modifier
            .color(ThemeColors.Primary.colorValue)
            .transition(
                Transition.of(property = "color", duration = 50.ms)
            )
    }
    hover {
        Modifier
            .color(ThemeColors.Secondary.colorValue)
    }
}

@Composable
fun NavigationIcon(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    size: IconSize? = null
) {
    FaCircle(
        style = if (selected) IconStyle.FILLED else IconStyle.OUTLINE,
        modifier = NavigationIconStyle.toModifier()
            .cursor(Cursor.Pointer)
            .then(modifier),
        size = size,
    )
}