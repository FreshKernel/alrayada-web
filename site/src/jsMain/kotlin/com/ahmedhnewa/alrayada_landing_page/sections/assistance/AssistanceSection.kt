package com.ahmedhnewa.alrayada_landing_page.sections.assistance

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.ahmedhnewa.alrayada_landing_page.sections.assistance.componenets.AssistanceHeaderContent
import com.ahmedhnewa.alrayada_landing_page.styles.ReadableTextStyleOnWhiteBackground
import com.ahmedhnewa.alrayada_landing_page.utils.constants.PublicRes
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.LineStyle
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
            .margin(top = 60.px)
            .fontWeight(FontWeight.Normal)
            .toAttrs()
    ) {
        Text(stringResource(StringRes.AssistanceSectionDesc))
    }
}