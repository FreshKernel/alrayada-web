package net.freshplatform.alrayada_landing_page.sections.testimonial

import androidx.compose.runtime.*
import net.freshplatform.alrayada_landing_page.components.NavigationIcon
import net.freshplatform.alrayada_landing_page.components.SectionTitle
import net.freshplatform.alrayada_landing_page.components.fa.IconSize
import net.freshplatform.alrayada_landing_page.models.HomePageSections
import net.freshplatform.alrayada_landing_page.sections.testimonial.componenets.TestimonialCard
import net.freshplatform.alrayada_landing_page.sections.testimonial.models.Testimonial
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import kotlin.enums.EnumEntries

@Composable
fun TestimonialSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    TestimonialContent()
}

@Composable
private fun TestimonialContent() {
    val breakpoint = rememberBreakpoint()

    val testimonials = Testimonial.entries
    var selectedPage by remember { mutableStateOf(1) }

    // To be a little bit readable and customizable I will not use if-else here
    // even though it's less code
    val itemsPerPage = when (breakpoint) {
        Breakpoint.SM -> 1
        Breakpoint.MD -> 1
        Breakpoint.LG -> 2
        Breakpoint.XL -> 2
        else -> 1
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 30.px),
            section = HomePageSections.Testimonial,
            alignment = Alignment.CenterHorizontally
        )
        TestimonialCards(
            modifier = Modifier.margin(bottom = 35.px),
            selectedPage = selectedPage,
            itemsPerPage = itemsPerPage,
            allTestimonials = testimonials,
            breakpoint = breakpoint
        )

        TestimonialNavigation(
            selectedPage = selectedPage,
            itemsPerPage = itemsPerPage,
            onCurrentPageChanged = { newPage ->
                selectedPage = newPage
            },
            testimonials = testimonials
        )
    }
}

@Composable
private fun TestimonialCards(
    modifier: Modifier = Modifier,
    selectedPage: Int,
    itemsPerPage: Int,
    allTestimonials: EnumEntries<Testimonial>,
    breakpoint: Breakpoint
) {
    val startIndex = (selectedPage - 1) * itemsPerPage
//    val endIndex = startIndex + itemsPerPage
    // to fix bug where we have one page have only one item
    val endIndex = startIndex + itemsPerPage.coerceAtMost(allTestimonials.size - startIndex)


    val testimonialsToShow = allTestimonials
        .toList()
        .subList(startIndex, endIndex)
    Row(
        modifier = Modifier
            .overflow(Overflow.Hidden)
            .scrollBehavior(ScrollBehavior.Smooth)
            .then(modifier)
    ) {
        testimonialsToShow
            .forEach { testimonial ->
                val isLast = testimonial == testimonialsToShow.last()
                TestimonialCard(
                    modifier = Modifier.margin(right = if (isLast) 0.px else 50.px),
                    testimonial = testimonial,
                    breakpoint = breakpoint
                )
            }
    }
}

@Composable
private fun TestimonialNavigation(
    modifier: Modifier = Modifier,
    selectedPage: Int,
    itemsPerPage: Int,
    onCurrentPageChanged: (value: Int) -> Unit,
    testimonials: EnumEntries<Testimonial>,
) {
    val lastPage = testimonials.size / itemsPerPage + if (testimonials.size % itemsPerPage == 0) 0 else 1
    Row(modifier = modifier) {
        (1..lastPage).forEach { currentPage ->
            val isSelectedItem = currentPage == selectedPage
            val isLastNavigationItem = currentPage == lastPage
            NavigationIcon(
                modifier = Modifier
                    .margin(right = if (isLastNavigationItem) 0.px else 5.px)
                    .onClick { onCurrentPageChanged(currentPage) },
                selected = isSelectedItem,
                size = IconSize.LG
            )
        }
    }
}