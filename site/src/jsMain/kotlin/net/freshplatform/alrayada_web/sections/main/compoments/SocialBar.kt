package net.freshplatform.alrayada_web.sections.main.compoments

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.fa.FaIcon
import net.freshplatform.alrayada_web.components.fa.IconCategory
import net.freshplatform.alrayada_web.components.fa.IconSize
import net.freshplatform.alrayada_web.models.SocialMediaLink
import net.freshplatform.alrayada_web.models.ThemeColors
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
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

val SocialLinkItemStyle = CssStyle {
    base {
        Modifier
            .color(Color("#999999"))
//            .fontSize(25.px)
            .transition(
                Transition.of(
                    property = "color",
                    duration = 100.ms,
                    timingFunction = null, delay = null
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
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
        modifier = Modifier
            .title(socialMediaLink.name)
    ) {
        val isLastOne = socialMediaLink == SocialMediaLink.entries.last()
        FaIcon(
            modifier = SocialLinkItemStyle
                .toModifier()
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