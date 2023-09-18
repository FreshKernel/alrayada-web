package com.ahmedhnewa.alrayada_landing_page.sections.main.compoments

import androidx.compose.runtime.*
import com.ahmedhnewa.alrayada_landing_page.components.AppLogo
import com.ahmedhnewa.alrayada_landing_page.components.fa.FaIcon
import com.ahmedhnewa.alrayada_landing_page.components.fa.IconCategory
import com.ahmedhnewa.alrayada_landing_page.components.fa.IconSize
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.models.HomePageSections
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayBetween
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Nav

val NavigationItemStyle by ComponentStyle {
    base {
        Modifier.color(ThemeColors.Secondary.colorValue)
            .transition(
                CSSTransition(property = "color", duration = 150.ms),
                CSSTransition(property = "scale", duration = 200.ms),
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

val BrandingLogoStyle by ComponentStyle {
    base {
        Modifier.transition(
            CSSTransition(property = "scale", duration = 200.ms)
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
            .then(modifier),
        horizontalArrangement = Arrangement.End
    ) {
        NavigationLinks()
    }
}

@Composable
fun NavigationLinks(eachItemModifier: Modifier = Modifier) {
    HomePageSections.navigationItems.forEach { section ->
        val text = stringResource(section.titleRes)
        Link(
            path = section.path,
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