package com.ahmedhnewa.alrayada_landing_page.sections.testimonial.componenets

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.core.MyImage
import com.ahmedhnewa.alrayada_landing_page.components.stars.RatingBar
import com.ahmedhnewa.alrayada_landing_page.models.ThemeColors
import com.ahmedhnewa.alrayada_landing_page.sections.testimonial.models.Testimonial
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun TestimonialCard(
    modifier: Modifier = Modifier,
    testimonial: Testimonial,
    breakpoint: Breakpoint
) {
    Row(
        modifier = Modifier
            .maxWidth(450.px)
            .height(250.px)
            .then(modifier),
    ) {
        MyImage(
            modifier = Modifier
                .margin(right = 20.px)
                .height(200.px)
                .objectFit(ObjectFit.Cover)
                .width(
                    if (breakpoint > Breakpoint.MD) 180.px
                    else 160.px
                )
                .borderRadius(
                    topLeft = 60.px,
                    topRight = 60.px,
                    bottomLeft = 60.px,
                    bottomRight = 0.px
                ),
            src = testimonial.image,
            contentDescription = "Avatar Image"
        )
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .margin(bottom = 20.px),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    P(
                        attrs = Modifier
                            .fillMaxWidth()
                            .margin(topBottom = 0.px)
                            .fontSize(18.px)
                            .fontWeight(FontWeight.Bold)
                            .color(ThemeColors.Secondary.colorValue)
                            .toAttrs()
                    ) {
                        Text(testimonial.fullName)
                    }
                    P(
                        attrs = Modifier
                            .fillMaxWidth()
                            .margin(topBottom = 0.px)
                            .fontSize(12.px)
                            .fontWeight(FontWeight.Normal)
                            .color(ThemeColors.Secondary.colorValue)
                            .toAttrs()
                    ) {
                        Text(testimonial.profession)
                    }
                    RatingBar(
                        value = 5,
                        modifier = Modifier
                            .displayUntil(Breakpoint.LG)
                            .margin(top = 10.px)
                    )
                }
                RatingBar(
                    modifier = Modifier.displayIfAtLeast(Breakpoint.LG),
                    value = 5
                )
            }
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontSize(18.px)
                    .opacity(70.percent)
                    .fontWeight(FontWeight.Normal)
                    .color(ThemeColors.Secondary.colorValue)
                    .toAttrs()
            ) {
                Text(testimonial.review)
            }
        }
    }
}