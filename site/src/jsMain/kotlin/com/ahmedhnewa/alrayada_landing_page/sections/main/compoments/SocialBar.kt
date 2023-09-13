package com.ahmedhnewa.alrayada_landing_page.sections.main.compoments

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.models.SocialMediaLink
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.FaIcon
import com.varabyte.kobweb.silk.components.icons.fa.IconCategory
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.varabyte.kobweb.compose.foundation.layout.Row
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

@Composable
fun SocialBar(modifier: Modifier = Modifier, isRow: Boolean = false) {
    val sharedModifier = Modifier.borderRadius(r = 20.px)
        .backgroundColor(Colors.White)
    if (isRow) {
        Row(
            modifier = Modifier
                .margin(top = 25.px)
                .padding(leftRight = 25.px)
                .minHeight(40.px)
                .then(sharedModifier)
                .then(modifier),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialMediaLink.entries.forEach {
                SocialLink(it, true)
            }
        }
        return
    }
    Column(
        modifier = Modifier
            .margin(right = 25.px)
            .padding(topBottom = 25.px)
            .minWidth(40.px)
            .then(sharedModifier)
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SocialMediaLink.entries.forEach {
            SocialLink(it, false)
        }
    }
}

val SocialLinkItemStyle by ComponentStyle {
    base {
        Modifier.color(ThemeColors.Gray.colorValue)
            .transition(
                CSSTransition(
                    property = "color",
                    duration = 200.ms
                )
            )
    }
    hover {
        Modifier.color(ThemeColors.Primary.colorValue)
    }
}

@Composable
private fun SocialLink(socialMediaLink: SocialMediaLink, row: Boolean) {
    Link(
        path = socialMediaLink.path,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        val isLastOne = socialMediaLink == SocialMediaLink.entries.last()
        FaIcon(
            modifier = SocialLinkItemStyle.toModifier()
                .margin(
                    bottom = if (isLastOne) 0.px else if (row) 0.px else 40.px,
                    right = if (isLastOne) 0.px else if (row) 40.px else 0.px
                ),
            size = IconSize.LG,
            style = IconCategory.BRAND,
            name = socialMediaLink.iconName,
        )
    }
}