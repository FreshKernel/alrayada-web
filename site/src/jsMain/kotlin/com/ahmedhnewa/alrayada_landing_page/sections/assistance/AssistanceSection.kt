package com.ahmedhnewa.alrayada_landing_page.sections.assistance

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.sections.assistance.componenets.AssistanceHeaderContent
import com.ahmedhnewa.alrayada_landing_page.styles.ReadableTextStyleOnWhiteBackground
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AssistanceSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    AssistanceContent()
}

@Composable
private fun AssistanceContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AssistanceHeaderContent()
        AssistanceDescText()
    }
}

@Composable
private fun AssistanceDescText() {
    P(
        attrs = ReadableTextStyleOnWhiteBackground
            .toModifier()
            .textAlign(TextAlign.Center)
            .margin(topBottom = 0.px)
            .fillMaxWidth(60.percent)
            .lineHeight(1.6)
            .margin(top = 100.px)
            .toAttrs()
    ) {
        Text(stringResource(StringRes.AssistanceSectionDesc))
    }
}