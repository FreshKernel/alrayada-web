package net.freshplatform.alrayada_web.sections.service.models

import net.freshplatform.alrayada_web.components.fa.IconCategory
import net.freshplatform.alrayada_web.core.data.StringRes

enum class Service(
    val icon: String,
    val iconDesc: String,
    val iconCategory: IconCategory,
    val titleRes: StringRes,
    val descriptionRes: StringRes
) {
    MedicalLabScientificDevices(
        "flask",
        "Medical Lab Scientific Devices Icon",
        IconCategory.SOLID,
        StringRes.MedicalLabScientificDevices,
        StringRes.MedicalLabScientificDevicesDesc
    ),
    LabInstruments(
        "microscope",
        "Lab Instruments Icon",
        IconCategory.SOLID,
        StringRes.LabInstruments,
        StringRes.LabInstrumentsDesc
    ),
    LabGlassware(
        "whiskey-glass",
        "Lab Glassware Icon",
        IconCategory.SOLID,
        StringRes.LabGlassware,
        StringRes.LabGlasswareDesc
    ),
    AnalyticalChemicalSolutions(
        "flask-vial",
        "Analytical Chemical Solutions Icon",
        IconCategory.SOLID,
        StringRes.AnalyticalChemicalSolutions,
        StringRes.AnalyticalChemicalSolutionsDesc
    ),
    LabChemicals(
        "vial-virus",
        "Lab Chemicals Icon",
        IconCategory.SOLID,
        StringRes.LabChemicals,
        StringRes.LabChemicalsDesc,
    ),
    ResearchAndEducationProducts(
        "book",
        "Research & Education Products Icon",
        IconCategory.SOLID,
        StringRes.ResearchAndEducationProducts,
        StringRes.ResearchAndEducationProductsDesc
    ),
    LabReagents(
        "check",
        "Lab Reagents Icon",
        IconCategory.SOLID,
        StringRes.LabReagents,
        StringRes.LabReagentsDesc
    ),
    LabFurniture(
        "couch",
        "Lab Furniture Icon",
        IconCategory.SOLID,
        StringRes.LabFurniture,
        StringRes.LabFurnitureDesc
    ),
    AfterSalesService(
        "tools",
        "After Sales Service Icon",
        IconCategory.SOLID,
        StringRes.AfterSalesService,
        StringRes.AfterSalesServiceDesc
    )
}