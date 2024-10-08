package net.freshplatform.alrayada_web.components.core

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.styles.MainButtonStyle
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.title
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.Button,
    content: @Composable () -> Unit,
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

@Composable
fun MyButtonWithText(
    modifier: Modifier = Modifier,
    text: String,
    type: ButtonType = ButtonType.Button,
) {
    Button(
        attrs = MainButtonStyle
            .toModifier()
            .then(modifier)
            .title(text)
            .toAttrs {
                attr("type", type.str)
            },
    ) {
        Text(text)
    }
}