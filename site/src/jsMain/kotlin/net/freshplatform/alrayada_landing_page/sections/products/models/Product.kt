package net.freshplatform.alrayada_landing_page.sections.products.models

import net.freshplatform.alrayada_landing_page.utils.constants.PublicRes

enum class Product(
    val companyName: String,
    val link: String,
    val image: String
) {
    Snibe(
        companyName = "Snibe",
        link = "https://www.snibe.com/zh_en/en_products.aspx?id=65",
        image = PublicRes.Assets.Images.Brands.SNIBE_LOGO
    ),
    Dirui(
        companyName = "Dirui",
        link = "http://en.dirui.com.cn/list-22-1.html",
        image = PublicRes.Assets.Images.Brands.DIRUI_LOGO
    ),
    Lifotronic(
        companyName = "Lifotronic",
        link = "http://en.lifotronic.com/products/",
        image = PublicRes.Assets.Images.Brands.LIFOTRONIC_LOGO
    ),
    Urit(
        companyName = "Urit",
        link = "http://www.urit.com/en2/cpjjfa/list.aspx?lcid=15",
        image = PublicRes.Assets.Images.Brands.URIT_LOGO
    ),
    Caretium(
        companyName = "Caretium",
        link = "https://en.caretium.com/Product/989558469800067072.html",
        image = PublicRes.Assets.Images.Brands.CARETIUM_LOGO
    )
}