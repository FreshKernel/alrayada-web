package com.ahmedhnewa.alrayada_landing_page.utils.constants

object PublicRes {
    object Assets {
        private const val PATH = "assets"

        object Images {
            private const val PATH = "${Assets.PATH}/images"
            const val MAIN = "$PATH/main_image.webp"
            const val ABOUT = "$PATH/about_image.webp"
            const val FRESH_PLATFORM = "$PATH/fresh_platform.png"
            const val DR_RIADH_LAB = "$PATH/dr_riadh_lab.png"
            const val ALRAYADA_PROJECT = "$PATH/alrayada_project.png"
            const val WALLPAPER_ENGINE = "$PATH/wallpaper_engine.jpg"
            const val AHMED_HNEWA_SOCIAL_MEDIA = "$PATH/ahmedhnewa_social_media.png"

            object Brands {
                private const val PATH = "${Images.PATH}/brands"
                const val SNIBE_LOGO = "${PATH}/snibe_logo.jpg"
                const val DIRUI_LOGO = "${PATH}/dirui_logo.png"
                const val LIFOTRONIC_LOGO = "${PATH}/lifotronic_logo.png"
                const val URIT = "${PATH}/urit_logo.jpg"
            }

            object Labs {
                private const val PATH = "${Images.PATH}/labs"
                const val MEDICAL_LAB1 = "$PATH/medical_lab1.jpeg"
                const val MEDICAL_LAB2 = "$PATH/medical_lab2.jpeg"
            }

            object Testimonials {
                private const val PATH = "${Images.PATH}/testimonials"

                const val ALBERT_EINSTEIN = "$PATH/albert_einstein.jpg"
                const val STEVE_JOBS = "$PATH/steve_jobs.jpeg"
                const val THOMAS_EDISON = "$PATH/thomas_edison.jpg"
                const val JOHN_WICK = "$PATH/john_wick.jpg"
                const val UNCLE_BOB = "$PATH/uncle_bob.png"
                const val MARCIN_IWINSKI = "$PATH/marcin_iwinski.jpg"
            }
        }

        object Svg {
            private const val PATH = "${Assets.PATH}/svg"
            const val LOGO = "$PATH/logo.svg"
            const val BACKGROUND = "$PATH/background.svg"

            object Waves {
                private const val PATH = "${Svg.PATH}/waves"
                const val WAVE_1 = "$PATH/wave_1.svg"
                const val WAVE_2 = "$PATH/wave_2.svg"
                const val WAVE_3 = "$PATH/wave_3.svg"
                const val WAVE_4 = "$PATH/wave_4.svg"
                const val WAVE_5 = "$PATH/wave_5.svg"
            }
        }
    }
}