package net.freshplatform.alrayada_web.sections.main.compoments

import androidx.compose.runtime.*
import net.freshplatform.alrayada_web.components.AppLogo
import net.freshplatform.alrayada_web.components.fa.FaIcon
import net.freshplatform.alrayada_web.components.fa.IconCategory
import net.freshplatform.alrayada_web.components.fa.IconSize
import net.freshplatform.alrayada_web.core.services.localization.stringResource
import net.freshplatform.alrayada_web.models.HomePageSections
import net.freshplatform.alrayada_web.models.ThemeColors
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.displayBetween
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.*
import com.varabyte.kobweb.silk.style.selectors.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Nav

val NavigationItemStyle = CssStyle {
    base {
        Modifier.color(ThemeColors.Secondary.colorValue)
            .transition(
                Transition.of(property = "color", duration = 200.ms, timingFunction = null, delay = null),
                Transition.of(property = "scale", duration = 200.ms, timingFunction = null, delay = null),
//                CSSTransition(property = "rotate", duration = 200.ms)
            )
    }
    anyLink {
        Modifier.color(ThemeColors.Secondary.colorValue)
            .scale(1)
//            .rotate(0.deg)
    }
    hover {
        Modifier.color(ThemeColors.Primary.colorValue)
            .scale(1.2)
//            .rotate((3).deg)
    }
}

val BrandingLogoStyle = CssStyle {
    base {
        Modifier.transition(
            Transition.of(property = "scale", duration = 200.ms, timingFunction = null, delay = null)
        )
    }
    onlyChild {
        Modifier
            .scale(1)
    }
    hover {
        Modifier
            .scale(1.2)
    }
}

@Composable
fun MyHeader() {
    @Composable
    fun SharedContent() = Header {
        Row(
            modifier = Modifier.userSelect(UserSelect.None),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            StartSide()
            EndSide()
        }
    }

    val sharedModifier = Modifier
        .margin(topBottom = 50.px)
        .userSelect(UserSelect.None)
    Nav(
        attrs = Modifier.displayIfAtLeast(Breakpoint.LG).fillMaxWidth(80.percent)
            .then(sharedModifier)
            .toAttrs()
    ) {
        SharedContent()
    }
    Nav(
        attrs = Modifier.displayBetween(Breakpoint.SM, Breakpoint.LG).fillMaxWidth(90.percent)
            .then(sharedModifier)
            .toAttrs()
    ) {
        SharedContent()
    }
}

@Composable
private fun StartSide(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.then(modifier),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AppLogo(
            modifier = BrandingLogoStyle.toModifier(),
            lazyLoading = false
        )
    }
}

@Composable
private fun EndSide(
    modifier: Modifier = Modifier,
) {
    var isMenuOpened by remember { mutableStateOf(false) }
    FaIcon(
        modifier = Modifier.color(ThemeColors.Secondary.colorValue)
            .displayUntil(Breakpoint.LG)
            .userSelect(UserSelect.None)
            .margin(right = 15.px)
            .onClick {
                isMenuOpened = !isMenuOpened

                val homeSectionInTheHomePage = document.getElementById(HomePageSections.Home.id)
                    ?: throw NullPointerException("Can't find ${HomePageSections.Home.name}")
                val mobileNavigation = homeSectionInTheHomePage.querySelector("#mobileNavigationItems")
                    ?: throw NullPointerException("Can't find mobileNavigationItems")
                mobileNavigation.classList.toggle("hidden")
                mobileNavigation.classList.toggle("visible")
            },
        size = IconSize.XL,
        name = if (isMenuOpened) "caret-down" else "bars",
        style = IconCategory.SOLID
    )
    Row(
        modifier = Modifier.displayIfAtLeast(Breakpoint.LG)
            .fillMaxWidth()
            .borderRadius(r = 50.px)
            .backgroundColor(ThemeColors.LighterGray.colorValue)
            .padding(16.px)
//            .border(width = 2.px, style = LineStyle.Solid, color = ThemeColors.LighterGray.colorValue)
            .then(modifier),
        horizontalArrangement = Arrangement.End
    ) {
        NavigationLinks()
    }
}

@Composable
fun NavigationLinks(eachItemModifier: Modifier = Modifier) {
    HomePageSections.navigationItems.forEach { navigationLink ->
        val text = stringResource(navigationLink.titleRes)
        Link(
            path = navigationLink.path,
            text = text,
            modifier = NavigationItemStyle
                .toModifier()
                .padding(right = 30.px)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .title(text)
                .textDecorationLine(TextDecorationLine.None)
                .then(eachItemModifier),
        )
    }
}