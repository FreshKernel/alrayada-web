package net.freshplatform.alrayada_landing_page.sections.location.components

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_landing_page.components.fa.FaIcon
import net.freshplatform.alrayada_landing_page.components.fa.IconCategory
import net.freshplatform.alrayada_landing_page.models.ThemeColors
import net.freshplatform.alrayada_landing_page.sections.location.models.ContactUsData
import net.freshplatform.alrayada_landing_page.sections.location.models.ContactUsInfo
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ContactUsInformation(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .margin(right = 32.px)
            .then(modifier)
    ) {
        ContactUsInfo.entries.forEach {
            ContactUsItem(
                contactUsInfo = it,
                modifier = Modifier
                    .margin(bottom = 20.px)
            )
        }
    }
}

@Composable
private fun ContactUsItem(modifier: Modifier = Modifier, contactUsInfo: ContactUsInfo) {
    Row(
        modifier = Modifier
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .border(2.px, LineStyle.Solid, ThemeColors.Primary.colorValue)
                .borderRadius(r = 16.px)
                .margin(right = 12.px)
                .minWidth(70.px)
                .padding(18.px),
            contentAlignment = Alignment.Center
        ) {
            FaIcon(
                name = contactUsInfo.icon,
                style = IconCategory.SOLID,
                modifier = Modifier
                    .fontSize(22.px)
            )
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontSize(14.px)
                .toAttrs()
        ) {

            when (contactUsInfo.data) {
                is ContactUsData.EmailsText -> {
                    val emails = contactUsInfo.data.emails
                    emails.forEach {
                        ContactUsSharedLink(
                            text = it,
                            path = "mailto:$it",
                            modifier = Modifier,
                            alt = "Email link"
                        )
                        if (it != emails.last()) {
                            Text(" - ")
                        }
                    }
                }

                is ContactUsData.PhoneNumbersText -> {
                    val phoneNumbers = contactUsInfo.data.phoneNumbers
                    phoneNumbers.forEach {
                        ContactUsSharedLink(
                            modifier = Modifier,
                            text = it,
                            path = "tel:$it",
                            alt = "Phone number link"
                        )
                        if (it != phoneNumbers.last()) {
                            Text(" - ")
                        }
                    }
                }

                is ContactUsData.PlainText -> {
                    Text(contactUsInfo.data.text)
                }

                is ContactUsData.TextLink -> {
                    ContactUsSharedLink(
                        modifier = Modifier,
                        text = contactUsInfo.data.label,
                        path = contactUsInfo.data.link,
                        alt = "Website link"
                    )
                }
            }

        }
    }
}

@Composable
fun ContactUsSharedLink(
    modifier: Modifier = Modifier,
    text: String,
    path: String,
    alt: String
) {
    Link(
        modifier = Modifier
            .title(text)
            .color(Colors.Black)
            .textDecorationLine(TextDecorationLine.None)
            .attrsModifier {
                attr("alt", alt)
            }
            .then(modifier),
        text = text,
        path = path
    )
}