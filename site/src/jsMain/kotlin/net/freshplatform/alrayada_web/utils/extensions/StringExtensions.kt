package net.freshplatform.alrayada_web.utils.extensions

import kotlinx.browser.document
import org.w3c.dom.Element

fun String.removeCharAtIndex(index: Int): String {
    val string = this
    if (index < 0 || index >= string.length) {
        return string
    }
    return string.substring(0, index) + string.substring(index + 1)
}

fun String.maximumAtFirst(n: Int): String {
    if (this.length > n) {
        return "${this.take(n)}..."
    }
    return this.take(n)
}

fun String.asFragmentIdentifier(): String = "#${this}"

fun String.getElementByThisId(): Element? {
    return document.getElementById(this)
}

fun String.requireElementByThisId(): Element {
    return this.getElementByThisId()
        ?: throw NullPointerException("Can't find element with id = $this")
}