package net.freshplatform.alrayada_web.styles

import net.freshplatform.alrayada_web.models.ThemeColors
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val MainButtonStyle = CssStyle {
    base {
        Modifier.width(100.px)
            .height(40.px)
            .border(width = 0.px)
            .borderRadius(5.px)
            .backgroundColor(ThemeColors.Primary.colorValue)
            .color(Colors.White)
            .cursor(Cursor.Pointer)
            .transition(
                Transition.of(property = "width", duration = 200.ms),
                Transition.of(property = "background-color", duration = 200.ms),
            )
    }
    hover {
        Modifier
            .width(120.px)
            .backgroundColor(ThemeColors.OnPrimary.colorValue)
    }

}