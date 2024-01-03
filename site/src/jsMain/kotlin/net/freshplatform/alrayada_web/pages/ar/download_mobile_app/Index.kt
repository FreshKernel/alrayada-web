package net.freshplatform.alrayada_web.pages.ar.download_mobile_app

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext

@Composable
@Page
fun PrivacyPolicyPage_ar() {
    rememberPageContext().router.navigateTo("/download_mobile_app/?lang=ar")
}