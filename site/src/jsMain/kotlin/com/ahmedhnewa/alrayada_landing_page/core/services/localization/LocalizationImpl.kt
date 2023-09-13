package com.ahmedhnewa.alrayada_landing_page.core.services.localization

import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.Local.Arabic
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.Local.English

class LocalizationImpl : Localization {
    override fun getLocalizedString(resValue: StringRes, locale: Local): String {
        return when(locale) {
            English -> resValue.en
            Arabic -> resValue.ar
            else -> resValue.en
        }
    }
}