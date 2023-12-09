package net.freshplatform.alrayada_landing_page.components.stars

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import org.jetbrains.compose.web.css.px

@Composable
fun RatingBar(modifier: Modifier = Modifier, value: Int = 5) {
    Row(
        modifier = Modifier.then(modifier),
    ) {
        repeat((1..value).count()) {
            StarIcon(
                modifier = Modifier
                    .margin(right = if (it != value) 2.px else 0.px),
                halfStar = false
            )
        }
    }
}