import com.varabyte.kobweb.gradle.application.extensions.AppBlock
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
                    content = "Fresh Platform"
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
                    href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css",
                    rel = "stylesheet",
                ) {
                    integrity =
                        "sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
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
    js {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions.target = "es2015"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(libs.compose.html.core)
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
val pages = listOf("downloadMobileApp", "privacyPolicy", "deleteAccountInstructions") // all the pages in the `page` package

tasks.register("generateLanguagesPages") {

    fun toKebabCase(input: String): String {
        var result = input.replace(Regex("([a-z])([A-Z])")) {
            "${it.groupValues[1]}-${it.groupValues[2]}"
        }

        result = result.replace("_", "-")

        return result.lowercase()
    }

    doLast {
        val pagesDirectory = project.file("src/jsMain/kotlin/net/freshplatform/alrayada_web")
        languages.forEach { lang ->
            pages.forEach { page ->

                pagesDirectory.resolve("pages/$lang/${page}/Index.kt").apply {
                    parentFile.mkdirs()
                    writeText("""
                        package ${project.group}.pages.ar.${page}
                        
                        // GENERATED FILE - DON'T MODIFY BY HAND

                        import androidx.compose.runtime.Composable
                        import com.varabyte.kobweb.core.Page
                        import com.varabyte.kobweb.core.rememberPageContext

                        @Composable
                        @Page
                        fun PrivacyPolicyPage_${lang}() {
                            rememberPageContext().router.navigateTo("/${toKebabCase(page)}/?lang=${lang}")
                        }
                    """.trimIndent())
                }
            }

            pagesDirectory.resolve("pages/$lang/Index.kt").apply {
                parentFile.mkdirs()
                writeText("""
                        package ${project.group}.pages.ar
                        
                        // GENERATED FILE - DON'T MODIFY BY HAND

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