import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
//    alias(libs.plugins.kobwebx.markdown)
}

group = "com.ahmedhnewa.alrayada_landing_page"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            head.add {
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
                    "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css",
                    "stylesheet"
                )
            }
            description.set("Landing page for Alrayada Alarabiah company developed by Ahmed Hnewa and powered with kotlin and kobweb")
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
//                implementation(npm("@fortawesome/fontawesome-svg-core", "6.4.2"))
//                implementation(npm("@fortawesome/free-brands-svg-icons", "6.4.2"))
//                implementation(npm("@fortawesome/free-regular-svg-icons", "6.4.2"))
//                implementation(npm("@fortawesome/free-solid-svg-icons", "6.4.2"))
//                implementation(libs.kobwebx.markdown)
            }
        }

//        val jvmMain by getting {
//            dependencies {
//                implementation(libs.kobweb.api)
//            }
//        }
    }
}
