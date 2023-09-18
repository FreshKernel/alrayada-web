package com.ahmedhnewa.alrayada_landing_page.sections.contact.components

import androidx.compose.runtime.*
import com.ahmedhnewa.alrayada_landing_page.components.core.CenterHorizontally
import com.ahmedhnewa.alrayada_landing_page.components.core.MyButton
import com.ahmedhnewa.alrayada_landing_page.components.fa.FaWhatsapp
import com.ahmedhnewa.alrayada_landing_page.components.fa.IconSize
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.getStringResource
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.utils.constants.SectionsConstants
import com.ahmedhnewa.alrayada_landing_page.utils.getInputValueById
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.navigation.open
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Form
import org.jetbrains.compose.web.dom.Text

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
        val nameInputId = "nameInput"
        val emailInputId = "emailInput"
        val messageInputId = "messageInput"

        MyTextInput(
            id = nameInputId,
            hintText = stringResource(StringRes.FullName),
            labelText = stringResource(StringRes.Name),
            type = InputType.Text,
            breakpoint = breakpoint,
            formInputName = "Name",
            modifier = Modifier
                .margin(bottom = 12.px)
        )
        MyTextInput(
            id = emailInputId,
            hintText = stringResource(StringRes.EmailAddress),
            labelText = stringResource(StringRes.Email),
            type = InputType.Email,
            breakpoint = breakpoint,
            formInputName = "Email",
            modifier = Modifier.margin(bottom = 12.px),
        )
        MyTextInput(
            id = messageInputId,
            hintText = stringResource(StringRes.YourMessage),
            labelText = stringResource(StringRes.Message),
            textArea = true,
            breakpoint = breakpoint,
            formInputName = "Message",
            modifier = Modifier
                .margin(bottom = 20.px)
                .height(150.px)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MyButton(
                type = ButtonType.Submit
            ) {
                Text(stringResource(StringRes.Submit))
            }
            MyButton(
                type = ButtonType.Button,
                modifier = Modifier
                    .title(stringResource(StringRes.Whatsapp))
                    .onClick {
                        val nameInputValue = getInputValueById(nameInputId)
                        val emailInputValue = getInputValueById(emailInputId)
                        val messageInputValue = getInputValueById(messageInputId)

                        val text = buildString {
                            append(getStringResource(StringRes.Hi))
                            if (nameInputValue.isNotBlank())
                                append(" ${getStringResource(StringRes.MyNameIs)} $nameInputValue.\n")
                            if (emailInputValue.isNotBlank())
                                append("${getStringResource(StringRes.MyEmailAddressIs)} $emailInputValue.\n")
                            if (messageInputValue.isNotBlank())
                                append("${getStringResource(StringRes.MyMessageIs)} $messageInputValue")
                        }

                        val url = SectionsConstants.About.whatsappUrlWithText(text)
//                        window.location.href = url
//                        window.location.replace(url)
                        window.open(url, OpenLinkStrategy.IN_NEW_TAB)
                    }
            ) {
                FaWhatsapp(
                    size = IconSize.XL
                )
            }
        }
    }
}