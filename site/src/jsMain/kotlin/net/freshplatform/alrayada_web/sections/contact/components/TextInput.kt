package net.freshplatform.alrayada_web.sections.contact.components

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.models.ThemeColors
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Resize
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.focus
import com.varabyte.kobweb.silk.style.selectors.placeholderShown
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextArea

val MyTextInputStyle = CssStyle {
    base {
        Modifier
            .border(width = 2.px, style = LineStyle.Solid, color = ThemeColors.LightGray.colorValue)
            .backgroundColor(ThemeColors.LighterGray.colorValue)
            .borderRadius(r = 6.px)
            .fontSize(18.px)
            .padding(12.px)
            .transition(
                Transition.of(property = "border-color", duration = 150.ms),
//                CSSTransition(property = "border-width", duration = 150.ms),
                Transition.of(property = "border-shadow", duration = 200.ms),
            )
    }
    placeholderShown {
        Modifier
            .color(Color("#6c757d"))
//            .fontSize(14.px)
            .fontWeight(FontWeight.Normal)
    }
    focus {
        Modifier
            .border(width = 3.px, style = LineStyle.Solid, color = ThemeColors.Primary.colorValue)
            .outline(style = LineStyle.None)
            .boxShadow(
                color = ThemeColors.Primary.colorValue,
                spreadRadius = 1.px
            )
    }
}

@Composable
fun MyTextInput(
    modifier: Modifier = Modifier,
    breakpoint: Breakpoint = rememberBreakpoint(),
    labelText: String = "",
    hintText: String = "",
    type: InputType.InputTypeWithStringValue = InputType.Text, // only for non-text area
    id: String,
    required: Boolean = true,
    value: String = "",
    formInputName: String? = null,
    textArea: Boolean = false,
) {
    Column {
        Label(
            forId = id,
            attrs = Modifier
                .margin(bottom = 8.px)
                .toAttrs()
        ) {
            Text(labelText)
        }
        val sharedModifier = MyTextInputStyle
            .toModifier()
            .width(
                if (breakpoint >= Breakpoint.MD) 400.px
                else 300.px
            )
            .height(35.px)
            .id(id)
            .attrsModifier {
                attr("placeholder", hintText)
                if (required) {
                    attr("required", "true")
                }
                attr("value", value) // doesn't work for TextArea
                if (formInputName != null) {
                    attr("name", formInputName)
                }
            }
            .then(modifier)
        if (textArea) {
            TextArea(
                attrs = sharedModifier
                    .resize(Resize.Vertical)
                    .toAttrs()
            )
            return@Column
        }
        Input(
            type = type,
            attrs = sharedModifier
                .toAttrs(),
        )
    }
}