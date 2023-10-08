package com.ahmedhnewa.alrayada_landing_page.pages.download_mobile_app

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.dom.Text

@Composable
@Page
fun DownloadMobileAppPage() {
    Text(stringResource(StringRes.MobileApp))
}