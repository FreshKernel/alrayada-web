package com.ahmedhnewa.alrayada_landing_page.sections.contact.components

import androidx.compose.runtime.*
import com.ahmedhnewa.alrayada_landing_page.components.core.MyButton
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.utils.constants.SectionsConstants
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Form

@Composable
fun ContactForm() = Form(
    action = SectionsConstants.About.FORM_URL,
    attrs = Modifier
        .attrsModifier {
            attr("method", "POST")
        }
        .toAttrs()
) {
    val breakpoint = rememberBreakpoint()

    Column {
        MyTextInput(
            id = "nameInput",
            hintText = stringResource(StringRes.FullName),
            labelText = stringResource(StringRes.Name),
            type = InputType.Text,
            breakpoint = breakpoint,
            modifier = Modifier.margin(bottom = 12.px)
                .attrsModifier {
                    attr("name", "Name")
                }
        )
        MyTextInput(
            id = "emailInput",
            hintText = stringResource(StringRes.EmailAddress),
            labelText = stringResource(StringRes.Email),
            type = InputType.Email,
            breakpoint = breakpoint,
            modifier = Modifier.margin(bottom = 12.px)
                .attrsModifier {
                    attr("name", "Email")
                }
        )
        MyTextInput(
            id = "messageInput",
            hintText = stringResource(StringRes.YourMessage),
            labelText = stringResource(StringRes.Message),
            textArea = true,
            breakpoint = breakpoint,
            modifier = Modifier.margin(bottom = 20.px)
                .height(150.px)
                .attrsModifier {
                    attr("name", "Message")
                }
        )
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            MyButton(
                labelText = stringResource(StringRes.Submit)
            )
        }
    }
}