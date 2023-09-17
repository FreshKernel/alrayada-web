package com.ahmedhnewa.alrayada_landing_page.utils.constants

import com.ahmedhnewa.alrayada_landing_page.core.router.AppRouter

object SectionsConstants {
    object Location {
        const val MAP_API = "https://maps.google.com/maps?q=33.3118022,44.2733333&z=15&output=embed"
    }
    object Footer {
        const val REPOSITORY_URL = "https://github.com/ahmedhnewa/AlrayadaLandingPage"
    }
    object About {
        const val FORM_URL = "https://formspree.io/f/xjvqwrjq"
    }
    object MobileApp {
        // Don't add / in the link
        const val DYNAMIC_DOWNLOAD_LINK = "${Constants.BASE_URL}${AppRouter.DOWNLOAD_MOBILE_APP}"
        const val GOOGLE_PLAY = "https://play.google.com/store/apps/details?id=com.ahmedhnewa.alrayada"
        const val APPLE_APP_STORE = ""
    }
}