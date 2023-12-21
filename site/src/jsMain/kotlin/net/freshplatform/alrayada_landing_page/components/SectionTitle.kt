package net.freshplatform.alrayada_landing_page.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import net.freshplatform.alrayada_landing_page.core.services.localization.stringResource
import net.freshplatform.alrayada_landing_page.models.HomePageSections
import net.freshplatform.alrayada_landing_page.models.ThemeColors
import net.freshplatform.alrayada_landing_page.utils.ObserveViewportEntered
import net.freshplatform.alrayada_landing_page.utils.constants.Constants
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    section: HomePageSections,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    val scope = rememberCoroutineScope()
    var titleMargin by remember { mutableStateOf(50) }
    var subtitleMargin by remember { mutableStateOf(50) }

    if (Constants.ANIMATION_ENABLED) {
        ObserveViewportEntered(
            sectionId = section.id,
            distanceFromTop = 600.0,
        ) {
            scope.launch {
                subtitleMargin = 0

                if (alignment == Alignment.Start) {
                    delay(25)
                }
                titleMargin = 0
            }
        }
    }

    val textAlign = when (alignment) {
        Alignment.CenterHorizontally -> TextAlign.Center
        Alignment.End -> TextAlign.End
        else -> TextAlign.Start
    }
    Column(modifier = modifier, horizontalAlignment = alignment) {
        ParagraphText(
            stringResource(section.titleRes),
            modifier = Modifier
                .textAlign(textAlign)
                .margin(
                    left = if (Constants.ANIMATION_ENABLED) titleMargin.px else 0.px,
                    top = 0.px,
                    bottom = 0.px
                )
                .transition(
                    CSSTransition(property = "margin", duration = 300.ms)
                ),
            fontSize = 25.px,
            color = ThemeColors.Primary.colorValue
        )
        ParagraphText(
            stringResource(section.subtitleRes),
            modifier = Modifier
                .textAlign(textAlign)
                .margin(
                    left = if (Constants.ANIMATION_ENABLED)
                        if (alignment == Alignment.Start) subtitleMargin.px else 0.px
                    else 0.px,
                    right = if (Constants.ANIMATION_ENABLED)
                        if (alignment == Alignment.CenterHorizontally) subtitleMargin.px else 0.px
                    else 0.px,
                    bottom = 10.px,
                    top = 0.px
                )
                .transition(
                    CSSTransition(property = "margin", duration = 300.ms)
                )
                .fontWeight(FontWeight.Bold),
            fontSize = 35.px,
        )
        LineStroke()
    }
}

@Composable
fun ParagraphText(
    value: String,
    modifier: Modifier = Modifier,
    fontSize: CSSLengthOrPercentageNumericValue = 18.px,
    color: CSSColorValue = ThemeColors.Secondary.colorValue,
) {
    if (value.isBlank()) {
        Div(
            attrs = Modifier.then(modifier).toAttrs()
        )
        return
    }
    P(
        attrs = Modifier
            .fontSize(fontSize)
            .fontWeight(FontWeight.Normal)
            .color(color)
            .then(modifier)
            .toAttrs()
    ) {
        Text(value)
    }
}