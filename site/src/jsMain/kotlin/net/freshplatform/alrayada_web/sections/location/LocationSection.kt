package net.freshplatform.alrayada_web.sections.location

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.SectionTitle
import net.freshplatform.alrayada_web.components.core.Center
import net.freshplatform.alrayada_web.components.core.MyImage
import net.freshplatform.alrayada_web.models.HomePageSections
import net.freshplatform.alrayada_web.sections.location.components.ContactUsInformation
import net.freshplatform.alrayada_web.sections.location.components.IframeMap
import net.freshplatform.alrayada_web.utils.constants.PublicRes
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun LocationSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    LocationContent()
}

@Composable
private fun LocationContent() {
    val breakpoint = rememberBreakpoint()
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
                .fillMaxWidth(
                    if (breakpoint > Breakpoint.LG) 55.percent
                    else if (breakpoint >= Breakpoint.MD) 70.percent
                    else 100.percent
                )
                .margin(bottom = 40.px),
            section = HomePageSections.Location,
            alignment = Alignment.Start
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            MyImage(
                src = PublicRes.Assets.Svg.Waves.WAVE_1,
                contentDescription = "Wave Image",
                modifier = Modifier
                    .displayIfAtLeast(Breakpoint.MD)
                    .fillMaxWidth()
            )
            Center {
                IframeMap(breakpoint = breakpoint)
            }
        }
        ContactUsInformation(
            modifier = Modifier
                .margin(top = 60.px)
        )
    }
}
