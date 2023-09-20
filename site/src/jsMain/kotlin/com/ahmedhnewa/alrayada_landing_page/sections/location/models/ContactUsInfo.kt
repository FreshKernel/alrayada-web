package com.ahmedhnewa.alrayada_landing_page.sections.location.models

import com.ahmedhnewa.alrayada_landing_page.utils.constants.Constants

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
            listOf("+9647704067116", "+9647714758432", "+9647809640685")
        )
    ),
    Three(
        "envelope",
        ContactUsData.EmailsText(
            listOf("mohammad.alhadi@alrayada.net", "support@alrayada.net")
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