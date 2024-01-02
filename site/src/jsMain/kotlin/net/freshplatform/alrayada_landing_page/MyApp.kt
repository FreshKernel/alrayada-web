package net.freshplatform.alrayada_landing_page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.registerKeyframes
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.components.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import net.freshplatform.alrayada_landing_page.core.data.StringRes
import net.freshplatform.alrayada_landing_page.core.services.localization.getStringResource
import net.freshplatform.alrayada_landing_page.utils.updateDocument
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.vh

@InitSilk
fun initSilk(ctx: InitSilkContext) {

    ctx.stylesheet.apply {
        registerKeyframes(
            Keyframes("spin") {
                from { Modifier.rotate(0.deg) }
                to { Modifier.rotate(360.deg) }
            }
        )
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
