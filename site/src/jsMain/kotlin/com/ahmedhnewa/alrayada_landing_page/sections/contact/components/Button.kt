package com.ahmedhnewa.alrayada_landing_page.sections.contact.components

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.styles.MainButtonStyle
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    labelText: String = ""
) {
    Button(
        attrs = MainButtonStyle
            .toModifier()
            .then(modifier)
            .toAttrs(),
    ) {
        Text(labelText)
    }
}