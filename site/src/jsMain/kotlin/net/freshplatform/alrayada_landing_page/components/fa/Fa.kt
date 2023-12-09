package net.freshplatform.alrayada_landing_page.components.fa

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Span

// From com.varabyte.kobweb.silk.components.icons.fa

enum class IconCategory(internal val className: String) {
    REGULAR("far"),
    SOLID("fas"),
    BRAND("fab");
}

enum class IconStyle(internal val category: IconCategory) {
    FILLED(IconCategory.SOLID),
    OUTLINE(IconCategory.REGULAR);
}

// See: https://fontawesome.com/docs/web/style/size
enum class IconSize(internal val className: String) {
    // Relative sizes
    XXS("fa-2xs"),
    XS("fa-xs"),
    SM("fa-sm"),
    LG("fa-lg"),
    XL("fa-xl"),
    XXL("fa-2xl"),

    // Literal sizes
    X1("fa-1x"),
    X2("fa-2x"),
    X3("fa-3x"),
    X4("fa-4x"),
    X5("fa-5x"),
    X6("fa-6x"),
    X7("fa-7x"),
    X8("fa-8x"),
    X9("fa-9x"),
    X10("fa-10x");
}

@Composable
fun FaIcon(
    name: String,
    modifier: Modifier,
    style: IconCategory = IconCategory.REGULAR,
    size: IconSize? = null,
) {
    Span(
        attrs = modifier.toAttrs {
            classes(style.className, "fa-$name")
            if (size != null) {
                classes(size.className)
            }
        }
    )
}