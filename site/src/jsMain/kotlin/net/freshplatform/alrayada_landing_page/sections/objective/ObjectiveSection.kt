package net.freshplatform.alrayada_landing_page.sections.objective

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_landing_page.components.core.MyImage
import net.freshplatform.alrayada_landing_page.models.ThemeColors
import net.freshplatform.alrayada_landing_page.sections.objective.components.ObjectiveCard
import net.freshplatform.alrayada_landing_page.sections.objective.models.Objective
import net.freshplatform.alrayada_landing_page.utils.constants.PublicRes
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px

@Composable
fun ObjectiveSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    ObjectiveContent()
}

@Composable
private fun ObjectiveContent() {

    val breakpoint = rememberBreakpoint()

    val containerMinHeight = (
            if (breakpoint >= Breakpoint.XL) 900
            else if (breakpoint == Breakpoint.LG) 1100
            else if (breakpoint == Breakpoint.MD) 1400
            else if (breakpoint == Breakpoint.SM) 1500
            else if (breakpoint == Breakpoint.ZERO) 2000
            else 2500
            ) + 400

    Box(
        modifier = Modifier
            .minHeight(containerMinHeight.px)
    ) {
        MyImage(
            src = PublicRes.Assets.Images.Labs.MEDICAL_LAB1,
            modifier = Modifier
                .fillMaxSize()
                .objectFit(ObjectFit.Cover),
            contentDescription = "Medical lab"
        )
        ObjectivesContainer(breakpoint = breakpoint)
    }
}

@Composable
private fun ObjectivesContainer(modifier: Modifier = Modifier, breakpoint: Breakpoint) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .backgroundColor(Color.Companion.argb(a = 0.5f, r = 0, g = 167, b = 142))
            .then(modifier),
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .minHeight(650.px)
                        .padding(32.px)
                        .borderRadius(
                            if (breakpoint >= Breakpoint.MD) 180.px
                            else 50.px
                        )
                        .backgroundColor(Colors.White),
                    contentAlignment = Alignment.Center
                ) {
                    Objectives(breakpoint = breakpoint)
                }
            }
        }
    }
}

@Composable
private fun Objectives(modifier: Modifier = Modifier, breakpoint: Breakpoint) {
    Column(
        modifier = Modifier.fillMaxSize().then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val objectives = Objective.entries
        objectives.forEach { objective ->
            val isLast = objective == objectives.last()
            ObjectiveCard(
                objective = objective,
                breakpoint = breakpoint
            )
            if (!isLast) {
                HorizontalDivider(
                    modifier = Modifier
                        .height(4.px)
                        .width(100.px)
                        .margin(topBottom = 14.px)
                        .backgroundColor(ThemeColors.Primary.colorValue)
                        .borderRadius(r = 8.px)
                )
            }
        }
    }
}