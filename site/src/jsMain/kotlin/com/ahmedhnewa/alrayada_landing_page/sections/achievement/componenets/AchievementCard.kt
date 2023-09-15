package com.ahmedhnewa.alrayada_landing_page.sections.achievement.componenets

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.fa.FaIcon
import com.ahmedhnewa.alrayada_landing_page.components.fa.IconCategory
import com.ahmedhnewa.alrayada_landing_page.components.fa.IconSize
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.ahmedhnewa.alrayada_landing_page.sections.achievement.models.Achievement
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AchievementCard(
    modifier: Modifier = Modifier,
    animatedNumber: Int,
    achievement: Achievement
) {
    Row(
        modifier = Modifier.margin(leftRight = 20.px).then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FaIcon(
            name = achievement.icon,
            modifier = Modifier
                .title("Achievement icon")
                .margin(right = 20.px)
                .attrsModifier {
                    attr("alt", "Achievement icon")
                },
            style = IconCategory.SOLID,
            size = IconSize.X3
        )
        Column {
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontSize(30.px)
                    .fontWeight(FontWeight.Bolder)
                    .color(ThemeColors.Primary.colorValue)
                    .toAttrs()
            ) {
                Text(
                    if (achievement == Achievement.Completed)
                        "${animatedNumber}+"
                    else "$animatedNumber"
                )
            }
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Normal)
                    .color(ThemeColors.Secondary.colorValue)
                    .opacity(50.percent)
                    .toAttrs()
            ) {
                Text(stringResource(achievement.descriptionRes))
            }
        }
    }
}