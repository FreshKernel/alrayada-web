package net.freshplatform.alrayada_web.sections.experience.componenets

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.models.ThemeColors
import net.freshplatform.alrayada_web.sections.experience.models.Experience
import net.freshplatform.alrayada_web.utils.constants.Constants
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(
    modifier: Modifier = Modifier,
    isActive: Boolean = false,
    experience: Experience,
    breakpoint: Breakpoint,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    SimpleGrid(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(
                if (breakpoint >= Breakpoint.MD) 60.percent // also from the SectionTitle
                else 90.percent
            )
            .then(modifier),
        numColumns = numColumns(
            base = 1,
            md = 2
        )
    ) {
        ExperienceDescriptionCard(
            isActive = isActive,
            description = experience.description
        )
        ExperienceSecondPart(
            isActive = isActive,
            experience = experience,
            breakpoint = breakpoint,
            animatedMargin = animatedMargin
        )
    }
}

@Composable
private fun ExperienceDescriptionCard(
    modifier: Modifier = Modifier,
    isActive: Boolean,
    description: String
) = Box(
    modifier = Modifier
        .fillMaxWidth()
        .margin(topBottom = 14.px)
        .padding(all = 14.px)
        .backgroundColor(
            if (isActive) ThemeColors.Primary.colorValue
            else ThemeColors.LighterGray.colorValue
        )
        .borderRadius(r = 4.px)
        .then(modifier)
) {
    P(
        attrs = Modifier
            .margin(topBottom = 0.px)
            .fontSize(14.px)
            .fontWeight(FontWeight.Normal)
            .lineHeight(1.6)
            .color(
                if (isActive) Colors.White
                else ThemeColors.Secondary.colorValue
            )
            .toAttrs()
    ) {
        Text(description)
    }
}

@Composable
private fun ExperienceSecondPart(
    modifier: Modifier = Modifier,
    isActive: Boolean,
    experience: Experience,
    breakpoint: Breakpoint,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .margin(
            left = if (breakpoint >= Breakpoint.MD) 14.px
            else 0.px
        )
        .then(modifier),
    verticalAlignment = Alignment.CenterVertically
) {
    ExperienceNumber(
        modifier = Modifier.displayIfAtLeast(Breakpoint.MD),
        number = experience.number,
        isActive = isActive
    )
    ExperienceDetails(
        modifier = Modifier
            .margin(
                left = if (breakpoint >= Breakpoint.MD)
                    if (Constants.ANIMATION_ENABLED) animatedMargin
                    else 50.px
                else 0.px
            )
            .transition(
                CSSTransition(
                    property = "margin",
                    duration = 500.ms,
                    delay = experience.ordinal * 80.ms
                )
            ),
        experience = experience
    )
}

@Composable
private fun ExperienceNumber(
    modifier: Modifier = Modifier,
    number: String,
    isActive: Boolean,
) = Box(
    modifier = Modifier
        .margin(left = 14.px)
        .fillMaxHeight()
        .then(modifier),
    contentAlignment = Alignment.Center
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(3.px)
            .backgroundColor(ThemeColors.Primary.colorValue),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(40.px)
                .backgroundColor(
                    if (isActive) ThemeColors.Primary.colorValue
                    else Colors.White
                )
                .border(
                    width = 3.px,
                    style = LineStyle.Solid,
                    color = ThemeColors.Primary.colorValue
                )
                .borderRadius(50.percent),
            contentAlignment = Alignment.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Bold)
                    .color(
                        if (isActive) Colors.White
                        else ThemeColors.Primary.colorValue
                    )
                    .toAttrs()
            ) {
                Text(number)
            }
        }
    }
}

@Composable
private fun ExperienceDetails(
    modifier: Modifier = Modifier,
    experience: Experience
) = Column(
    modifier = Modifier.fillMaxSize()
        .then(modifier),
    verticalArrangement = Arrangement.Center
) {
    P(
        attrs = Modifier
            .margin(topBottom = 0.px)
            .fontSize(20.px)
            .fontWeight(FontWeight.Bold)
            .color(ThemeColors.Secondary.colorValue)
            .toAttrs()
    ) {
        Text(experience.jobPosition)
    }
    P(
        attrs = Modifier
            .margin(topBottom = 0.px)
            .fontSize(14.px)
            .fontWeight(FontWeight.Normal)
            .color(ThemeColors.Secondary.colorValue)
            .toAttrs()
    ) {
        Text("${experience.from} - ${experience.to}")
    }
    P(
        attrs = Modifier
            .margin(topBottom = 0.px)
            .fontSize(14.px)
            .fontWeight(FontWeight.Normal)
            .color(ThemeColors.Primary.colorValue)
            .toAttrs()
    ) {
        Text(experience.company)
    }
}