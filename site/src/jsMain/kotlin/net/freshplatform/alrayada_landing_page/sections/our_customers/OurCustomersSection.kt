package net.freshplatform.alrayada_landing_page.sections.our_customers

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_landing_page.components.SectionTitle
import net.freshplatform.alrayada_landing_page.components.core.CenterHorizontally
import net.freshplatform.alrayada_landing_page.models.HomePageSections
import net.freshplatform.alrayada_landing_page.sections.our_customers.componenets.OurCustomerItem
import net.freshplatform.alrayada_landing_page.sections.our_customers.models.OurCustomer
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignContent
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

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
        SectionTitle(
            section = HomePageSections.OurCustomers,
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
        numColumns = numColumns(base = 1, lg = 2, xl = 3),
        modifier = Modifier
            .padding(16.px)
            .then(modifier)
            .alignContent(AlignContent.Center)
    ) {
        OurCustomer.entries.forEach {
            CenterHorizontally {
                OurCustomerItem(
                    ourCustomer = it
                )
            }
        }
    }
}