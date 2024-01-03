package net.freshplatform.alrayada_web.core.services.localization

import net.freshplatform.alrayada_web.core.data.StringRes
import net.freshplatform.alrayada_web.core.services.localization.Local.Arabic
import net.freshplatform.alrayada_web.core.services.localization.Local.English

class LocalizationImpl : Localization {
    override fun getLocalizedString(resValue: StringRes, locale: Local): String {
        return when (locale) {
            English -> resValue.en
            Arabic -> resValue.ar
            else -> resValue.en
        }
    }
}