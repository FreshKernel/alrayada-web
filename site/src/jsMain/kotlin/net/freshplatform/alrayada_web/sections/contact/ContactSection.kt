package net.freshplatform.alrayada_web.sections.contact

import androidx.compose.runtime.*
import net.freshplatform.alrayada_web.components.SectionTitle
import net.freshplatform.alrayada_web.models.HomePageSections
import net.freshplatform.alrayada_web.sections.contact.components.ContactForm
import net.freshplatform.alrayada_web.utils.ObserveViewportEntered
import net.freshplatform.alrayada_web.utils.constants.Constants
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ContactSection() = Box(
    modifier = Modifier
        .padding(topBottom = 100.px),
    contentAlignment = Alignment.Center
) {
    ContactContent()
}

@OptIn(ExperimentalComposeWebApi::class)
@Composable
private fun ContactContent() {
    val breakpoint = rememberBreakpoint()
    val scope = rememberCoroutineScope()
    var animatedRotation by remember { mutableStateOf(0.0) }

    if (Constants.ANIMATION_ENABLED) {
        ObserveViewportEntered(
            sectionId = HomePageSections.Contact.id,
            distanceFromTop = 500.0
        ) {
            animatedRotation = 10.0
            scope.launch {
                delay(500)
                animatedRotation = 0.0
            }
        }
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
                .margin(bottom = 20.px)
                .transform {
                    if (!Constants.ANIMATION_ENABLED) return@transform
                    rotate(animatedRotation.deg)
                }
                .transition(
                    Transition.of(
                        property = "transform",
                        duration = 500.ms,
                        delay = null
                    )
                ),
            section = HomePageSections.Contact,
            alignment = Alignment.CenterHorizontally
        )
        ContactForm()
    }
}

