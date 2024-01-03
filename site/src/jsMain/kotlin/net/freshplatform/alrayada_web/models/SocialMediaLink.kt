package net.freshplatform.alrayada_web.models

import net.freshplatform.alrayada_web.utils.constants.Constants

enum class SocialMediaLink(
    val path: String,
    val iconName: String
) {
    Facebook(
        Constants.SocialMediaLinks.FACEBOOK,
        "facebook"
    ),
    Twitter(
        Constants.SocialMediaLinks.TWITTER,
        "twitter"
    ),
    Instagram(
        Constants.SocialMediaLinks.INSTAGRAM,
        "instagram"
    ),
    Linkedin(
        Constants.SocialMediaLinks.LINKEDIN,
        "linkedin"
    )
}