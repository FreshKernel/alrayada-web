package net.freshplatform.alrayada_landing_page.components

import androidx.compose.runtime.*
import net.freshplatform.alrayada_landing_page.components.fa.FaArrowUp
import net.freshplatform.alrayada_landing_page.components.fa.IconSize
import net.freshplatform.alrayada_landing_page.models.ThemeColors
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions

val BackToTopButtonStyle by ComponentStyle {
    base {
        Modifier.rotate(a = 180.deg)
            .backgroundColor(ThemeColors.Primary.colorValue)
            .transition(
                CSSTransition(property = "rotate", duration = 200.ms),
                CSSTransition(property = "background-color", duration = 150.ms)
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