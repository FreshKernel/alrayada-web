package net.freshplatform.alrayada_web.sections.portfolio.components

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.core.MyImage
import net.freshplatform.alrayada_web.components.fa.FaArrowUpRightFromSquare
import net.freshplatform.alrayada_web.components.fa.IconSize
import net.freshplatform.alrayada_web.models.ThemeColors
import net.freshplatform.alrayada_web.sections.portfolio.PortfolioSectionStyle
import net.freshplatform.alrayada_web.sections.portfolio.models.Portfolio
import net.freshplatform.alrayada_web.utils.extensions.maximumAtFirst
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

const val PORTFOLIO_CARD_HEIGHT = 300

@Composable
fun PortfolioCard(
    modifier: Modifier = Modifier,
    portfolio: Portfolio,
) {
    Link(
        modifier = PortfolioSectionStyle.toModifier()
            .textDecorationLine(TextDecorationLine.None)
            .title(portfolio.title)
            .userSelect(UserSelect.None),
        path = portfolio.link,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Column(
            modifier = Modifier
                .id("columnParent")
                .then(modifier)
        ) {
            ImageBox(portfolio = portfolio)
            P(
                attrs = Modifier
                    .id("portfolioTitle")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text(portfolio.title)
            }
            P(
                attrs = Modifier
                    .id("portfolioDesc")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(ThemeColors.Secondary.colorValue)
                    .opacity(50.percent)
                    .onClick {
                        window.alert(portfolio.description)
                    }
                    .toAttrs()
            ) {
                Text(portfolio.description.maximumAtFirst(100))
            }
        }
    }
}

@Composable
private fun ImageBox(portfolio: Portfolio) {
    Box(
        modifier = Modifier
            .id("imageBox")
            .margin(bottom = 20.px)
            .fillMaxWidth()
            .width(PORTFOLIO_CARD_HEIGHT.px)
    ) {
        val imageBorderRadius = 4.px
        MyImage(
            modifier = Modifier
                .borderRadius(r = imageBorderRadius)
                .size(PORTFOLIO_CARD_HEIGHT.px)
                .objectFit(ObjectFit.Cover),
            src = portfolio.image,
            contentDescription = portfolio.title
        )
        Box(
            modifier = Modifier
                .id("greenOverlay")
                .borderRadius(r = imageBorderRadius)
                .height(PORTFOLIO_CARD_HEIGHT.px)
                .backgroundColor(Color.Companion.argb(a = 0.5f, r = 0, g = 167, b = 142)),
            contentAlignment = Alignment.Center,
        ) {
            FaArrowUpRightFromSquare(
                modifier = Modifier
                    .id("linkIcon")
                    .title("Link icon")
                    .color(Colors.White)
                    .attrsModifier {
                        attr("alt", "Link icon")
                    },
                size = IconSize.X2
            )
        }
    }
}