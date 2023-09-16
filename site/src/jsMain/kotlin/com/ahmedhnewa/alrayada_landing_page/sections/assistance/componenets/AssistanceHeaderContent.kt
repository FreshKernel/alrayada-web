package com.ahmedhnewa.alrayada_landing_page.sections.assistance.componenets

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.SectionTitle
import com.ahmedhnewa.alrayada_landing_page.components.core.MyImage
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.models.AppSection
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.ahmedhnewa.alrayada_landing_page.utils.constants.PublicRes
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AssistanceHeaderContent() {
    val breakpoint = rememberBreakpoint()

    if (breakpoint > Breakpoint.LG) {
        Box(
            modifier = Modifier
                .height(600.px)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                MyImage(
                    src = PublicRes.Assets.Images.Labs.MEDICAL_LAB2,
                    contentDescription = "Medical lab",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(59.percent)
                        .borderRadius(
                            topLeft = 20.px,
                            topRight = 200.px,
                        )
                        .objectFit(ObjectFit.Cover)
                )
                MyImage(
                    src = PublicRes.Assets.Svg.Waves.WAVE_5,
                    contentDescription = "Wave",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .objectFit(ObjectFit.Cover)
//                        .border(width = 2.px, color = ThemeColors.Primary.colorValue, style = LineStyle.Solid)
                )
            }

            AssistanceLargeTitle(
                modifier = Modifier.align(Alignment.Center),
                breakpoint = breakpoint
            )
        }
        return
    }

    SectionTitle(
        section = AppSection.Assistance,
        alignment = Alignment.CenterHorizontally
    )
}

@Composable
private fun AssistanceLargeTitle(
    modifier: Modifier = Modifier,
    breakpoint: Breakpoint
) {
    Box(
        modifier = Modifier
            .size(
                if (breakpoint < Breakpoint.SM) 150.px
                else 180.px
            )
            .backgroundColor(Colors.White)
            .borderRadius(r = 100.px)
            .padding(8.px)
            .border(
                width = 4.px,
                style = LineStyle.Dashed,
                color = ThemeColors.Primary.colorValue,
            )
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        P(
            attrs = Modifier
                .textAlign(TextAlign.Center)
                .margin(topBottom = 0.px)
                .lineHeight(1.2)
                .fontWeight(FontWeight.Bold)
                .toAttrs()
        ) {
            Text(stringResource(StringRes.TechnicalServicesAndAfterSalesSupport))
        }
    }
}