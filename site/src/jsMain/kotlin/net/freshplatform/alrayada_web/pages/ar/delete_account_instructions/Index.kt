package net.freshplatform.alrayada_web.pages.ar.delete_account_instructions

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext

@Composable
@Page
fun PrivacyPolicyPage_ar() {
    rememberPageContext().router.navigateTo("/delete_account_instructions/?lang=ar")
}