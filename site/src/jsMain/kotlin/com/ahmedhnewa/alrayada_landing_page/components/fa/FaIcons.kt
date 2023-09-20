package com.ahmedhnewa.alrayada_landing_page.components.fa

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier

@Composable
fun FaCheck(modifier: Modifier = Modifier, size: IconSize? = null) = FaIcon("check", modifier, IconCategory.SOLID, size)
@Composable
fun FaArrowUp(modifier: Modifier = Modifier, size: IconSize? = null) =
    FaIcon("arrow-up", modifier, IconCategory.SOLID, size)

@Composable
fun FaStarHalfStroke(modifier: Modifier = Modifier, style: IconStyle = IconStyle.OUTLINE, size: IconSize? = null) =
    FaIcon("star-half-stroke", modifier, style.category, size)

@Composable
fun FaStar(modifier: Modifier = Modifier, style: IconStyle = IconStyle.OUTLINE, size: IconSize? = null) =
    FaIcon("star", modifier, style.category, size)

@Composable
fun FaArrowUpRightFromSquare(modifier: Modifier = Modifier, size: IconSize? = null) =
    FaIcon("arrow-up-right-from-square", modifier, IconCategory.SOLID, size)

@Composable
fun FaCircle(modifier: Modifier = Modifier, style: IconStyle = IconStyle.OUTLINE, size: IconSize? = null) =
    FaIcon("circle", modifier, style.category, size)

@Composable
fun FaArrowLeft(modifier: Modifier = Modifier, size: IconSize? = null) =
    FaIcon("arrow-left", modifier, IconCategory.SOLID, size)

@Composable
fun FaArrowRight(modifier: Modifier = Modifier, size: IconSize? = null) =
    FaIcon("arrow-right", modifier, IconCategory.SOLID, size)

@Composable
fun FaGithub(modifier: Modifier = Modifier, size: IconSize? = null) =
    FaIcon("github", modifier, IconCategory.BRAND, size)

@Composable
fun FaWhatsapp(modifier: Modifier = Modifier, size: IconSize? = null) =
    FaIcon("whatsapp", modifier, IconCategory.BRAND, size)