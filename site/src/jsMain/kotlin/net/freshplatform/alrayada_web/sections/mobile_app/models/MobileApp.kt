package net.freshplatform.alrayada_web.sections.mobile_app.models

import net.freshplatform.alrayada_web.utils.constants.SectionsConstants

enum class MobileApp(
    val title: String,
    val subtitle: String,
    val iconName: String,
    val downloadLink: String
) {
    GooglePlay(
        "GET IT ON",
        "Google play",
        "google-play",
        SectionsConstants.MobileApp.GOOGLE_PLAY
    ),
    AppleAppStore(
        "Download on The",
        "Apple Store",
        "apple",
        SectionsConstants.MobileApp.APPLE_APP_STORE
    )
}