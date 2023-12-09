package net.freshplatform.alrayada_landing_page.sections.portfolio

import net.freshplatform.alrayada_landing_page.models.ThemeColors
import net.freshplatform.alrayada_landing_page.sections.portfolio.components.PORTFOLIO_CARD_HEIGHT
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val PortfolioSectionStyle by ComponentStyle {
    /* Start of greenOverlay */
    cssRule(" > #columnParent > #imageBox > #greenOverlay") {
        Modifier.width(0.px)
            .transition(
                CSSTransition(property = "width", duration = 350.ms)
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
                CSSTransition(property = "visibility", duration = duration),
                CSSTransition(property = "opacity", duration = duration),
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
                CSSTransition(property = "color", duration = 200.ms),
                CSSTransition(property = "translate", duration = 200.ms),
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
            .transition(CSSTransition(property = "translate", duration = 200.ms))
    }

    cssRule(":hover > #columnParent > #portfolioDesc") {
        Modifier
            .translateX(5.percent)
    }

    /* End of portfolioDesc */
}

val PortfolioArrowIconStyle by ComponentStyle {
    base {
        Modifier
            .color(ThemeColors.Gray.colorValue)
            .transition(CSSTransition(property = "color", duration = 100.ms))
    }
    hover {
        Modifier.color(ThemeColors.Primary.colorValue)
    }
}
