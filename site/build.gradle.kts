import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.meta

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
}

group = "com.ahmedhnewa.alrayada_landing_page"
version = "1.0-SNAPSHOT"

val webDesc =
    "Discover the Alrayada Alarabiah landing page – your gateway to the latest offerings and information from our company. Developed by Ahmed Hnewa, our page is your source for valuable insights and powered by the innovation of Kotlin and Kobweb. Explore, engage, and stay connected with us today!"
val image = "https://alrayada.net/assets/images/logo.webp"
val baseUrl = "https://alrayada.net"

kobweb {
    app {
        index {
            head.add {
                meta(
                    name = "apple-mobile-web-app-capable",
                    content = "yes"
                )
                meta(
                    name = "author",
                    content = "Ahmed Hnewa"
                )
//                meta {
//                    httpEquiv = "Content-Security-Policy"
//                    content = "default-src 'self' cdnjs.cloudflare.com"
//                }
                meta(
                    name = "referrer",
                    content = "no-referrer"
                )
                meta {
                    attributes["property"] = "og:title"
                    content = "Alrayada"
                }
                meta {
                    attributes["property"] = "og:description"
                    content = webDesc
                }
                meta {
                    attributes["property"] = "og:image"
                    content = image
                }
                meta {
                    attributes["property"] = "og:url"
                    content = baseUrl
                }
                meta(
                    name = "twitter:card",
                    content = "summary"
                )
                meta(
                    name = "twitter:title",
                    content = "Alrayada"
                )
                meta(
                    name = "twitter:description",
                    content = webDesc
                )
                meta(
                    name = "twitter:image",
                    content = image
                )
                meta(
                    name = "copyright",
                    content = "© 2023 Alrayada"
                )
                meta(
                    name = "robots",
                    content = "index, follow"
                )
                link(
                    rel = "canonical",
                    href = baseUrl
                )
                link(
                    rel = "alternate",
                    href = baseUrl,
                ) {
                    attributes["hreflang"] = "x-default"
                }
                link(
                    rel = "alternate",
                    href = "$baseUrl/?lang=ar",
                ) {
                    attributes["hreflang"] = "ar"
                }
                link(
                    rel = "alternate",
                    href = "$baseUrl/?lang=en",
                ) {
                    attributes["hreflang"] = "en"
                }
                link {
                    rel = "apple-touch-icon"
                    sizes = "180x180"
                    href = "/apple-touch-icon.png"
                }
                link {
                    rel = "icon"
                    type = "image/png"
                    sizes = "32x32"
                    href = "/favicon-32x32.png"
                }
                link {
                    rel = "icon"
                    type = "image/png"
                    sizes = "16x16"
                    href = "/favicon-16x16.png"
                }
                link(
                    href = "/site.webmanifest",
                    rel = "manifest"
                )
                link(
                    href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css",
                    rel = "stylesheet",
                ) {
                    integrity =
                        "sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
                    attributes["crossorigin"] = "anonymous"
                    attributes["referrerpolicy"] = "no-referrer"
                }
            }
            description.set(webDesc)
        }
    }
}

kotlin {
    configAsKobwebApplication("app", includeServer = false)

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
//                implementation(libs.kobweb.silk.icons.fa)
            }
        }
    }
}
