package com.ahmedhnewa.alrayada_landing_page.sections.main.compoments

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.*

val MobileNavigation by ComponentStyle {
    base {
        Modifier
    }
}

@Composable
fun MobileNavigation(modifier: Modifier = Modifier) {
    Box(
        modifier = MobileNavigation
            .toModifier()
            .id("mobileNavigationItems")
//            .minHeight(300.px)
//            .backgroundColor(rgba(128, 128, 128, 0.5))
//            .fillMaxWidth()
            .transition(
                CSSTransition(
                    property = "height", duration = 330.ms
                ),
                CSSTransition(
                    property = "background-color", duration = 300.ms
                ),
            )
            .classNames("hidden")
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Column {
            NavigationLinks(
                eachItemModifier = Modifier
                    .padding(topBottom = 8.px, leftRight = 0.px)
                    .fontSize(16.px)
                    .fillMaxWidth()
                    .color(Color("#21252A"))
                    .textAlign(TextAlign.Center)
            )
        }
    }
}