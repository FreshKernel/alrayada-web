package net.freshplatform.alrayada_landing_page.sections.our_suppliers.componenets

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_landing_page.components.core.MyImage
import net.freshplatform.alrayada_landing_page.core.services.localization.stringResource
import net.freshplatform.alrayada_landing_page.models.ThemeColors
import net.freshplatform.alrayada_landing_page.sections.our_suppliers.models.Supplier
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun OurSupplierItem(
    modifier: Modifier = Modifier,
    supplier: Supplier,
    breakpoint: Breakpoint,
    responsiveBreakpoint: Breakpoint
) {
    Row(
        modifier = Modifier
            .minHeight(300.px)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SupplierImage(
            modifier = Modifier
                .displayIfAtLeast(responsiveBreakpoint)
                .height(100.px)
                .maxWidth(100.px)
                .fillMaxWidth(),
            supplier = supplier
        )
        SupplierDetails(
            modifier = Modifier
                .fillMaxWidth(
                    if (breakpoint >= responsiveBreakpoint) 100.percent
                    else 70.percent
                )
                .margin(leftRight = 18.px),
            supplier = supplier,
            responsiveBreakpoint = responsiveBreakpoint
        )
    }
}

@Composable
private fun SupplierImage(
    modifier: Modifier = Modifier,
    supplier: Supplier
) {
    Box(
        modifier = Modifier
            .borderRadius(r = 12.px)
            .border(width = 2.px, style = LineStyle.Solid, color = ThemeColors.Primary.colorValue)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        MyImage(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(
                    83.percent
                )
                .objectFit(ObjectFit.Fill),
            src = supplier.imagePath,
            contentDescription = "${supplier.supplierName} Image"
        )
    }
}

@Composable
private fun SupplierDetails(modifier: Modifier = Modifier, supplier: Supplier, responsiveBreakpoint: Breakpoint) {
    Column(
        modifier = Modifier
            .then(modifier)
    ) {
        SupplierImage(
            modifier = Modifier
                .size(200.px)
                .displayUntil(responsiveBreakpoint)
                .margin(top = 22.px, bottom = 16.px)
                .fillMaxWidth(),
            supplier = supplier
        )
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontSize(24.px)
                .fontWeight(FontWeight.Bold)
                .color(ThemeColors.Primary.colorValue)
                .toAttrs()
        ) {
            Text(supplier.supplierName)
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .color(Colors.Gray)
                .lineHeight(1.4)
                .toAttrs()
        ) {
            Text(stringResource(supplier.supplierDesc))
        }
    }
}