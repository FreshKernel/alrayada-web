package net.freshplatform.alrayada_web.sections.portfolio.models

import net.freshplatform.alrayada_web.utils.constants.PublicRes

enum class Portfolio(
    val image: String,
    val title: String,
    val description: String,
    val link: String
) {
    One(
        image = PublicRes.Assets.Images.LOGO,
        title = "Fresh Platform",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vitae metus ac tortor faucibus tristique sit amet vel magna. Cras malesuada mi a urna varius, nec tempus justo suscipit. Integer pharetra felis sit amet magna scelerisque, in feugiat ante consequat. Donec fringilla enim vel risus tempor, at placerat purus rutrum. Phasellus sit amet augue ut ante vestibulum elementum. Aliquam erat volutpat. Ut quis felis id ligula pharetra gravida vel non purus. Sed sit amet purus id dui sollicitudin pharetra. Vivamus hendrerit lorem ut dolor maximus, et pharetra ipsum dictum.\n",
        link = "https://freshplatform.net"
    ),
    Two(
        image = PublicRes.Assets.Images.LOGO,
        title = "Dr.Riadh lab",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vitae metus ac tortor faucibus tristique sit amet vel magna. Cras malesuada mi a urna varius, nec tempus justo suscipit. Integer pharetra felis sit amet magna scelerisque, in feugiat ante consequat. Donec fringilla enim vel risus tempor, at placerat purus rutrum. Phasellus sit amet augue ut ante vestibulum elementum. Aliquam erat volutpat. Ut quis felis id ligula pharetra gravida vel non purus. Sed sit amet purus id dui sollicitudin pharetra. Vivamus hendrerit lorem ut dolor maximus, et pharetra ipsum dictum.\n",
        link = "https://dr-riadhlab.com"
    ),
    Three(
        image = PublicRes.Assets.Images.LOGO,
        title = "Alrayada Company",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vitae metus ac tortor faucibus tristique sit amet vel magna. Cras malesuada mi a urna varius, nec tempus justo suscipit. Integer pharetra felis sit amet magna scelerisque, in feugiat ante consequat. Donec fringilla enim vel risus tempor, at placerat purus rutrum. Phasellus sit amet augue ut ante vestibulum elementum. Aliquam erat volutpat. Ut quis felis id ligula pharetra gravida vel non purus. Sed sit amet purus id dui sollicitudin pharetra. Vivamus hendrerit lorem ut dolor maximus, et pharetra ipsum dictum.\n",
        link = "https://alrayada.net"
    ),
    Four(
        image = PublicRes.Assets.Images.LOGO,
        title = "Wallpaper engine port for linux",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vitae metus ac tortor faucibus tristique sit amet vel magna. Cras malesuada mi a urna varius, nec tempus justo suscipit. Integer pharetra felis sit amet magna scelerisque, in feugiat ante consequat. Donec fringilla enim vel risus tempor, at placerat purus rutrum. Phasellus sit amet augue ut ante vestibulum elementum. Aliquam erat volutpat. Ut quis felis id ligula pharetra gravida vel non purus. Sed sit amet purus id dui sollicitudin pharetra. Vivamus hendrerit lorem ut dolor maximus, et pharetra ipsum dictum.\n",
        link = "https://github.com/freshtechtips/WallpaperEngineLinux"
    ),
    Five(
        image = PublicRes.Assets.Images.LOGO,
        title = "Other projects on github",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vitae metus ac tortor faucibus tristique sit amet vel magna. Cras malesuada mi a urna varius, nec tempus justo suscipit. Integer pharetra felis sit amet magna scelerisque, in feugiat ante consequat. Donec fringilla enim vel risus tempor, at placerat purus rutrum. Phasellus sit amet augue ut ante vestibulum elementum. Aliquam erat volutpat. Ut quis felis id ligula pharetra gravida vel non purus. Sed sit amet purus id dui sollicitudin pharetra. Vivamus hendrerit lorem ut dolor maximus, et pharetra ipsum dictum.\n",
        link = "https://github.com/freshtechtips?tab=repositories"
    )
}