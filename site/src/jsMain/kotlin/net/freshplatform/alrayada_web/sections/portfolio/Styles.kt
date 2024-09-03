package net.freshplatform.alrayada_web.sections.portfolio

import net.freshplatform.alrayada_web.models.ThemeColors
import net.freshplatform.alrayada_web.sections.portfolio.components.PORTFOLIO_CARD_HEIGHT
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val PortfolioSectionStyle = CssStyle {
    /* Start of greenOverlay */
    cssRule(" > #columnParent > #imageBox > #greenOverlay") {
        Modifier.width(0.px)
            .transition(
                Transition.of(property = "width", duration = 350.ms, timingFunction = null, delay = null)
            )
    }

    cssRule(":hover > #columnParent > #imageBox > #greenOverlay") {
        Modifier.width(PORTFOLIO_CARD_HEIGHT.px)
    }
    /* End of greenOverlay */

    /* Start of linkIcon */

    cssRule(" > #columnParent > #imageBox > #greenOverlay > #linkIcon") {
        val duration = 150.ms
        Modifier.visibility(Visibility.Hidden)
            .opacity(0.percent)
            .transition(
                Transition.of(property = "visibility", duration = duration, timingFunction = null, delay = null),
                Transition.of(property = "opacity", duration = duration, timingFunction = null, delay = null),
            )
    }

    cssRule(":hover > #columnParent > #imageBox > #greenOverlay > #linkIcon") {
        Modifier.visibility(Visibility.Visible)
            .opacity(100.percent)
    }

    /* End of linkIcon */

    /* Start of portfolioTitle */

    cssRule(" > #columnParent > #portfolioTitle") {
        Modifier
            .color(ThemeColors.Secondary.colorValue)
            .translateX(0.percent)
            .transition(
                Transition.of(property = "color", duration = 200.ms, timingFunction = null, delay = null),
                Transition.of(property = "translate", duration = 200.ms, timingFunction = null, delay = null),
            )
    }

    cssRule(":hover > #columnParent > #portfolioTitle") {
        Modifier
            .color(ThemeColors.Primary.colorValue)
            .translateX(5.percent)
    }

    /* End of portfolioTitle */

    /* Start of portfolioDesc */

    cssRule(" > #columnParent > #portfolioDesc") {
        Modifier
            .translateX(0.percent)
            .transition(Transition.of(property = "translate", duration = 200.ms, timingFunction = null, delay = null))
    }

    cssRule(":hover > #columnParent > #portfolioDesc") {
        Modifier
            .translateX(5.percent)
    }

    /* End of portfolioDesc */
}

val PortfolioArrowIconStyle = CssStyle {
    base {
        Modifier
            .color(ThemeColors.Gray.colorValue)
            .transition(Transition.of(property = "color", duration = 100.ms, timingFunction = null, delay = null))
    }
    hover {
        Modifier.color(ThemeColors.Primary.colorValue)
    }
}
