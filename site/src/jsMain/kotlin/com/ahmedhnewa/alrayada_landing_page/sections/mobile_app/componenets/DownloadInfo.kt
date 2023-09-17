package com.ahmedhnewa.alrayada_landing_page.sections.mobile_app.componenets

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.core.MyImage
import com.ahmedhnewa.alrayada_landing_page.sections.mobile_app.models.MobileApp
import com.ahmedhnewa.alrayada_landing_page.utils.constants.PublicRes
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

@Composable
fun DownloadButtons(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val downloads = MobileApp.entries
        downloads.forEach {
            val isLast = downloads.last() == it
            DownloadMobileAppButton(
                modifier = Modifier
                    .thenIf(
                        !isLast,
                        Modifier.margin(bottom = 12.px)
                    ),
                mobileApp = it
            )
        }
    }
}

@Composable
fun DownloadQrCode(modifier: Modifier = Modifier) {
    MyImage(
        src = PublicRes.Assets.Images.MobileApp.QR_CODE,
        contentDescription = "Download App by QR Code",
        modifier = Modifier
//            .displayIfAtLeast(Breakpoint.LG)
            .then(modifier)
    )
    Div(
        attrs = Modifier
            .displayUntil(Breakpoint.LG)
            .margin(top = 40.px)
            .toAttrs()
    )
}