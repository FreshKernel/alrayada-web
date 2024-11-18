package net.freshplatform.alrayada_web.pages.ar.downloadMobileApp

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import net.freshplatform.alrayada_web.core.router.Routes

@Composable
@Page
fun PrivacyPolicyPage_ar() {
    rememberPageContext().router.navigateTo("${Routes.DOWNLOAD_MOBILE_APP}/?lang=ar")
}