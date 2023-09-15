package com.ahmedhnewa.alrayada_landing_page.sections.our_suppliers

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.SectionTitle
import com.ahmedhnewa.alrayada_landing_page.models.AppSection
import com.ahmedhnewa.alrayada_landing_page.sections.our_suppliers.componenets.SupplierItem
import com.ahmedhnewa.alrayada_landing_page.sections.our_suppliers.models.Supplier
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun OurSuppliersSection() = Box(
    modifier = Modifier
        .margin(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    OurSuppliersContent()
}

@Composable
private fun OurSuppliersContent() {
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
            appSection = AppSection.OurSuppliers
        )
        OurSuppliersItems(
            modifier = Modifier
                .fillMaxWidth(80.percent)
                .margin(top = 20.px)
        )
    }
}

@Composable
private fun OurSuppliersItems(modifier: Modifier = Modifier) {
    val breakpoint = rememberBreakpoint()
    SimpleGrid(
        numColumns = numColumns(base = 1, md = 2),
        modifier = Modifier
            .then(modifier)
    ) {
        val responsiveBreakpoint = Breakpoint.MD
        Supplier.entries.forEach {
            SupplierItem(
                supplier = it,
                responsiveBreakpoint = responsiveBreakpoint,
                breakpoint = breakpoint
            )
        }
    }
}