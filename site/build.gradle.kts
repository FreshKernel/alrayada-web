import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.meta

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
}

group = "net.freshplatform.alrayada_web"
version = "1.0-SNAPSHOT"

val webDesc =
    "Discover the Alrayada Alarabiah landing page – your gateway to the latest offerings and information from our company.  our page is your source for valuable insights and staying connected with us today!"
val baseUrl = "https://alrayada.net"
val image = "$baseUrl/assets/images/logo.webp"

kobweb {
    app {
        index {
            head.add {
                meta(
                    name = "apple-mobile-web-app-capable",
                    content = "yes"
                )
                meta(
                    name = "apple-mobile-web-app-status-bar-style",
                    content = "black"
                )
                meta(
                    name = "author",
                    content = "Ahmed Hnewa"
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
                implementation(libs.kobweb.silk)
//                implementation(libs.silk.icons.fa)
//                implementation(libs.kobweb.silk.icons.fa)
            }
        }
    }
}

// For SEO, we will have to use unique urls for each page
// Here we will use code generator to generate unique pages that redirect to the original pages

val languages = listOf("ar") // other than English
val pages = listOf("download_mobile_app", "privacy_policy", "delete_account_instructions") // all the pages in the `page` package

val generateLanguagesPagesTask = tasks.register("generateLanguagesPages") {
    group = "net.freshplatform.alrayada_web"

    doLast {
        val pagesDirectory = project.file("src/jsMain/kotlin/net/freshplatform/alrayada_web")
        languages.forEach { lang ->
            pages.forEach { page ->

                pagesDirectory.resolve("pages/$lang/${page}/Index.kt").apply {
                    parentFile.mkdirs()
                    writeText("""
                        package ${group}.pages.ar.${page}

                        import androidx.compose.runtime.Composable
                        import com.varabyte.kobweb.core.Page
                        import com.varabyte.kobweb.core.rememberPageContext

                        @Composable
                        @Page
                        fun PrivacyPolicyPage_${lang}() {
                            rememberPageContext().router.navigateTo("/${page}/?lang=${lang}")
                        }
                    """.trimIndent())
                }
            }

            pagesDirectory.resolve("pages/$lang/Index.kt").apply {
                parentFile.mkdirs()
                writeText("""
                        package ${group}.pages.ar

                        import androidx.compose.runtime.Composable
                        import com.varabyte.kobweb.core.Page
                        import com.varabyte.kobweb.core.rememberPageContext

                        @Composable
                        @Page
                        fun PrivacyPolicyPage_${lang}() {
                            rememberPageContext().router.navigateTo("/?lang=${lang}")
                        }
                    """.trimIndent())
            }

        }
    }
}