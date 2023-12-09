package net.freshplatform.alrayada_landing_page.components

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_landing_page.components.fa.FaCircle
import net.freshplatform.alrayada_landing_page.components.fa.IconSize
import net.freshplatform.alrayada_landing_page.components.fa.IconStyle
import net.freshplatform.alrayada_landing_page.models.ThemeColors
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.ms

val NavigationIconStyle by ComponentStyle {
    base {
        Modifier
            .color(ThemeColors.Primary.colorValue)
            .transition(
                CSSTransition(property = "color", duration = 50.ms)
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