package com.ahmedhnewa.alrayada_landing_page.sections.mobile_app.componenets

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.fa.FaIcon
import com.ahmedhnewa.alrayada_landing_page.components.fa.IconCategory
import com.ahmedhnewa.alrayada_landing_page.components.fa.IconSize
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.ahmedhnewa.alrayada_landing_page.sections.mobile_app.models.MobileApp
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val DownloadMobileAppButtonStyle by ComponentStyle {
    base {
        Modifier
            .color(Colors.Black)
            .transition(
                CSSTransition(
                    property = "background-color",
                    duration = 200.ms
                ),
                CSSTransition(
                    property = "color",
                    duration = 200.ms
                ),
            )
    }
    hover {
        Modifier
            .backgroundColor(Colors.Black)
            .color(ThemeColors.Primary.colorValue)
    }
}

@Composable
fun DownloadMobileAppButton(
    modifier: Modifier = Modifier,
    mobileApp: MobileApp
) {
    Link(
        modifier = Modifier
            .width(220.px)
            .height(65.px)
            .textDecorationLine(TextDecorationLine.None)
            .title(mobileApp.title)
                then (modifier),
        path = mobileApp.downloadLink,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Row(
            modifier = DownloadMobileAppButtonStyle
                .toModifier()
                .borderRadius(r = 20.px)
                .border(width = 1.px, LineStyle.Solid, Color("#EDEDED"))

                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaIcon(
                name = mobileApp.iconName,
                style = IconCategory.BRAND,
                modifier = Modifier
//                    .fontSize(26.px)
                    .margin(left = 16.px, right = 8.px),
                size = IconSize.X2
            )
            Column {
                P(
                    attrs = Modifier
                        .fillMaxWidth()
                        .margin(topBottom = 0.px)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Bold)
                        .toAttrs()
                ) {
                    Text(mobileApp.title)
                }
                Text(mobileApp.subtitle)
            }
        }
    }
}