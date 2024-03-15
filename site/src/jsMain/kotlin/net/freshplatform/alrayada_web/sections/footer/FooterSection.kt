package net.freshplatform.alrayada_web.sections.footer

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.AppLogo
import net.freshplatform.alrayada_web.components.fa.FaGithub
import net.freshplatform.alrayada_web.core.data.StringRes
import net.freshplatform.alrayada_web.core.services.localization.stringResource
import net.freshplatform.alrayada_web.models.ThemeColors
import net.freshplatform.alrayada_web.sections.main.compoments.NavigationLinks
import net.freshplatform.alrayada_web.sections.main.compoments.SocialBar
import net.freshplatform.alrayada_web.utils.constants.SectionsConstants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun FooterSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px)
        .backgroundColor(ThemeColors.LighterGray.colorValue),
    contentAlignment = Alignment.Center
) {
    FooterContent()
}

@Composable
private fun FooterContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppLogo()
        Box(
            modifier = Modifier.fillMaxWidth()
                .backgroundColor(ThemeColors.LighterGray.colorValue)
                .padding(16.px)
                .margin(bottom = 8.px),
            contentAlignment = Alignment.Center
        ) {
            Row(modifier = Modifier.displayIfAtLeast(Breakpoint.MD)) {
                NavigationLinks(
                    eachItemModifier = Modifier
                        .padding(right = 20.px)
                        .fontSize(16.px)
                )
            }
            Column(modifier = Modifier.displayUntil(Breakpoint.MD)) {
                NavigationLinks(
                    eachItemModifier = Modifier
                        .padding(topBottom = 8.px, leftRight = 0.px)
                        .fontSize(16.px)
                        .fillMaxWidth()
                        .textAlign(TextAlign.Center)
                )
            }
        }
        SocialBar(
            modifier = Modifier.margin(bottom = 20.px),
            isRow = true
        )

        FooterDetails()

    }
}


@Composable
fun FooterDetails() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(bottom = 8.px, top = 4.px)
                .fontSize(16.px)
                .fontWeight(FontWeight.Bold)
                .textAlign(TextAlign.Center)
                .toAttrs()
        ) {
            Text("© 2024 ${stringResource(StringRes.AlrayadaAlarabiah)}. ${stringResource(StringRes.AllRightsReserved)}")
        }

        Row {
            FaGithub()
            Link(
                path = SectionsConstants.Footer.REPOSITORY_URL,
                text = stringResource(StringRes.ThisProjectIsOpenSource),
                modifier = Modifier
                    .color(ThemeColors.Primary.colorValue)
                    .title(stringResource(StringRes.ThisProjectIsOpenSource))
                    .textDecorationLine(TextDecorationLine.None)
                    .margin(left = 8.px)
                    .attrsModifier {
                        attr("alt", "Repository Link")
                    }
            )
        }
    }
}
