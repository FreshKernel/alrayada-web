package net.freshplatform.alrayada_web.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.bottom
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.document
import kotlinx.browser.window
import net.freshplatform.alrayada_web.components.fa.FaArrowUp
import net.freshplatform.alrayada_web.components.fa.IconSize
import net.freshplatform.alrayada_web.models.ThemeColors
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions

val BackToTopButtonStyle = CssStyle {
    base {
        Modifier.rotate(a = 180.deg)
            .backgroundColor(ThemeColors.Primary.colorValue)
            .transition(
                Transition.of(property = "rotate", duration = 200.ms),
                Transition.of(property = "background-color", duration = 150.ms)
            )
    }
    hover {
        Modifier.rotate(a = 0.deg)
            .backgroundColor(ThemeColors.Secondary.colorValue)
    }
}

@Composable
fun BackToTopButton() {
    var scrollTop: Double? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        window.addEventListener(type = "scroll", callback = {
            scrollTop = document.documentElement?.scrollTop ?: 0.0
        })
    }

    val shouldVisible = (scrollTop ?: 0.0) > 500

    Span(
        attrs = BackToTopButtonStyle
            .toModifier()
            .position(Position.Fixed)
            .styleModifier {
                property("transition", "0.1s")
            }
            .bottom(15.px)
            .right(if (shouldVisible) 20.px else (-55).px)
            .fontWeight(FontWeight.Bold)
            .fontSize(14.px)
            .padding(20.px)
            .cursor(Cursor.Pointer)
            .borderRadius(20.percent)
            .onClick {
                window.scrollTo(
                    options = ScrollToOptions(
                        top = 0.0,
                        behavior = ScrollBehavior.SMOOTH
                    )
                )
            }
            .toAttrs()
    ) {
        FaArrowUp(
            modifier = Modifier.color(Colors.White),
            size = IconSize.LG
        )
    }

}