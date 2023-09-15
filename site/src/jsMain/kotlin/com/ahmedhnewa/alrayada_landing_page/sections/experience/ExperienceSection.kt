package com.ahmedhnewa.alrayada_landing_page.sections.experience

import androidx.compose.runtime.*
import com.ahmedhnewa.alrayada_landing_page.components.SectionTitle
import com.ahmedhnewa.alrayada_landing_page.models.AppSection
import com.ahmedhnewa.alrayada_landing_page.sections.experience.componenets.ExperienceCard
import com.ahmedhnewa.alrayada_landing_page.sections.experience.models.Experience
import com.ahmedhnewa.alrayada_landing_page.utils.ObserveViewportEntered
import com.ahmedhnewa.alrayada_landing_page.utils.constants.Constants
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ExperienceSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    ExperienceContent()
}

@Composable
private fun ExperienceContent() {
    val breakpoint = rememberBreakpoint()

    var animatedMargin by remember { mutableStateOf(200) }

    if (Constants.ANIMATION_ENABLED) {
        ObserveViewportEntered(
            sectionId = AppSection.Experience.id,
            distanceFromTop = 500.0,
        ) {
            animatedMargin = 50
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .margin(bottom = 25.px)
                .fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 60.percent
                    else 90.percent
                ),
            appSection = AppSection.Experience,
        )
        val experiences = Experience.entries
        experiences.forEach { experience ->
            ExperienceCard(
                isActive = experience == experiences.first(),
                experience = experience,
                breakpoint = breakpoint,
                animatedMargin = animatedMargin.px
            )
        }
    }
}