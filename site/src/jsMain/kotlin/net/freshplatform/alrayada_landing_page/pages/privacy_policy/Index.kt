package net.freshplatform.alrayada_landing_page.pages.privacy_policy

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import net.freshplatform.alrayada_landing_page.components.core.Center
import net.freshplatform.alrayada_landing_page.core.data.StringRes
import net.freshplatform.alrayada_landing_page.core.services.localization.getStringResource
import net.freshplatform.alrayada_landing_page.core.services.localization.stringResource
import net.freshplatform.alrayada_landing_page.styles.ReadableTextStyleOnWhiteBackground
import net.freshplatform.alrayada_landing_page.utils.updateDocument
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun PrivacyPolicyPage() {
    LaunchedEffect(Unit) {
        updateDocument {
            title = "${getStringResource(StringRes.PrivacyPolicy)} - ${getStringResource(StringRes.AlrayadaAlarabiah)}"
            description = getStringResource(StringRes.PrivacyPolicyText)
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .backgroundColor(Color("#242B2E"))
    ) {
        Center {
            Box(
                modifier = Modifier
                    .backgroundColor(Colors.White)
                    .fillMaxWidth(95.percent)
                    .borderRadius(r = 20.px)
                    .minHeight(300.px),
            ) {
                Column(
                    modifier = Modifier
                        .padding(25.px)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    H1(
                        attrs = Modifier.fillMaxWidth()
                            .textAlign(TextAlign.Center)
                            .toAttrs()
                    ) {
                        Text(stringResource(StringRes.PrivacyPolicy))
                    }
                    P(
                        attrs = ReadableTextStyleOnWhiteBackground
                            .toModifier()
                            .fillMaxWidth()
                            .margin(topBottom = 0.px)
                            .fontSize(18.px)
                            .lineHeight(1.4)
                            .toAttrs()
                    ) {
                        Text(stringResource(StringRes.PrivacyPolicyText))
                    }
                }
            }
        }
    }
}