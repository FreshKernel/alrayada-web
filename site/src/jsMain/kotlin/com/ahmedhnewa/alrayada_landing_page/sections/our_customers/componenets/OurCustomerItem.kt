package com.ahmedhnewa.alrayada_landing_page.sections.our_customers.componenets

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.core.CenterHorizontally
import com.ahmedhnewa.alrayada_landing_page.components.fa.FaIcon
import com.ahmedhnewa.alrayada_landing_page.components.fa.IconCategory
import com.ahmedhnewa.alrayada_landing_page.components.fa.IconSize
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.ahmedhnewa.alrayada_landing_page.sections.our_customers.models.OurCustomer
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun OurCustomerItem(
    modifier: Modifier = Modifier,
    ourCustomer: OurCustomer
) {
    Column(
        modifier = Modifier
            .minHeight(300.px)
            .maxWidth(250.px)
            .padding(8.px)
            .then(modifier)
    ) {
        ImageBox(
            ourCustomer = ourCustomer,
            modifier = Modifier
                .margin(bottom = 12.px)
        )
        CenterHorizontally {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontSize(22.px)
                    .color(ThemeColors.GoldenOlive.colorValue)
                    .fontWeight(FontWeight.Normal)
                    .lineHeight(1.4)
                    .textAlign(TextAlign.Center)
                    .toAttrs()
            ) {
                Text(stringResource(ourCustomer.title))
            }
        }
    }
}

@Composable
private fun ImageBox(
    modifier: Modifier = Modifier,
    ourCustomer: OurCustomer
) {
    val sharedModifier = Modifier
        .borderRadius(r = 100.px)
    Box(
        modifier = Modifier
            .border(
                width = 3.px,
                color = ThemeColors.Primary.colorValue,
                style = LineStyle.Solid
            )
            .then(sharedModifier)
            .padding(6.px)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .border(
                    width = 2.px,
                    color = ThemeColors.GoldenOlive.colorValue,
                    style = LineStyle.Solid
                )
                .then(sharedModifier)
                .padding(64.px)
        ) {
            FaIcon(
                name = ourCustomer.icon,
                size = IconSize.X3,
                style = IconCategory.SOLID,
                modifier = Modifier
                    .color(ThemeColors.Primary.colorValue)
                    .fillMaxSize()
            )
        }
    }
}