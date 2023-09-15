package com.ahmedhnewa.alrayada_landing_page.sections.about

import SkillBar
import androidx.compose.runtime.*
import com.ahmedhnewa.alrayada_landing_page.components.SectionTitle
import com.ahmedhnewa.alrayada_landing_page.components.core.MyImage
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.models.AppSection
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.ahmedhnewa.alrayada_landing_page.sections.about.models.Skill
import com.ahmedhnewa.alrayada_landing_page.utils.ObserveViewportEntered
import com.ahmedhnewa.alrayada_landing_page.utils.animateNumber
import com.ahmedhnewa.alrayada_landing_page.utils.constants.Constants
import com.ahmedhnewa.alrayada_landing_page.utils.constants.PublicRes
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection() = Box(
    modifier = Modifier.padding(topBottom = 150.px),
    contentAlignment = Alignment.Center
) {
    // Could be optimized
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent
        ).maxWidth(1200.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            numColumns = numColumns(base = 1, lg = 2),
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            )
        ) {
            AboutImage(modifier = Modifier.displayIfAtLeast(Breakpoint.LG))
            AboutMe()
        }
    }
}

@Composable
private fun AboutImage(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxWidth().then(modifier),
        contentAlignment = Alignment.Center
    ) {
        MyImage(
            modifier = AboutImageStyle
                .toModifier()
                .fillMaxWidth(80.percent),
            src = PublicRes.Assets.Images.ABOUT,
            contentDescription = "About Image"
        )
    }
}

@Composable
private fun AboutMe() {

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            appSection = AppSection.About,
            alignment = Alignment.CenterHorizontally
        )
        P(
            attrs = AboutTextStyle.toModifier()
                .margin(topBottom = 25.px)
                .maxWidth(500.px)
                .fontSize(15.px)
                .fontWeight(FontWeight.Normal)
                .lineHeight(1.4)
                .fontStyle(FontStyle.Italic)
                .color(ThemeColors.Secondary.colorValue)
                .toAttrs()
        ) {
            Text(stringResource(StringRes.AboutText))
        }
        AboutMeSkills()
    }
}

@Composable
private fun AboutMeSkills() {
    var viewportEntered by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
//    val animatedPercentages = remember { mutableStateOf(MutableList(Skills.values().size) { 0 }) }
    val animatedPercentages = remember { Skill.animationDefaultValues }

    if (Constants.ANIMATION_ENABLED) {
        ObserveViewportEntered(
            sectionId = AppSection.About.id,
            distanceFromTop = 600.0,
            onViewportEntered = {
                Skill.entries.forEach { skill ->
                    scope.launch {
                        animateNumber(
                            number = skill.percentageValue.value.toInt(),
                            delayTime = 7L,
                            onUpdate = {
                                animatedPercentages[skill.ordinal] = it
                            }
                        )
                    }
                }
                viewportEntered = true
            }
        )
    }

    Skill.entries.forEach { skill ->
        SkillBar(
            name = stringResource(skill.titleRes),
            index = skill.ordinal,
            percentageValueBar = if (Constants.ANIMATION_ENABLED)
                (if (viewportEntered) skill.percentageValue else 0.percent)
            else skill.percentageValue,
            animatedPercentageValueText = if (Constants.ANIMATION_ENABLED)
                (if (viewportEntered) animatedPercentages[skill.ordinal].percent else 0.percent)
            else skill.percentageValue
        )
    }
}