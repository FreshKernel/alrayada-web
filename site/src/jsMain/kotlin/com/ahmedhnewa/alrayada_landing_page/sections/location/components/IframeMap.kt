package com.ahmedhnewa.alrayada_landing_page.sections.location.components

import androidx.compose.runtime.*
import com.ahmedhnewa.alrayada_landing_page.components.CircularProgressIndicator
import com.ahmedhnewa.alrayada_landing_page.sections.contact.components.MyButton
import com.ahmedhnewa.alrayada_landing_page.utils.constants.SectionsConstants
import com.ahmedhnewa.alrayada_landing_page.utils.extensions.getElementByThisId
import com.ahmedhnewa.alrayada_landing_page.utils.extensions.requireElementByThisId
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import kotlinx.browser.document
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Iframe
import org.jetbrains.compose.web.dom.Text

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