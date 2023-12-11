package net.freshplatform.alrayada_landing_page.sections.products_old.models

import net.freshplatform.alrayada_landing_page.utils.constants.PublicRes

enum class ProductCategory(
    val categoryName: String
) {
    Apple(
        "Apple"
    ),
    Samsung(
        "Samsung"
    ),
    Huawei(
        "Huawei"
    ),
    Sony(
        "Sony"
    )
}

enum class Product(
    val productName: String,
    val productDesc: String,
    val image: String,
    val originalPrice: Double,
    val discountPrice: Double,
    val company: String,
    val category: ProductCategory = ProductCategory.Samsung
) {
    One(
        productName = "Disposable Face Masks",
        productDesc = "Protect yourself and others with these comfortable disposable face masks.",
        image = PublicRes.Assets.Images.LOGO,
        originalPrice = 15.99,
        discountPrice = 12.99,
        company = "MedicalCo",
        category = ProductCategory.Apple
    ),
    Two(
        productName = "Nitrile Examination Gloves",
        productDesc = "High-quality nitrile gloves for medical and laboratory use.",
        image = PublicRes.Assets.Images.LOGO,
        originalPrice = 29.99,
        discountPrice = 24.99,
        company = "GloveTech",
        category = ProductCategory.Sony
    ),
    Three(
        productName = "Safety Goggles",
        productDesc = "Protect your eyes with these impact-resistant safety goggles.",
        image = PublicRes.Assets.Images.LOGO,
        originalPrice = 9.99,
        discountPrice = 7.49,
        company = "EyeSafe",
        category = ProductCategory.Huawei
    ),
    Four(
        productName = "Digital Thermometer",
        productDesc = "Accurate digital thermometer for measuring body temperature.",
        image = PublicRes.Assets.Images.LOGO,
        originalPrice = 39.99,
        discountPrice = 34.99,
        company = "HealthSense",
        category = ProductCategory.Huawei
    ),
    Five(
        productName = "Hand Sanitizer (500ml)",
        productDesc = "Stay germ-free with our 500ml hand sanitizer gel.",
        image = PublicRes.Assets.Images.LOGO,
        originalPrice = 12.99,
        discountPrice = 9.99,
        company = "PureGuard",
        category = ProductCategory.Huawei
    ),
    Six(
        productName = "Medical Scrubs",
        productDesc = "Comfortable and durable medical scrubs for healthcare professionals.",
        image = PublicRes.Assets.Images.LOGO,
        originalPrice = 34.99,
        discountPrice = 29.99,
        company = "UniformEssentials",
        category = ProductCategory.Samsung
    ),
    Seven(
        productName = "Infrared Forehead Thermometer",
        productDesc = "Quick and accurate infrared thermometer for forehead temperature measurement.",
        image = PublicRes.Assets.Images.LOGO,
        originalPrice = 49.99,
        discountPrice = 42.99,
        company = "MediTemp",
        category = ProductCategory.Samsung
    ),
    Eight(
        productName = "Pulse Oximeter",
        productDesc = "Measure your pulse rate and blood oxygen levels with this convenient oximeter.",
        image = PublicRes.Assets.Images.LOGO,
        originalPrice = 22.99,
        discountPrice = 18.99,
        company = "VitalCheck",
        category = ProductCategory.Sony
    ),
    Nine(
        productName = "Medical Face Shields",
        productDesc = "Clear and protective face shields for medical professionals.",
        image = PublicRes.Assets.Images.LOGO,
        originalPrice = 8.49,
        discountPrice = 6.99,
        company = "ShieldPro",
        category = ProductCategory.Apple
    ),
    Ten(
        productName = "Disposable Isolation Gowns",
        productDesc = "Single-use isolation gowns for healthcare settings.",
        image = PublicRes.Assets.Images.LOGO,
        originalPrice = 18.99,
        discountPrice = 15.99,
        company = "GuardianGear",
        category = ProductCategory.Apple
    ),
    Eleven(
        productName = "Isolation Gowns",
        productDesc = "Reusable isolation gowns designed for safety and comfort.",
        image = PublicRes.Assets.Images.LOGO,
        originalPrice = 20.0,
        discountPrice = 0.0,
        company = "GuardianGear",
        category = ProductCategory.Sony
    )
}