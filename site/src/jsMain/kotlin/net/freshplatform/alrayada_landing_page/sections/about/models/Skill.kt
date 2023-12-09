package net.freshplatform.alrayada_landing_page.sections.about.models

import androidx.compose.runtime.mutableStateListOf
import net.freshplatform.alrayada_landing_page.core.data.StringRes
import org.jetbrains.compose.web.css.CSSLengthOrPercentageValue
import org.jetbrains.compose.web.css.percent

enum class Skill(
    val titleRes: StringRes,
    val percentageValue: CSSLengthOrPercentageValue
) {
    Accountable(
        StringRes.Accountable,
        87.percent
    ),
    HardWorking(
        StringRes.HardWorking,
        97.percent
    ),
    Value(
        StringRes.ValueForMoney,
        95.percent
    ),
    Delivery(
        StringRes.OnTimeDelivery,
        75.percent
    ),
    Creative(
        StringRes.Creative,
        69.percent
    );

    companion object {
        // Should match the length of enum items
        val animationDefaultValues = mutableStateListOf(0, 0, 0, 0, 0)
    }
}