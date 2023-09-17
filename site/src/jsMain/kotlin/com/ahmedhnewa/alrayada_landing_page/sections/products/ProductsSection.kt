package com.ahmedhnewa.alrayada_landing_page.sections.products

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.SectionTitle
import com.ahmedhnewa.alrayada_landing_page.models.HomePageSections
import com.ahmedhnewa.alrayada_landing_page.sections.products.components.ProductCard
import com.ahmedhnewa.alrayada_landing_page.sections.products.models.Product
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
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
        SimpleGrid(numColumns = numColumns(base = 1, md = 2, lg = 3, xl = 4)) {
            Product.entries.forEach { product ->
                ProductCard(product = product)
            }
        }
    }
}