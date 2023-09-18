package com.ahmedhnewa.alrayada_landing_page.components.core

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.styles.MainButtonStyle
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.Button,
    content:  @Composable () -> Unit,
) {
    Button(
        attrs = MainButtonStyle
            .toModifier()
            .then(modifier)
            .toAttrs {
                attr("type", type.str)
            },
    ) {
        content()
    }
}