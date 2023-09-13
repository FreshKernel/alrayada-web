package com.ahmedhnewa.alrayada_landing_page.sections.service.components

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.ahmedhnewa.alrayada_landing_page.sections.service.ServiceCardStyle
import com.ahmedhnewa.alrayada_landing_page.sections.service.models.Service
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaIcon
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServiceCard(modifier: Modifier = Modifier, service: Service) {
    Column(
        modifier = ServiceCardStyle.toModifier()
            .maxWidth(300.px)
            .margin(all = 20.px)
            .padding(all = 20.px)
            .then(modifier)
    ) {
        Box(
            modifier = Modifier
                .id("iconBox")
                .padding(all = 10.px)
                .margin(bottom = 20.px)
                .border(width = 2.px, style = LineStyle.Solid, color = ThemeColors.Primary.colorValue)
                .borderRadius(
                    topLeft = 20.px,
                    topRight = 20.px,
                    bottomLeft = 20.px,
                    bottomRight = 0.px
                )
        ) {
            FaIcon(
                name = service.icon,
                modifier = Modifier
                    .title(service.iconDesc)
                    .color(ThemeColors.Primary.colorValue)
                    .attrsModifier {
                        attr("alt", service.iconDesc)
                    },
                style = service.iconCategory,
                size = IconSize.X2
            )
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(bottom = 10.px, top = 0.px)
                .fontSize(18.px)
                .fontWeight(FontWeight.Bold)
                .toAttrs()
        ) {
            Text(stringResource(service.titleRes))
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontSize(14.px)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            Text(stringResource(service.descriptionRes))
        }
    }
}