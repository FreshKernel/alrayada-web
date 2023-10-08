package com.ahmedhnewa.alrayada_landing_page.utils.constants

import com.ahmedhnewa.alrayada_landing_page.core.router.AppRouter

object SectionsConstants {
    object Location {
        const val MAP_API = "https://maps.google.com/maps?q=33.3118022,44.2733333&z=15&output=embed"
    }

    object Footer {
        const val REPOSITORY_URL = "https://github.com/freshtechtips/AlrayadaLandingPage"
    }

    object About {
        const val FORM_URL = "https://formspree.io/f/xjvqwrjq"
        private const val WHATSAPP_URL = "https://wa.me/+9647809640685"

        fun whatsappUrlWithText(text: String) = "${WHATSAPP_URL}?text=${js("encodeURIComponent")(text) as String}"
    }

    object MobileApp {
        // Don't add / in the link
//        private const val DYNAMIC_DOWNLOAD_LINK = "${Constants.BASE_URL}${AppRouter.DOWNLOAD_MOBILE_APP}" // because this could be on the backend, and it might be different urls
        private const val DYNAMIC_DOWNLOAD_LINK = AppRouter.DOWNLOAD_MOBILE_APP
        const val GOOGLE_PLAY = "https://play.google.com/store/apps/details?id=com.ahmedhnewa.alrayada"
        const val APPLE_APP_STORE = DYNAMIC_DOWNLOAD_LINK
    }
}