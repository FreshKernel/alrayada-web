package net.freshplatform.alrayada_landing_page.sections.devices.models

import net.freshplatform.alrayada_landing_page.core.data.StringRes
import net.freshplatform.alrayada_landing_page.utils.constants.PublicRes

enum class Device(
    val imagePath: String,
    val companyName: String,
    val deviceName: String,
    val desc: String,
    val features: List<StringRes>
) {
    One(
        PublicRes.Assets.Images.Brands.SNIBE_LOGO,
        "Snibe",
        "Maglumi 800",
        "Chemiluminescence Immunoassay (CLIA) System",
        listOf(
            StringRes.ThroughputUpTo180TestHour,
            StringRes.TwentyFourHoursReadyToUse,
            StringRes.TimeToFirstResult17Minutes,
            StringRes.UpTo40SampleTubes,
            StringRes.NineReagentsOnBoard,
            StringRes.ReadyToUseNoPretreatmentRequired,
        )
    ),
    Two(
        PublicRes.Assets.Images.Brands.SNIBE_LOGO,
        "Dirui",
        "CS-680 Auto",
        "Chemistry Analyze",
        listOf(
            StringRes.CompactSizeWithRobustFunction,
            StringRes.ReliableRefrigeratedSystemForReagentsAndSamplePositions,
            StringRes.BiDirectionalLISHISSystemToRealizeRemoteOperationAndMinimalMaintenance,
            StringRes.AutoDilutionAndAutoRerunFunction
        )
    ),
    Three(
        PublicRes.Assets.Images.Brands.SNIBE_LOGO,
        "Urit-5160",
        "Biolab Diagnostics",
        "5-Part-Diff Hematology Analyzer",
        listOf(
            StringRes.ThirtyFourParametersIncludingRETICABSRETICIRF,
            StringRes.HourlyThroughputUpTo60Samples,
            StringRes.ResistantRBCMode,
            StringRes.GivesResultsWithinOneMinute,
        )
    ),
    Four(
        PublicRes.Assets.Images.Brands.SNIBE_LOGO,
        "Lifotonic",
        "Device",
        "H8-Hemoglobin Analyzer (HPLC)",
        listOf(
            StringRes.TenSamplePosition,
            StringRes.SeventyTwoSecondsPerTest,
            StringRes.TestItemHbA1abLA1cHbFA1cAOHbVariant
        )
    ),
    Five(
        PublicRes.Assets.Images.Brands.SNIBE_LOGO,
        "Lifotonic",
        "Device 2",
        "H9-Hemoglobin Analyzer",
        listOf(
            StringRes.OneHundredTenSamplePositions,
            StringRes.VariantModeThalassemiaMode,
            StringRes.VariantModeTestItemsHbA1abLA1cHbFA1cAOHbVariant,
            StringRes.ThalassemiaModeTestItemsHbA1abLA1cHbFA1cAOHbVariantHbA2
        )
    )
}