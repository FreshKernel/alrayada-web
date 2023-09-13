package com.ahmedhnewa.alrayada_landing_page.sections.our_customers

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.SectionTitle
import com.ahmedhnewa.alrayada_landing_page.components.core.MyImage
import com.ahmedhnewa.alrayada_landing_page.models.Section
import com.ahmedhnewa.alrayada_landing_page.sections.our_customers.componenets.OurCustomerItem
import com.ahmedhnewa.alrayada_landing_page.sections.our_customers.models.OurCustomer
import com.ahmedhnewa.alrayada_landing_page.utils.constants.PublicRes
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Composable
fun OurCustomersSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    OurCustomersContent()
}

@Composable
private fun OurCustomersContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TODO: Create Custom Wave component maybe
        SectionTitle(
            section = Section.OurCustomers,
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 60.percent
                else 90.percent
            )
        )
        OurCustomersItems(
            modifier = Modifier
                .margin(top = 20.px)
                .fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 60.percent
                    else 90.percent
                )
        )
    }
}

@Composable
private fun OurCustomersItems(modifier: Modifier = Modifier) {
    SimpleGrid(
        numColumns = numColumns(base = 1, md = 2, lg = 3),
        modifier = Modifier
            .padding(16.px)
            .then(modifier)
            .alignContent(AlignContent.Center)
    ) {
        OurCustomer.entries.forEach {
            OurCustomerItem(
                ourCustomer = it
            )
        }
    }
}