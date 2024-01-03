package net.freshplatform.alrayada_web.components

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.models.ThemeColors
import com.varabyte.kobweb.compose.css.AnimationIterationCount
import com.varabyte.kobweb.compose.css.CSSAnimation
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun CircularProgressIndicator(modifier: Modifier = Modifier) {
    Div(
        attrs = Modifier
            .size(100.px)
            .position(Position.Relative)
            .then(modifier)
            .toAttrs()
    ) {


        Div(
            attrs = Modifier
                .fillMaxSize()
                .border(8.px, LineStyle.Solid, ThemeColors.Primary.colorValue)
                .borderTop(color = Color("#007bff"))
                .borderRadius(50.percent)
                .animation(
                    CSSAnimation(
                        "spin",
                        1.1.s,
                        AnimationTimingFunction.Linear,
                        iterationCount = AnimationIterationCount.Infinite
                    )
                )
                .toAttrs()
        )
    }
}