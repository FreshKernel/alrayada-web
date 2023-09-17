package com.ahmedhnewa.alrayada_landing_page.components

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.core.MyImage
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.utils.constants.PublicRes
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.maxSize
import org.jetbrains.compose.web.css.px

@Composable
fun AppLogo(modifier: Modifier = Modifier, lazyLoading: Boolean = true) {
    MyImage(
        modifier = Modifier
            .maxSize(200.px)
            .then(modifier),
        src = PublicRes.Assets.Images.LOGO,
        contentDescription = stringResource(StringRes.AlrayadaAlarabiah),
        lazyLoading = lazyLoading
    )
}