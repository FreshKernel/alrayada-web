import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.ParagraphText
import net.freshplatform.alrayada_web.models.ThemeColors
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import org.jetbrains.compose.web.css.*

@Composable
fun SkillBar(
    name: String,
    index: Int,
    percentageValueBar: CSSLengthOrPercentageValue = 50.percent,
    animatedPercentageValueText: CSSLengthOrPercentageValue = 90.percent,
    progressBarHeight: CSSSizeValue<CSSUnit.px> = 5.px
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .margin(bottom = 10.px)
            .maxWidth(500.px)
            .padding(topBottom = 5.px)
    ) {
        Row(
            modifier = Modifier
                .margin(bottom = 5.px)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ParagraphText(
                name,
                modifier = Modifier.margin(topBottom = 2.px)
            )
            ParagraphText(
                if (animatedPercentageValueText.value > 0) "${animatedPercentageValueText.value.toInt()}${animatedPercentageValueText.unit}" else "0%",
                modifier = Modifier.margin(topBottom = 2.px),
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(progressBarHeight)
                    .borderRadius(r = 12.px)
                    .backgroundColor(ThemeColors.LightGray.colorValue)
            )
            Box(
                modifier = Modifier.fillMaxWidth(percentageValueBar.value.percent)
                    .height(progressBarHeight)
                    .borderRadius(r = 12.px)
                    .backgroundColor(ThemeColors.Primary.colorValue)
                    .transition(
                        Transition.of(
                            property = "width",
                            duration = 1000.ms,
                            timingFunction = null, delay = (index + 1) * 100.ms
                        )
                    )
            )
        }
    }
}