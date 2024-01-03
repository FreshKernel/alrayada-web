package net.freshplatform.alrayada_web.core.services.localization

import net.freshplatform.alrayada_web.core.data.StringRes

interface Localization {
    fun getLocalizedString(resValue: StringRes, locale: Local): String
}