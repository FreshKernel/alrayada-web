package net.freshplatform.alrayada_web.components.stars

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.fa.FaStar
import net.freshplatform.alrayada_web.components.fa.FaStarHalfStroke
import net.freshplatform.alrayada_web.components.fa.IconSize
import net.freshplatform.alrayada_web.components.fa.IconStyle
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import org.jetbrains.compose.web.css.Color

private const val YELLOW_COLOR_HEX = "#FFD700"

@Composable
fun StarIcon(
    modifier: Modifier = Modifier,
    size: IconSize? = null,
    style: IconStyle? = null,
    halfStar: Boolean = false
) {
    if (halfStar) {
        FaStarHalfStroke(
            modifier = Modifier.color(
                Color(YELLOW_COLOR_HEX)
            ).then(modifier),
            size = size,
            style = style ?: IconStyle.OUTLINE
        )
        return
    }
    FaStar(
        modifier = Modifier.color(
            Color(YELLOW_COLOR_HEX)
        ).then(modifier),
        size = size,
        style = style ?: IconStyle.FILLED
    )
}
