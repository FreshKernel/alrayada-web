package net.freshplatform.alrayada_web.pages.deleteAccountInstructions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.style.toModifier
import net.freshplatform.alrayada_web.components.core.Center
import net.freshplatform.alrayada_web.core.data.StringRes
import net.freshplatform.alrayada_web.core.services.localization.getStringResource
import net.freshplatform.alrayada_web.styles.ReadableTextStyleOnWhiteBackground
import net.freshplatform.alrayada_web.utils.updateDocument
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
@Page
fun DeleteAccountInstructions() {
    LaunchedEffect(Unit) {
        updateDocument {
            title = "${getStringResource(StringRes.DeleteAccountInstructions)} - ${getStringResource(StringRes.AlrayadaAlarabiah)}"
            description = getStringResource(StringRes.DeleteAccountInstructionsDesc)
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
                    .minHeight(200.px),
            ) {
                Column(
                    modifier = Modifier
                        .padding(25.px)
                        .fillMaxSize()
                ) {
                    H1(
                        attrs = Modifier
                            .toAttrs()
                    ) {
                        Text(getStringResource(StringRes.DeleteAccountInstructions))
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
                        Text(getStringResource(StringRes.DeleteAccountInstructionsSteps))
                    }
                }
            }
        }
    }
}