package net.freshplatform.alrayada_web.sections.products_old.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.grayscale
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import net.freshplatform.alrayada_web.components.core.MyImage
import net.freshplatform.alrayada_web.components.stars.RatingBar
import net.freshplatform.alrayada_web.models.ThemeColors
import net.freshplatform.alrayada_web.sections.products_old.models.Product
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val OldProductImageStyle = CssStyle {
    base {
        Modifier
            .filter(grayscale(0.percent))
            .transition(Transition.of(property = "filter", duration = 240.ms))
    }
    hover {
        Modifier
            .filter(grayscale(100.percent))
    }

}

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product
) {
    Column(
        modifier = Modifier
            .margin(all = 6.px)
            .padding(leftRight = 12.px, topBottom = 16.px)
            .width(300.px)
            .onClick {
                window.alert("More details here: ${product.productDesc}")
            }
            .then(modifier)
    ) {
        MyImage(
            modifier = OldProductImageStyle
                .toModifier()
                .height(250.px)
                .fillMaxWidth()
                .borderRadius(r = 8.px)
                .objectFit(ObjectFit.Cover),
            src = product.image,
            contentDescription = "${product.productName} Image",
        )
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(top = 7.px, bottom = 2.px)
                .fontSize(13.px)
                .fontWeight(FontWeight.Bold)
                .textAlign(TextAlign.Center)
                .toAttrs()
        ) {
            Text(product.company)
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .textAlign(TextAlign.Center)
                .toAttrs()
        ) {
            Text(product.productName)
        }
        Box(
            modifier = Modifier
                .margin(topBottom = 5.px)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            RatingBar()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .margin(right = 5.px)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textAlign(TextAlign.Center)
                    .color(ThemeColors.Primary.colorValue)
                    .toAttrs()
            ) {
                Text("$${product.originalPrice}")
            }
            if (product.originalPrice > product.discountPrice && product.discountPrice != 0.0) {
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Normal)
                        .textDecorationLine(TextDecorationLine.LineThrough)
                        .color(ThemeColors.Secondary.colorValue)
                        .toAttrs()
                ) {
                    Text("$${product.discountPrice}")
                }
            }
        }
    }
}