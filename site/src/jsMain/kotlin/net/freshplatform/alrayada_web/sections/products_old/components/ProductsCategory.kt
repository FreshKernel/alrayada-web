package net.freshplatform.alrayada_web.sections.products_old.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import net.freshplatform.alrayada_web.sections.products_old.models.ProductCategory
import net.freshplatform.alrayada_web.styles.MySelectStyle
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.document
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Option
import org.jetbrains.compose.web.dom.Select
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.get

@Composable
fun ProductsCategory(
    modifier: Modifier = Modifier,
    onSelectedItemChanged: (newItem: ProductCategory) -> Unit
) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .then(modifier)
//    ) {
//        val categories = ProductCategory.entries
//        categories.forEach {
//
//        }
//    }
    val selectItemId = "selectProductCategoryId"
    LaunchedEffect(Unit) {
        val select = document.getElementById(selectItemId)!! as HTMLSelectElement
        select.addEventListener("change", {
            val selectedItem = select.options[select.selectedIndex]?.textContent ?: return@addEventListener
            onSelectedItemChanged(ProductCategory.valueOf(selectedItem))
        })
    }
    Select(
        attrs = MySelectStyle
            .toModifier()
            .id(selectItemId)
            .then(modifier)
            .margin(topBottom = 8.px)
            .toAttrs()
    ) {
        val categories = ProductCategory.entries
        categories.forEach {
            Option(it.categoryName) {
                Text(it.categoryName)
            }
        }
    }
}