package net.freshplatform.alrayada_web.sections.service

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.SectionTitle
import net.freshplatform.alrayada_web.core.data.StringRes
import net.freshplatform.alrayada_web.core.services.localization.stringResource
import net.freshplatform.alrayada_web.models.HomePageSections
import net.freshplatform.alrayada_web.sections.service.components.ServiceCard
import net.freshplatform.alrayada_web.sections.service.models.Service
import net.freshplatform.alrayada_web.styles.ReadableTextStyleOnWhiteBackground
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServiceSection() = Box(
    modifier = Modifier.padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    ServiceContent()
}

@Composable
private fun ServiceContent() {
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
            modifier = Modifier.fillMaxWidth().margin(bottom = 25.px),
            section = HomePageSections.Service,
            alignment = Alignment.CenterHorizontally
        )
        ServiceSectionText(
            modifier = Modifier
                .margin(bottom = 20.px)
                .fillMaxWidth(55.percent)
        )
        ServiceCards()
    }
}

@Composable
private fun ServiceCards() {
    SimpleGrid(numColumns = numColumns(base = 1, sm = 2, md = 3)) {
        Service.entries.forEach { ServiceCard(service = it) }
    }
}

@Composable
private fun ServiceSectionText(modifier: Modifier = Modifier) {
    P(
        attrs = ReadableTextStyleOnWhiteBackground
            .toModifier()
            .margin(topBottom = 0.px)
            .fontSize(16.px)
            .fontWeight(FontWeight.Normal)
            .lineHeight(1.2)
            .then(modifier)
            .toAttrs()
    ) {
        Text(stringResource(StringRes.ServiceSectionDesc))
    }
}