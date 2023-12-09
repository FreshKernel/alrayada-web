package net.freshplatform.alrayada_landing_page.sections.our_suppliers.models

import net.freshplatform.alrayada_landing_page.core.data.StringRes
import net.freshplatform.alrayada_landing_page.utils.constants.PublicRes

enum class Supplier(
    val supplierName: String,
    val imagePath: String,
    val supplierDesc: StringRes
) {
    Dirui(
        "Dirui",
        PublicRes.Assets.Images.Brands.DIRUI_LOGO,
        StringRes.DiruiDesc
    ),
    Snibe(
        "Snibe",
        PublicRes.Assets.Images.Brands.SNIBE_LOGO,
        StringRes.SnibeDesc
    ),
    Lifotronic(
        "Lifotronic",
        PublicRes.Assets.Images.Brands.LIFOTRONIC_LOGO,
        StringRes.LifotronicDesc
    ),
    Urit(
        "Urit",
        PublicRes.Assets.Images.Brands.URIT,
        StringRes.UritDesc
    ),
}