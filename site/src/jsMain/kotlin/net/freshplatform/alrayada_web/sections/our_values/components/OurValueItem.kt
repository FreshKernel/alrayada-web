package net.freshplatform.alrayada_web.sections.our_values.components

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.CheckIndicator
import net.freshplatform.alrayada_web.core.services.localization.stringResource
import net.freshplatform.alrayada_web.models.ThemeColors
import net.freshplatform.alrayada_web.sections.our_values.models.OurValueModel
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun OurValueItem(modifier: Modifier = Modifier, ourValueModel: OurValueModel) {
    Row(
        modifier = Modifier
            .padding(16.px)
            .then(modifier),
    ) {
        CheckIndicator(
            modifier = Modifier
                .margin(right = 12.px)
        )
        TextValue(
            ourValueModel = ourValueModel,
        )
    }
}

@Composable
private fun TextValue(
    modifier: Modifier = Modifier,
    ourValueModel: OurValueModel
) {
    P(
        attrs = Modifier
            .fillMaxWidth()
            .margin(topBottom = 0.px)
            .fontSize(14.px)
            .fontWeight(FontWeight.Normal)
            .lineHeight(1.6)
            .letterSpacing(1.2.px)
            .then(modifier)
            .toAttrs()
    ) {
        SpanText(
            text = "${stringResource(ourValueModel.value)}: ",
            modifier = Modifier
                .fontWeight(FontWeight.Light)
                .letterSpacing(0.px)
                .color(ThemeColors.Primary.colorValue)
                .fontSize(20.px)
        )
        Text(stringResource(ourValueModel.desc))
    }
}