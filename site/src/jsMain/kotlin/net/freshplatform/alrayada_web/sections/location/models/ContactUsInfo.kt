package net.freshplatform.alrayada_web.sections.location.models

import net.freshplatform.alrayada_web.utils.constants.Constants

sealed class ContactUsData {
    data class PlainText(
        val text: String
    ) : ContactUsData()

    data class EmailsText(
        val emails: List<String> = emptyList(),
    ) : ContactUsData()

    data class PhoneNumbersText(
        val phoneNumbers: List<String> = emptyList(),
    ) : ContactUsData()

    data class TextLink(
        val label: String,
        val link: String
    ) : ContactUsData()
}

enum class ContactUsInfo(
    val icon: String,
    val data: ContactUsData
) {
    One(
        "location-dot",
        ContactUsData.PlainText("بغداد / الحارثية / شارع الكندي / عمارة الفراتين / 2ط")
    ),
    Two(
        "phone",
        ContactUsData.PhoneNumbersText(
            listOf("+9647901520604")
        )
    ),
    Three(
        "envelope",
        ContactUsData.EmailsText(
            listOf("support@alrayada.net", "a.zeki@alrayada.com")
        )
    ),
    Four(
        "globe",
        ContactUsData.TextLink(
            "www.alrayada.net",
            Constants.SocialMediaLinks.WEBSITE,
        )
    )
}