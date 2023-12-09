package net.freshplatform.alrayada_landing_page.pages.download_mobile_app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import net.freshplatform.alrayada_landing_page.core.data.StringRes
import net.freshplatform.alrayada_landing_page.core.services.localization.getStringResource
import net.freshplatform.alrayada_landing_page.core.services.localization.stringResource
import net.freshplatform.alrayada_landing_page.utils.updateDocument
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.dom.Text

@Composable
@Page
fun DownloadMobileAppPage() {
    LaunchedEffect(Unit) {
        updateDocument {
            title = "${getStringResource(StringRes.MobileApp)} - ${getStringResource(StringRes.AlrayadaAlarabiah)}"
            description = getStringResource(StringRes.MobileAppDesc)
        }
    }
    Text(stringResource(StringRes.MobileApp))
}