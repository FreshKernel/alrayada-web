package com.ahmedhnewa.alrayada_landing_page.sections.quality_policy

import androidx.compose.runtime.Composable
import com.ahmedhnewa.alrayada_landing_page.components.SectionTitle
import com.ahmedhnewa.alrayada_landing_page.components.core.CenterHorizontally
import com.ahmedhnewa.alrayada_landing_page.models.AppSection
import com.ahmedhnewa.alrayada_landing_page.sections.quality_policy.componenets.QualityPolicyCard
import com.ahmedhnewa.alrayada_landing_page.sections.quality_policy.models.QualityPolicy
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun QualityPolicySection() = Box(
    modifier = Modifier
        .padding(bottom = 100.px, top = 50.px),
    contentAlignment = Alignment.Center
) {
    QualityPolicyContent()
}

@Composable
private fun QualityPolicyContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            )
    ) {
        CenterHorizontally {
            SectionTitle(
                section = AppSection.QualityPolicy,
                alignment = Alignment.CenterHorizontally
            )
        }
        CenterHorizontally {
            QualityPolicyCards(
                breakpoint = breakpoint,
                modifier = Modifier
                    .padding(32.px)
            )
        }
    }
}

@Composable
private fun QualityPolicyCards(modifier: Modifier = Modifier, breakpoint: Breakpoint) {
    SimpleGrid(
        // should be synced with $shouldUseBorderRadius in each item
        numColumns = numColumns(
            base = 1,
            md = 2,
            lg = 3
        ),
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            )
            .then(modifier),
    ) {
        val values = QualityPolicy.entries
        val responsiveBreakpoint = Breakpoint.MD // also change the values from numColumn() to match this
        QualityPolicy.entries.forEach { qualityPolicy ->
            QualityPolicyCard(
                qualityPolicy = qualityPolicy,
                isFirst = values.first() == qualityPolicy,
                isLast = values.last() == qualityPolicy,
                shouldUseBorderRadius = breakpoint > responsiveBreakpoint,
                responsiveBreakpoint = responsiveBreakpoint
            )
        }
    }
}