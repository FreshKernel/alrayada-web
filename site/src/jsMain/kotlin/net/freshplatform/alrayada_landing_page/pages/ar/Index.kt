package net.freshplatform.alrayada_landing_page.pages.ar

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext

@Composable
@Page
fun PrivacyPolicyPage_ar() {
    rememberPageContext().router.navigateTo("/?lang=ar")
}