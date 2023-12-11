package net.freshplatform.alrayada_landing_page.sections.products_old

import androidx.compose.runtime.*
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
import net.freshplatform.alrayada_landing_page.components.SectionTitle
import net.freshplatform.alrayada_landing_page.components.core.CenterHorizontally
import net.freshplatform.alrayada_landing_page.models.HomePageSections
import net.freshplatform.alrayada_landing_page.sections.products_old.components.ProductCard
import net.freshplatform.alrayada_landing_page.sections.products_old.components.ProductsCategory
import net.freshplatform.alrayada_landing_page.sections.products_old.models.Product
import net.freshplatform.alrayada_landing_page.sections.products_old.models.ProductCategory
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

        ProductsWithCategoryFilter()

    }
}

@Composable
fun ProductsWithCategoryFilter() {
    val categories = ProductCategory.entries
    var selectedItem by remember { mutableStateOf(categories.first()) }
    CenterHorizontally {
        ProductsCategory(
            onSelectedItemChanged = { newItem ->
                selectedItem = newItem
            }
        )
    }
    ProductsCards(
        selectedCategory = selectedItem
    )
}

@Composable
private fun ProductsCards(
    modifier: Modifier = Modifier,
    selectedCategory: ProductCategory
) {
    SimpleGrid(numColumns = numColumns(base = 1, md = 2, lg = 3, xl = 4), modifier = modifier) {
        val filteredProducts = Product.entries.filter { selectedCategory.categoryName == it.category.categoryName }
        filteredProducts.forEach { product ->
            ProductCard(product = product)
        }
    }
}