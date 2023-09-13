package com.ahmedhnewa.alrayada_landing_page.sections.objective.components

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.ahmedhnewa.alrayada_landing_page.sections.objective.models.Objective
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.Divider
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ObjectiveCard(modifier: Modifier = Modifier, objective: Objective, breakpoint: Breakpoint) {
    Column(
        modifier = Modifier
            .minHeight(50.px)
            .padding(16.px)
            .backgroundColor(ThemeColors.Primary.colorValue)
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 30.percent
                else 50.percent
            )
            .borderRadius(r = 8.px)
            .then(modifier)
    ) {
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontSize(24.px)
                .fontWeight(FontWeight.Bold)
                .color(Colors.White)
                .textAlign(TextAlign.Center)
                .toAttrs()
        ) {
            Text(stringResource(objective.titleRes))
        }

        Divider(
            modifier = Modifier
                .height(4.px)
                .width(120.px)
                .backgroundColor(Colors.White)
                .borderRadius(r = 8.px)
        )

        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontSize(14.px)
                .fontWeight(FontWeight.Normal)
                .color(Colors.White)
                .lineHeight(1.6)
                .toAttrs()
        ) {
            Text(stringResource(objective.descRes))
        }
    }
}