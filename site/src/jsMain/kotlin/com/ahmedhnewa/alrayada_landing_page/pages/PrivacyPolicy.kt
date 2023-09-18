package com.ahmedhnewa.alrayada_landing_page.pages

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.core.Center
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.core.router.AppRouter
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.styles.ReadableTextStyleOnWhiteBackground
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Page("/privacy-policy")
@Composable
fun PrivacyPolicyPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .backgroundColor(Color("#242B2E"))
    ) {
        Center {
            Box(
                modifier = Modifier
                    .backgroundColor(Colors.White)
                    .fillMaxWidth(95.percent)
                    .borderRadius(r = 20.px)
                    .minHeight(300.px),
            ) {
                Column(
                    modifier = Modifier
                        .padding(25.px)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    H1(
                        attrs = Modifier.fillMaxWidth()
                            .textAlign(TextAlign.Center)
                            .toAttrs()
                    ) {
                        Text(stringResource(StringRes.PrivacyPolicy))
                    }
                    P(
                        attrs = ReadableTextStyleOnWhiteBackground
                            .toModifier()
                            .fillMaxWidth()
                            .margin(topBottom = 0.px)
                            .fontSize(18.px)
                            .lineHeight(1.4)
                            .toAttrs()
                    ) {
                        Text(stringResource(StringRes.PrivacyPolicyText))
                    }
                }
            }
        }
    }
}