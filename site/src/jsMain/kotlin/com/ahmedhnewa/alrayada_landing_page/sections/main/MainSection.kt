package com.ahmedhnewa.alrayada_landing_page.sections.main

import androidx.compose.runtime.*
import com.ahmedhnewa.alrayada_landing_page.components.core.MyImage
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.stringResource
import com.ahmedhnewa.alrayada_landing_page.sections.main.compoments.MyHeader
import com.ahmedhnewa.alrayada_landing_page.models.AppSection
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.ahmedhnewa.alrayada_landing_page.sections.main.compoments.MobileNavigation
import com.ahmedhnewa.alrayada_landing_page.sections.main.compoments.SocialBar
import com.ahmedhnewa.alrayada_landing_page.styles.MainButtonStyle
import com.ahmedhnewa.alrayada_landing_page.utils.constants.Constants
import com.ahmedhnewa.alrayada_landing_page.utils.constants.PublicRes
import com.ahmedhnewa.alrayada_landing_page.utils.extensions.asWebPath
import com.ahmedhnewa.alrayada_landing_page.utils.extensions.removeCharAtIndex
import com.ahmedhnewa.alrayada_landing_page.utils.isLastDayOfTheYear
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.grayscale
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.*
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayBetween
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


@Composable
fun MainSection() = Box(
    contentAlignment = Alignment.TopCenter
) {
    MainBackground()
    MainContent()
}

@Composable
private fun MainBackground() = MyImage(
    modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover),
    src = PublicRes.Assets.Svg.BACKGROUND,
    contentDescription = "Background Image",
    lazyLoading = false
)

@Composable
private fun MainContent() = Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceBetween, // Not necessary
    horizontalAlignment = Alignment.CenterHorizontally
) {
    MyHeader() // fill max width (80 to 90 percent)
    MobileNavigation(modifier = Modifier.displayUntil(Breakpoint.LG))
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // same content on all screens
        val content: @Composable () -> Unit = {
            MainText()
            MainImage()
        }
        val numColumns = numColumns(base = 1, md = 2)
        // For large screens and above
        SimpleGrid(
            modifier = Modifier.displayIfAtLeast(Breakpoint.LG).fillMaxWidth(80.percent),
            numColumns = numColumns
        ) {
            content()
        }
        // For small - medium screens
        SimpleGrid(
            modifier = Modifier.displayBetween(Breakpoint.SM, Breakpoint.LG).fillMaxWidth(90.percent),
            numColumns = numColumns
        ) {
            content()
        }
    }
}

val helloTextStyle by ComponentStyle {
    base {
        Modifier
            .scale(1.0)
            .margin(topBottom = 0.px)
            .fontSize(45.px)
            .fontWeight(FontWeight.Normal)
            .color(ThemeColors.PreviousPrimary.colorValue)
            .transition(CSSTransition(property = "scale", duration = 300.ms))
            .transition(CSSTransition(property = "transform", duration = 200.ms))
            .rotate(0.deg)
    }
    hover {
        Modifier.scale(1.2)
            .rotate(3.deg)
    }
}

@Composable
private fun MainText() {
    val firstChar = 'H'
    var helloText by remember { mutableStateOf("Hello, We are") }
    @Composable
    fun AnimateHelloText() {
//        if (!isLastDayOfTheYear()) {
//            return
//        }
        if (window.matchMedia("(max-width: 768px").matches) {
            return
        }

        var isPlusOperator = true

        LaunchedEffect(Unit) {
            delay(2000L)
            val value = helloText
            helloText = ""

            while (true) {

                for (charIndex in value.indices) {
                    if (isPlusOperator) {
                        helloText += value[charIndex]
                        delay(200L)
                        continue
                    }
                    if (helloText[helloText.lastIndex] == firstChar) {
                        isPlusOperator = !isPlusOperator
                        continue
                    }
                    helloText = helloText.removeCharAtIndex(helloText.lastIndex)
                    delay(100L)
                }
                isPlusOperator = !isPlusOperator
            }
        }
    }
    if (Constants.ANIMATION_ENABLED) {
        AnimateHelloText()
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SocialBar(modifier = Modifier.displayIfAtLeast(Breakpoint.LG))
        Column {
            P(
                attrs = helloTextStyle
                    .toModifier()
                    .displayIfAtLeast(Breakpoint.MD)
                    .toAttrs()
            ) {
                Text(helloText)
            }
            P(
                attrs = Modifier
                    .displayIfAtLeast(Breakpoint.LG)
                    .margin(top = 20.px, bottom = 0.px)
                    .fontSize(68.px)
                    .fontWeight(FontWeight.Bolder)
                    .color(ThemeColors.Secondary.colorValue)
                    .toAttrs()
            ) {
                Text(stringResource(StringRes.AlrayadaAlarabiah))
            }
            P(
                attrs = Modifier
                    .displayBetween(Breakpoint.SM, Breakpoint.LG)
                    .margin(top = 20.px, bottom = 0.px)
                    .fontSize(40.px)
                    .fontWeight(FontWeight.Bolder)
                    .color(ThemeColors.Secondary.colorValue)
                    .toAttrs()
            ) {
                Text(stringResource(StringRes.AlrayadaAlarabiah))
            }
            P(
                attrs = Modifier
                    .margin(top = 10.px, bottom = 5.px)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(ThemeColors.Secondary.colorValue)
                    .toAttrs()
            ) {
                Text(stringResource(StringRes.CompanyProfile))
            }
            P(
                attrs = Modifier
                    .margin(bottom = 5.px)
                    .maxWidth(400.px)
                    .fontSize(15.px)
                    .fontStyle(FontStyle.Italic)
                    .fontWeight(FontWeight.Normal)
                    .color(ThemeColors.Secondary.colorValue)
                    .toAttrs()
            ) {
                Text(stringResource(StringRes.SkyOurLimits))
            }
            Button(
                attrs = MainButtonStyle.toModifier()
                    .margin(bottom = 20.px, top = 10.px)
                    .toAttrs()
            ) {
                val text = stringResource(StringRes.ContactUs)
                Link(
                    modifier = Modifier
                        .color(Colors.White)
                        .textDecorationLine(TextDecorationLine.None)
                        .title(text),
                    path = AppSection.Contact.id.asWebPath(),
                    openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
                    text = text,
                )
            }
        }
    }
}

val MainImageStyle by ComponentStyle {
    base {
        Modifier
            .filter(grayscale(100.percent))
            .transition(CSSTransition(property = "filter", duration = 240.ms))
    }
    hover {
        Modifier
            .filter(grayscale(0.percent))
    }

}

@Composable
fun MainImage() = Column(
    modifier = MainImageStyle.toModifier()
        .fillMaxSize(80.percent).fillMaxHeight(),
    verticalArrangement = Arrangement.Bottom
) {
    MyImage(
        modifier = Modifier.fillMaxWidth().objectFit(ObjectFit.Cover),
        src = PublicRes.Assets.Images.MAIN,
        contentDescription = "Person Photo",
        lazyLoading = false
    )
}