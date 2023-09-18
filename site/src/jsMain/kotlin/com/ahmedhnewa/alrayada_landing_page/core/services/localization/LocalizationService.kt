package com.ahmedhnewa.alrayada_landing_page.core.services.localization

import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLElement

class LocalizationService : Localization {
    private val service = LocalizationImpl()

    companion object {
        private val instance: LocalizationService by lazy {
            LocalizationService()
        }

        fun getInstance() = instance
    }
    override fun getLocalizedString(resValue: StringRes, locale: Local): String =
        service.getLocalizedString(resValue, locale)
}