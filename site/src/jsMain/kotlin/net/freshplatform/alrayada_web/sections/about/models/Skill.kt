package net.freshplatform.alrayada_web.sections.about.models

import androidx.compose.runtime.mutableStateListOf
import net.freshplatform.alrayada_web.core.data.StringRes
import org.jetbrains.compose.web.css.CSSLengthOrPercentageValue
import org.jetbrains.compose.web.css.percent

enum class Skill(
    val titleRes: StringRes,
    val percentageValue: CSSLengthOrPercentageValue
) {
    Responsibility(
        StringRes.Responsibility,
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
    AfterSalesServiceQuality(
        StringRes.AfterSalesServiceQuality,
        80.percent
    );

    companion object {
        // Should match the length of enum items
        val animationDefaultValues = mutableStateListOf(0, 0, 0, 0, 0)
    }
}