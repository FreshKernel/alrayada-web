package net.freshplatform.alrayada_web.pages.ar.privacyPolicy

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext

@Composable
@Page
fun PrivacyPolicyPage_ar() {
    rememberPageContext().router.navigateTo("/privacy-policy/?lang=ar")
}