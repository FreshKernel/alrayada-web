package net.freshplatform.alrayada_web.sections.our_values

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.SectionTitle
import net.freshplatform.alrayada_web.core.data.StringRes
import net.freshplatform.alrayada_web.core.services.localization.stringResource
import net.freshplatform.alrayada_web.models.HomePageSections
import net.freshplatform.alrayada_web.sections.our_values.components.OurValueItem
import net.freshplatform.alrayada_web.sections.our_values.models.OurValueModel
import net.freshplatform.alrayada_web.styles.ReadableTextStyleOnWhiteBackground
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun OurValuesSection() = Box(
    modifier = Modifier.padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    OurValuesContent()
}

@Composable
private fun OurValuesContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Div(
            attrs = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 60.percent
                else 90.percent
            ).toAttrs()
        ) {
            SectionTitle(
                modifier = Modifier
                    .margin(bottom = 40.px),
                section = HomePageSections.OurValues,
                alignment = Alignment.Start
            )
            OurValuesDesc()

            OurValuesItems(
                modifier = Modifier.margin(top = 20.px)
            )
        }
    }
}

@Composable
private fun OurValuesDesc(modifier: Modifier = Modifier) {
    P(
        attrs = ReadableTextStyleOnWhiteBackground
            .toModifier()
            .fontStyle(FontStyle.Italic)
            .fillMaxWidth()
            .lineHeight(1.5)
            .margin(topBottom = 0.px)
            .fontSize(16.px)
            .then(modifier)
            .toAttrs()
    ) {
        Text(stringResource(StringRes.OurValuesDesc))
    }
}

@Composable
fun OurValuesItems(modifier: Modifier) {
    SimpleGrid(
        numColumns = numColumns(
            base = 1,
            md = 2
        ),
        modifier = Modifier
            .then(modifier)
    ) {
        OurValueModel.entries.forEach {
            OurValueItem(ourValueModel = it)
        }
    }
}