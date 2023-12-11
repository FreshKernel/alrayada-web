package net.freshplatform.alrayada_landing_page.sections.products.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.grayscale
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import net.freshplatform.alrayada_landing_page.components.core.MyImage
import net.freshplatform.alrayada_landing_page.models.ThemeColors
import net.freshplatform.alrayada_landing_page.sections.products.models.Product
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text


val ProductImageStyle by ComponentStyle {
    base {
        Modifier
            .filter(grayscale(0.percent))
            .transition(CSSTransition(property = "filter", duration = 240.ms))
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
    Link(
        modifier = Modifier
            .textDecorationLine(TextDecorationLine.None)
            .userSelect(UserSelect.None),
        path = product.link
    ) {
        Column(
            modifier = Modifier
                .margin(all = 6.px)
                .padding(leftRight = 12.px, topBottom = 16.px)
                .width(300.px)
                .then(modifier)
        ) {
            MyImage(
                modifier = ProductImageStyle
                    .toModifier()
                    .height(250.px)
                    .fillMaxWidth()
                    .borderRadius(r = 8.px)
                    .objectFit(ObjectFit.Cover),
                src = product.image,
                contentDescription = "${product.companyName} Image",
            )
            Box(modifier = Modifier.height(12.px))
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(top = 7.px, bottom = 2.px)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textAlign(TextAlign.Center)
                    .color(ThemeColors.Primary.colorValue)
                    .toAttrs()
            ) {
                Text(product.companyName)
            }
        }
    }
}