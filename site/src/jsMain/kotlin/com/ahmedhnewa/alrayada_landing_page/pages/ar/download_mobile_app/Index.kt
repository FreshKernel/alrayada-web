package com.ahmedhnewa.alrayada_landing_page.pages.ar.download_mobile_app

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.core.router.AppRouter
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext

@Composable
@Page
fun DownloadMobileAppPage_Arabic() {
    rememberPageContext().router.navigateTo("${AppRouter.DOWNLOAD_MOBILE_APP}/?lang=ar")
}