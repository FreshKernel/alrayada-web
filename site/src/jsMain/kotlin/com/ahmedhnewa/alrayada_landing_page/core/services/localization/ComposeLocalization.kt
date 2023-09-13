package com.ahmedhnewa.alrayada_landing_page.core.services.localization

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import kotlinx.browser.window

private val local: Local by lazy {
    val language = window.navigator.language

    when {
        language.startsWith("en") -> Local.English
        language.startsWith("ar") -> Local.Arabic
        else -> Local.English
    }
}

@Composable
fun stringResource(stringRes: StringRes): String {
    return LocalizationService
        .getInstance()
        .getLocalizedString(stringRes, local)
}