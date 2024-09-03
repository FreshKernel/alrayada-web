package net.freshplatform.alrayada_web.sections.mobile_app

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.SectionTitle
import net.freshplatform.alrayada_web.components.core.MyImage
import net.freshplatform.alrayada_web.core.data.StringRes
import net.freshplatform.alrayada_web.core.services.localization.stringResource
import net.freshplatform.alrayada_web.models.HomePageSections
import net.freshplatform.alrayada_web.sections.mobile_app.componenets.DownloadButtons
import net.freshplatform.alrayada_web.sections.mobile_app.componenets.DownloadQrCode
import net.freshplatform.alrayada_web.styles.ReadableTextStyleOnWhiteBackground
import net.freshplatform.alrayada_web.utils.constants.PublicRes
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
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MobileAppSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    MobileAppContent()
}

@Composable
private fun MobileAppContent() {
    val breakpoint = rememberBreakpoint()
    SimpleGrid(
        numColumns = numColumns(base = 1, xl = 2),
        modifier = Modifier.fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 80.percent
            else 90.percent
        )
    ) {
        MobileAppData(
            modifier = Modifier.fillMaxWidth(70.percent)
        )
        MobileAppImage(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun MobileAppData(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .then(modifier)
    ) {
        SectionTitle(
            section = HomePageSections.MobileApp,
            modifier = Modifier.margin(bottom = 16.px),
//            alignment = Alignment.CenterHorizontally
        )
        P(
            attrs = ReadableTextStyleOnWhiteBackground
                .toModifier()
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontSize(20.px)
                .lineHeight(1.4)
                .toAttrs()
        ) {
            Text(stringResource(StringRes.MobileAppDesc))
        }
        SimpleGrid(
            numColumns = numColumns(base = 1, lg = 2),
            modifier = Modifier
                .margin(top = 40.px),
        ) {
            DownloadButtons(
                modifier = Modifier
                    .margin(top = 20.px)
            )
            DownloadQrCode(
                modifier = Modifier.margin(left = 20.px)
            )
        }
    }
}

@Composable
fun MobileAppImage(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .maxHeight(700.px)
    ) {
        MyImage(
            src = PublicRes.Assets.Svg.MOBILE_DEVELOPMENT1,
            contentDescription = "Mobile app",
            modifier = Modifier
//                .border(4.px, LineStyle.Solid, Colors.Black)
                .fillMaxSize()
                .then(modifier)
        )
    }
}