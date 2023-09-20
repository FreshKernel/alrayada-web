package com.ahmedhnewa.alrayada_landing_page.components.core

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.ComponentVariant

@Composable
fun MyImage(
    src: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    autoPrefix: Boolean = true,
    variant: ComponentVariant? = null,
    lazyLoading: Boolean = true,
) {
//    var isLoading by remember { mutableStateOf(true) }
//    val imageId = "imageId${contentDescription}"

//    LaunchedEffect(Unit) {
//        document.getElementById(imageId)!!
//            .addEventListener("load", {
//                isLoading = false
//            })
//    }

//    if (isLoading) {
//        Center(modifier = modifier) {
//            CircularProgressIndicator()
//        }
//    }

    Image(
        src = src,
        desc = contentDescription,
        modifier = modifier
//            .visibility(
//                if (isLoading) Visibility.Hidden
//                else Visibility.Visible
//            )
//            .id(imageId)
            .attrsModifier {
                if (lazyLoading) {
                    attr("loading", "lazy")
                }
            },
        autoPrefix = autoPrefix,
        variant = variant
    )
}