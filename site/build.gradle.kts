import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.meta
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
}

group = "net.freshplatform.alrayada_web"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            val webDesc =
                "Discover the Alrayada Alarabiah landing page – your gateway to the latest offerings and information from our company.  our page is your source for valuable insights and staying connected with us today!"
            val baseUrl = "https://alrayada.net"
            val image = "$baseUrl/assets/images/logo.webp"

            head.add {
                meta(
                    name = "mobile-web-app-capable",
                    content = "yes"
                )
                meta(
                    name = "apple-mobile-web-app-status-bar-style",
                    content = "black"
                )
                meta(
                    name = "author",
                    content = "Fresh Kernel"
                )
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
                    content = "© 2024 Alrayada"
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
                    href = "$baseUrl/ar/",
                ) {
                    attributes["hreflang"] = "ar"
                }
                link(
                    rel = "alternate",
                    href = baseUrl,
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
                    href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css",
                    rel = "stylesheet",
                )
            }
            description.set(webDesc)
        }
    }
}

kotlin {
    configAsKobwebApplication("app", includeServer = false)

    js {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions.target = "es2015"
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
        }

        jsMain.dependencies {
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
//            implementation(libs.silk.icons.fa)
//            implementation(libs.kobweb.silk.icons.fa)
        }
    }
}
