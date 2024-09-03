package net.freshplatform.alrayada_web.sections.objective.components

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.core.services.localization.stringResource
import net.freshplatform.alrayada_web.models.ThemeColors
import net.freshplatform.alrayada_web.sections.objective.models.Objective
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val ObjectiveCardStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(ThemeColors.Primary.colorValue)
            .color(Colors.White)
            .styleModifier {
                property("box-shadow", "rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px")
            }
            .transition(
                Transition.of(
                    property = "background-color",
                    duration = 150.ms,
                ),
                Transition.of(
                    property = "box-shadow",
                    duration = 100.ms,
                ),
                Transition.of(
                    property = "color",
                    duration = 50.ms,
                ),
            )
    }
    hover {
        Modifier
//            .color(Colors.DarkGray)
            .backgroundColor(ThemeColors.Secondary.colorValue)
            .styleModifier {
                property("box-shadow", "rgba(0, 0, 0, 0.35) 0px 5px 15px")
            }
    }
}

@Composable
fun ObjectiveCard(modifier: Modifier = Modifier, objective: Objective, breakpoint: Breakpoint) {
    Column(
        modifier = ObjectiveCardStyle
            .toModifier()
            .minHeight(50.px)
            .padding(16.px)
            .fillMaxWidth(
                if (breakpoint > Breakpoint.MD) 30.percent
                else if (breakpoint >= Breakpoint.MD) 40.percent
                else 90.percent
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
//                .color(Colors.White)
                .textAlign(TextAlign.Center)
                .toAttrs()
        ) {
            Text(stringResource(objective.titleRes))
        }

        HorizontalDivider(
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
//                .color(Colors.White)
                .lineHeight(1.6)
                .toAttrs()
        ) {
            Text(stringResource(objective.descRes))
        }
    }
}