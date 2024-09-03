package net.freshplatform.alrayada_web.sections.products

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import net.freshplatform.alrayada_web.components.SectionTitle
import net.freshplatform.alrayada_web.models.HomePageSections
import net.freshplatform.alrayada_web.sections.products.components.ProductCard
import net.freshplatform.alrayada_web.sections.products.models.Product
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ProductsSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    ProductsContent()
}

@Composable
private fun ProductsContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier.margin(bottom = 25.px),
            section = HomePageSections.Products,
            alignment = Alignment.CenterHorizontally
        )

        ProductsCard()
    }
}

@Composable
fun ProductsCard() {
    SimpleGrid(
        numColumns = numColumns(base = 1, md = 2, lg = 3)
    ) {
        Product.entries.forEach {
            ProductCard(
                product = it
            )
        }
    }
}