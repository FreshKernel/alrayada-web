package com.ahmedhnewa.alrayada_landing_page

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.registerKeyframes
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.components.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.init.registerBaseStyle
import kotlinx.browser.localStorage
import org.jetbrains.compose.web.css.*

//private const val COLOR_MODE_KEY = "alrayada_landing_page:colorMode"

@InitSilk
fun initSilk(ctx: InitSilkContext) {
//    ctx.config.initialColorMode = localStorage.getItem(COLOR_MODE_KEY)?.let { ColorMode.valueOf(it) } ?: ColorMode.LIGHT

    ctx.stylesheet.apply {
        registerKeyframes(
            Keyframes("spin") {
                from { Modifier.rotate(0.deg) }
                to { Modifier.rotate(360.deg) }
            }
        )
        registerBaseStyle("body") {
            Modifier.fontFamily(
                "-apple-system", "BlinkMacSystemFont", "Segoe UI", "Roboto", "Oxygen", "Ubuntu",
                "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue", "sans-serif"
            )
        }
        registerBaseStyle(".visible") {
            Modifier
                .height(300.px)
                .fillMaxWidth()
                .backgroundColor(rgba(128, 128, 128, 0.5))
        }
        registerBaseStyle(".hidden") {
            Modifier
                .height(0.px)
                .width(0.px)
                .overflow(Overflow.Hidden)
                .backgroundColor(rgba(128, 128, 128, 0))
        }
    }
}

@App
@Composable
fun MyApp(content: @Composable () -> Unit) {
    SilkApp {
//        val colorMode = ColorMode.current
//        LaunchedEffect(colorMode) {
//            localStorage.setItem(COLOR_MODE_KEY, colorMode.name)
//        }

        Surface(SmoothColorStyle.toModifier().minHeight(100.vh)) {
            content()
        }
    }
}
