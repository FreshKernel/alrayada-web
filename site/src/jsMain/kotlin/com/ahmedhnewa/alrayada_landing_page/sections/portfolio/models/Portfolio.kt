package com.ahmedhnewa.alrayada_landing_page.sections.portfolio.models

import com.ahmedhnewa.alrayada_landing_page.utils.constants.PublicRes

enum class Portfolio(
    val image: String,
    val title: String,
    val description: String,
    val link: String
) {
    One(
        image = PublicRes.Assets.Images.FRESH_PLATFORM,
        title = "Fresh Platform",
        description = "This is my very first ecommerce project, it was simple and almost non profit, it was called Egt store, where I provide some simple services, it was done using wordpress with some custom plugins in php.",
        link = "https://freshplatform.net"
    ),
    Two(
        image = PublicRes.Assets.Images.DR_RIADH_LAB,
        title = "Dr.Riadh lab",
        description = "I made an native mobile app with a lot of features for this company, but it wasn't simple and users didn't know how to use it so I had to remake it into simple idea and very simple project, it's just a form where user sent their request order and they will deliver it later, the notifications will sent to admins using telegram bot since I already made a desktop app and they was quite busy to use another application so I made this thing simpler too, the website is it's very fast especially for free hosting, I didn't use any frameworks like next js or kobweb or even react js, it's built from scratch without any layers or engine to load.",
        link = "https://dr-riadhlab.com"
    ),
    Three(
        image = PublicRes.Assets.Images.ALRAYADA_PROJECT,
        title = "Alrayada Company",
        description = "I have been waiting to make this app since covid 19, I have to delay it for a few years for reasons, it originally made for android and the design written in xml and I have to remake it to jetpack compose but I was a bit in hurry to make the design twice for Android and iOS so I have to do it using flutter in the end with ktor server, the app is ecommerce application for medical lab supplies provider with a lot of features.",
        link = "https://alrayada.net"
    ),
    Four(
        image = PublicRes.Assets.Images.WALLPAPER_ENGINE,
        title = "Wallpaper engine port for linux",
        description = "Since I'm Linux fanboy I would like to use wallpapers of wallpaper engine windows program in linux but it's not supported, the wallpapers was only support photo with sound or videos, with no animated wallpapers since the engine was originally made for windows and there is no way I could make it work for all desktop environments",
        link = "https://github.com/ahmedhnewa/WallpaperEngineLinux"
    ),
    Five(
        image = PublicRes.Assets.Images.AHMED_HNEWA_SOCIAL_MEDIA,
        title = "Other projects on github",
        description = "This is just some of the projects I made, I have some other projects that I didn't publish on github like some games or old java projects since I was little, you can check my repositories on github = ahmedhnewa, and of course this is just the start for me like any other person",
        link = "https://github.com/ahmedhnewa?tab=repositories"
    )
}