package net.freshplatform.alrayada_web.sections.location.components

import androidx.compose.runtime.*
import net.freshplatform.alrayada_web.components.CircularProgressIndicator
import net.freshplatform.alrayada_web.utils.constants.SectionsConstants
import net.freshplatform.alrayada_web.utils.extensions.requireElementByThisId
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Iframe

@Composable
fun IframeMap(modifier: Modifier = Modifier, breakpoint: Breakpoint) {
    var isLoading by remember { mutableStateOf(true) }
    val iframeMapId = "iframeMap"
    LaunchedEffect(Unit) {
        val iframeMap = iframeMapId.requireElementByThisId()

        iframeMap.addEventListener("load", {
            isLoading = false
        })
    }
    if (isLoading) {
        CircularProgressIndicator()
    }
    Iframe(
        attrs = Modifier
            .id(iframeMapId)
            .title("Google map")
            .fillMaxWidth(
                if (breakpoint > Breakpoint.LG) 65.percent
                else if (breakpoint >= Breakpoint.MD) 70.percent
                else 100.percent
            )
            .minHeight(800.px)
            .borderRadius(r = 8.px)
            .border {
                style(LineStyle.None)
            }
            .margin(top = 200.px)
            .then(modifier)
            .toAttrs {
                attr("loading", "lazy")
                attr("allowfullscreen", "")
                attr("referrerpolicy", "no-referrer-when-downgrade")
                attr(
                    "src",
                    SectionsConstants.Location.MAP_API
                )
            },
    )
}