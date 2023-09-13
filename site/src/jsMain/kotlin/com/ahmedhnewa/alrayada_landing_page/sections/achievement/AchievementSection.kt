package com.ahmedhnewa.alrayada_landing_page.sections.achievement

import androidx.compose.runtime.*
import com.ahmedhnewa.alrayada_landing_page.models.Section
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.ahmedhnewa.alrayada_landing_page.sections.achievement.componenets.AchievementCard
import com.ahmedhnewa.alrayada_landing_page.sections.achievement.models.Achievement
import com.ahmedhnewa.alrayada_landing_page.utils.ObserveViewportEntered
import com.ahmedhnewa.alrayada_landing_page.utils.animateNumber
import com.ahmedhnewa.alrayada_landing_page.utils.constants.Constants
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.px

@Composable
fun AchievementSection() = Box(
    modifier = Modifier
        .fillMaxWidth()
        .padding(topBottom = 100.px)
        .backgroundColor(ThemeColors.LighterGray.colorValue),
    contentAlignment = Alignment.Center
) {
    AchievementContent()
}

@Composable
private fun AchievementContent() {
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false) }
    val animatedNumbers = remember { Achievement.animationDefaultValues }

    val achievements = Achievement.entries
    if (Constants.ANIMATION_ENABLED) {
        ObserveViewportEntered(
            sectionId = Section.Achievements.id,
            distanceFromTop = 700.0,
        ) {
            viewportEntered = true
            achievements.forEach { achievement ->
                scope.launch {
                    animateNumber(
                        number = achievement.number,
                        delayTime = if (achievement.number < 5) 100L else 40L,
                        onUpdate = {
                            animatedNumbers[achievement.ordinal] = it
                        }
                    )
                }
            }
        }
    }
    val breakpoint = rememberBreakpoint()
    SimpleGrid(
        numColumns = numColumns(base = 1, md = 2, lg = 4)
    ) {
        achievements.forEach { achievement ->
            AchievementCard(
                modifier = Modifier.margin(
                    right = if (achievement == achievements.last()) 0.px
                    else {
                        if (breakpoint > Breakpoint.SM) 40.px else 0.px
                    },
                    bottom = if (breakpoint > Breakpoint.MD) 0.px else 40.px
                ),
                animatedNumber = if (Constants.ANIMATION_ENABLED) (
                        if (viewportEntered) animatedNumbers[achievement.ordinal] else 0
                ) else achievement.number,
                achievement = achievement
            )
        }
    }
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceEvenly
//    ) {
//
//    }
}