package net.freshplatform.alrayada_web.pages.ar.deleteAccountInstructions

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import net.freshplatform.alrayada_web.core.router.Routes

@Composable
@Page
fun PrivacyPolicyPage_ar() {
    rememberPageContext().router.navigateTo("${Routes.DELETE_ACCOUNT_INSTRUCTIONS}/?lang=ar")
}