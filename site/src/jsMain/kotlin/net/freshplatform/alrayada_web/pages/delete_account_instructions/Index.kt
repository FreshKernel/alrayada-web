package net.freshplatform.alrayada_web.pages.delete_account_instructions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.core.Page
import net.freshplatform.alrayada_web.core.data.StringRes
import net.freshplatform.alrayada_web.core.services.localization.getStringResource
import net.freshplatform.alrayada_web.utils.updateDocument

@Composable
@Page
fun DeleteAccountInstructions() {
    LaunchedEffect(Unit) {
        updateDocument {
            title = "${getStringResource(StringRes.DeleteAccountInstructions)} - ${getStringResource(StringRes.AlrayadaAlarabiah)}"
            description = getStringResource(StringRes.DeleteAccountInstructionsDesc)
        }
    }
}