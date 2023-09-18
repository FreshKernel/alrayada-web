package com.ahmedhnewa.alrayada_landing_page.utils

import kotlinx.browser.document
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement

fun getInputValueById(inputId: String): String {
    val element = document.getElementById(inputId) ?: throw NullPointerException("Can't find input element with id = $inputId")
    return try {
        val inputElement = element as HTMLInputElement
        inputElement.value
    } catch (e: ClassCastException) {
        val textAreaElement = element as HTMLTextAreaElement

        textAreaElement.value
    } catch (e: ClassCastException) {
        throw Exception("Can't cast this element to $HTMLInputElement")
    }
    catch (e: Exception) {
        throw e
    }
}