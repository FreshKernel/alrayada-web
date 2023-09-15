package com.ahmedhnewa.alrayada_landing_page.sections.products.models

import com.ahmedhnewa.alrayada_landing_page.utils.constants.PublicRes

enum class Product(
    val productName: String,
    val image: String,
    val originalPrice: Double,
    val discountPrice: Double,
    val company: String
) {
    One(
        productName = "Disposable Face Masks",
        image = PublicRes.Assets.Svg.LOGO,
        originalPrice = 15.99,
        discountPrice = 12.99,
        company = "MedicalCo"
    ),
    Two(
        productName = "Nitrile Examination Gloves",
        image = PublicRes.Assets.Svg.LOGO,
        originalPrice = 29.99,
        discountPrice = 24.99,
        company = "GloveTech"
    ),
    Three(
        productName = "Safety Goggles",
        image = PublicRes.Assets.Svg.LOGO,
        originalPrice = 9.99,
        discountPrice = 7.49,
        company = "EyeSafe"
    ),
    Four(
        productName = "Digital Thermometer",
        image = PublicRes.Assets.Svg.LOGO,
        originalPrice = 39.99,
        discountPrice = 34.99,
        company = "HealthSense"
    ),
    Five(
        productName = "Hand Sanitizer (500ml)",
        image = PublicRes.Assets.Svg.LOGO,
        originalPrice = 12.99,
        discountPrice = 9.99,
        company = "PureGuard"
    ),
    Six(
        productName = "Medical Scrubs",
        image = PublicRes.Assets.Svg.LOGO,
        originalPrice = 34.99,
        discountPrice = 29.99,
        company = "UniformEssentials"
    ),
    Seven(
        productName = "Infrared Forehead Thermometer",
        image = PublicRes.Assets.Svg.LOGO,
        originalPrice = 49.99,
        discountPrice = 42.99,
        company = "MediTemp"
    ),
    Eight(
        productName = "Pulse Oximeter",
        image = PublicRes.Assets.Svg.LOGO,
        originalPrice = 22.99,
        discountPrice = 18.99,
        company = "VitalCheck"
    ),
    Nine(
        productName = "Medical Face Shields",
        image = PublicRes.Assets.Svg.LOGO,
        originalPrice = 8.49,
        discountPrice = 6.99,
        company = "ShieldPro"
    ),
    Ten(
        productName = "Disposable Isolation Gowns",
        image = PublicRes.Assets.Svg.LOGO,
        originalPrice = 18.99,
        discountPrice = 15.99,
        company = "GuardianGear"
    ),
    Eleven(
        productName = "Isolation Gowns",
        image = PublicRes.Assets.Svg.LOGO,
        originalPrice = 20.0,
        discountPrice = 0.0,
        company = "GuardianGear"
    )
}