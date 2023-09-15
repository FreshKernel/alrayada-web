package com.ahmedhnewa.alrayada_landing_page.utils.constants

object PublicRes {
    object Assets {
        private const val PATH = "assets"

        object Images {
            private const val PATH = "${Assets.PATH}/images"
            const val MAIN = "$PATH/main_image.webp"
            const val ABOUT = "$PATH/about_image.webp"

            object Brands {
                private const val PATH = "${Images.PATH}/brands"
                const val SNIBE_LOGO = "${PATH}/snibe_logo.webp"
                const val DIRUI_LOGO = "${PATH}/dirui_logo.webp"
                const val LIFOTRONIC_LOGO = "${PATH}/lifotronic_logo.webp"
                const val URIT = "${PATH}/urit_logo.webp"
            }

            object Labs {
                private const val PATH = "${Images.PATH}/labs"
                const val MEDICAL_LAB1 = "$PATH/medical_lab1.webp"
                const val MEDICAL_LAB2 = "$PATH/medical_lab2.webp"
            }

            object Testimonials {
                private const val PATH = "${Images.PATH}/testimonials"

//                const val ALBERT_EINSTEIN = "$PATH/albert_einstein.jpg"
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