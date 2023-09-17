package com.ahmedhnewa.alrayada_landing_page.sections.devices

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.SectionTitle
import com.ahmedhnewa.alrayada_landing_page.models.HomePageSections
import com.ahmedhnewa.alrayada_landing_page.sections.devices.componenets.DeviceItem
import com.ahmedhnewa.alrayada_landing_page.sections.devices.models.Device
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
fun DevicesSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    DevicesContent()
}

@Composable
private fun DevicesContent() {
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
            section = HomePageSections.Devices,
            modifier = Modifier
                .margin(bottom = 40.px)
        )
        DevicesCards()
    }
}

@Composable
private fun DevicesCards(modifier: Modifier = Modifier) {
    SimpleGrid(
        modifier = modifier,
        numColumns = numColumns(base = 1, xl = 2)
    ) {
        val devices = Device.entries
        devices.forEach {
            val isLast = devices.last() == it
            DeviceItem(
                device = it,
                modifier = Modifier.padding(12.px),
                isLast = isLast
            )
        }
    }
}