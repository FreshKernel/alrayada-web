package com.ahmedhnewa.alrayada_landing_page.sections.quality_policy.componenets

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.core.CenterHorizontally
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.ahmedhnewa.alrayada_landing_page.sections.quality_policy.models.QualityPolicy
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun QualityPolicyCard(
    modifier: Modifier = Modifier,
    qualityPolicy: QualityPolicy,
    isFirst: Boolean,
    isLast: Boolean,
    shouldUseBorderRadius: Boolean,
    responsiveBreakpoint: Breakpoint
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .minHeight(350.px) // make sure we used SimpleGrid instead of Row to make the height the same for all items
            .backgroundColor(ThemeColors.Primary.colorValue)
            .borderRadius(
                topLeft = if (isFirst) 20.px else 0.px,
                bottomLeft = if (isFirst && shouldUseBorderRadius) 20.px else 0.px,
                topRight = if (isLast && shouldUseBorderRadius) 20.px else 0.px,
                bottomRight = if (isLast) 20.px else 0.px
            )
            .then(modifier)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CenterHorizontally(
                modifier = Modifier.margin(top = 25.px)
            ) {
                Box(
                    modifier = Modifier
                        .size(150.px)
                        .backgroundColor(ThemeColors.Primary.colorValue)
                        .borderRadius(r = 40.px)
                        .border(width = 10.px, style = LineStyle.Solid, color = Colors.White),
                    contentAlignment = Alignment.Center
                ) {
                    P(
                        attrs = Modifier
                            .fillMaxWidth()
                            .margin(topBottom = 0.px)
                            .fontSize(40.px)
                            .textAlign(TextAlign.Center)
                            .fontWeight(FontWeight.Bold)
                            .color(Colors.White)
                            .toAttrs()
                    ) {
                        Text(qualityPolicy.number)
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
//                    .fillMaxHeight()
            ) {
                P(
                    attrs = Modifier
                        .fillMaxWidth(90.percent)
                        .margin(topBottom = 0.px)
                        .fontSize(20.px)
                        .padding(24.px)
                        .fontWeight(FontWeight.Normal)
                        .lineHeight(1.5)
                        .color(Colors.White)
                        .margin(top = 20.px)
                        .toAttrs()
                ) {
                    Text(stringResource(qualityPolicy.descRes))
                }
                if (!isLast) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight(),
                        contentAlignment = Alignment.TopStart
                    ) {
                        Box(
                            modifier = Modifier
                                .displayIfAtLeast(responsiveBreakpoint)
                                .backgroundColor(Color("#6B6663"))
                                .height(150.px)
//                                .alignSelf(AlignSelf.Center)
                                .width(5.px)
                        )
                    }
                }
            }
            if (!isLast) {
                CenterHorizontally {
                    Box(
                        modifier = Modifier
                            .displayIfAtLeast(Breakpoint.SM) // for mobile screens
                            .displayUntil(responsiveBreakpoint)
                            .backgroundColor(Color("#6B6663"))
                            .height(5.px)
                            .width(200.px)
                    )
                }
            }
        }
    }
}