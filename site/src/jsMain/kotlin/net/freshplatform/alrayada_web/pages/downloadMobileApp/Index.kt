package net.freshplatform.alrayada_web.pages.downloadMobileApp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import net.freshplatform.alrayada_web.core.data.StringRes
import net.freshplatform.alrayada_web.core.services.localization.getStringResource
import net.freshplatform.alrayada_web.core.services.localization.stringResource
import net.freshplatform.alrayada_web.utils.updateDocument
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import net.freshplatform.alrayada_web.components.core.Center
import net.freshplatform.alrayada_web.styles.ReadableTextStyleOnWhiteBackground
import net.freshplatform.alrayada_web.utils.constants.SectionsConstants
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
@Page
fun DownloadMobileAppPage() {
    LaunchedEffect(Unit) {
        updateDocument {
            title = "${getStringResource(StringRes.MobileApp)} - ${getStringResource(StringRes.AlrayadaAlarabiah)}"
            description = getStringResource(StringRes.MobileAppDesc)
        }
    }
    val isiOS =
        Regex("iPad|iPhone|iPod").containsMatchIn(window.navigator.userAgent) && !window.asDynamic().MSStream as Boolean
    val isAndroid = Regex("Android").containsMatchIn(window.navigator.userAgent)
    if (isAndroid) {
        window.location.replace(SectionsConstants.MobileApp.GOOGLE_PLAY)
    } else if (isiOS) {
        window.location.replace(SectionsConstants.MobileApp.APPLE_APP_STORE)
    } else {
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
                        .minHeight(150.px),
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
                            Text(stringResource(StringRes.MobileApp))
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
                            Text(stringResource(StringRes.PleaseOpenThisPageOnMobile))
                        }
                    }
                }
            }
        }
    }
}