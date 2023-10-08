package com.ahmedhnewa.alrayada_landing_page.pages.ar.privacy_policy

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.core.router.AppRouter
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext

@Composable
@Page
fun PrivacyPolicyPage_Arabic() {
    rememberPageContext().router.navigateTo("${AppRouter.PRIVACY_POLICY}/?lang=ar")
}