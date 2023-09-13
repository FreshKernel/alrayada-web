package com.ahmedhnewa.alrayada_landing_page.components.core

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth

@Composable
fun Center(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize().then(modifier),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun CenterHorizontally(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth().then(modifier),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun CenterVertically(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxHeight().then(modifier),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}