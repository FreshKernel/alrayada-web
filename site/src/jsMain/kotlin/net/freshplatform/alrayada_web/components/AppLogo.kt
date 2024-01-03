package net.freshplatform.alrayada_web.components

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.core.MyImage
import net.freshplatform.alrayada_web.core.data.StringRes
import net.freshplatform.alrayada_web.core.services.localization.stringResource
import net.freshplatform.alrayada_web.utils.constants.PublicRes
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.maxSize
import org.jetbrains.compose.web.css.px

@Composable
fun AppLogo(modifier: Modifier = Modifier, lazyLoading: Boolean = true) {
    MyImage(
        modifier = Modifier
            .maxSize(250.px)
            .then(modifier),
        src = PublicRes.Assets.Images.LOGO,
        contentDescription = stringResource(StringRes.AlrayadaAlarabiah),
        lazyLoading = lazyLoading
    )
}