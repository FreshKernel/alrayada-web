package net.freshplatform.alrayada_web.core.services.localization

import net.freshplatform.alrayada_web.core.data.StringRes

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