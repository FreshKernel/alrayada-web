package net.freshplatform.alrayada_web

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import net.freshplatform.alrayada_web.core.data.StringRes
import net.freshplatform.alrayada_web.core.services.localization.getStringResource
import net.freshplatform.alrayada_web.utils.updateDocument
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.vh

@InitSilk
fun initSilk(ctx: InitSilkContext) {

    ctx.stylesheet.apply {
        registerKeyframes("spin") {
            from { Modifier.rotate(0.deg) }
            to { Modifier.rotate(360.deg) }
        }
        registerStyleBase("body") {
            Modifier.fontFamily(
                "-apple-system", "BlinkMacSystemFont", "Segoe UI", "Roboto", "Oxygen", "Ubuntu",
                "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue", "sans-serif"
            )
        }
        registerStyleBase(".visible") {
            Modifier
                .height(300.px)
                .fillMaxWidth()
                .backgroundColor(rgba(128, 128, 128, 0.5))
        }
        registerStyleBase(".hidden") {
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

        LaunchedEffect(Unit) {
            updateDocument {
                title = getStringResource(StringRes.AlrayadaAlarabiah)
                description = getStringResource(StringRes.WebsiteDesc)
            }
        }

        Surface(SmoothColorStyle.toModifier().minHeight(100.vh)) {
            content()
        }
    }
}
