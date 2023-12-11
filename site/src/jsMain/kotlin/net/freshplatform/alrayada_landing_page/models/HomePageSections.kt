package net.freshplatform.alrayada_landing_page.models

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_landing_page.core.data.StringRes
import net.freshplatform.alrayada_landing_page.core.router.AppRouter
import net.freshplatform.alrayada_landing_page.sections.about.AboutSection
import net.freshplatform.alrayada_landing_page.sections.achievement.AchievementSection
import net.freshplatform.alrayada_landing_page.sections.assistance.AssistanceSection
import net.freshplatform.alrayada_landing_page.sections.contact.ContactSection
import net.freshplatform.alrayada_landing_page.sections.devices.DevicesSection
import net.freshplatform.alrayada_landing_page.sections.experience.ExperienceSection
import net.freshplatform.alrayada_landing_page.sections.location.LocationSection
import net.freshplatform.alrayada_landing_page.sections.main.MainSection
import net.freshplatform.alrayada_landing_page.sections.mobile_app.MobileAppSection
import net.freshplatform.alrayada_landing_page.sections.objective.ObjectiveSection
import net.freshplatform.alrayada_landing_page.sections.our_customers.OurCustomersSection
import net.freshplatform.alrayada_landing_page.sections.our_suppliers.OurSuppliersSection
import net.freshplatform.alrayada_landing_page.sections.our_values.OurValuesSection
import net.freshplatform.alrayada_landing_page.sections.portfolio.PortfolioSection
import net.freshplatform.alrayada_landing_page.sections.products.ProductsSection
import net.freshplatform.alrayada_landing_page.sections.quality_policy.QualityPolicySection
import net.freshplatform.alrayada_landing_page.sections.service.ServiceSection
import net.freshplatform.alrayada_landing_page.sections.testimonial.TestimonialSection
import org.jetbrains.compose.web.dom.Text

enum class HomePageSections(
    val id: String,
    val titleRes: StringRes,
    val subtitleRes: StringRes,
    val content: @Composable () -> Unit = { Text("No content yet") }
) {
    Home(
        id = "home",
        titleRes = StringRes.Home,
        subtitleRes = StringRes.EmptyString,
        content = { MainSection() }
    ),
    About(
        id = "about",
        titleRes = StringRes.About,
        subtitleRes = StringRes.WhyUs,
        content = { AboutSection() }
    ),
    Objective(
        id = "objective",
        titleRes = StringRes.EmptyString,
        subtitleRes = StringRes.EmptyString,
        content = { ObjectiveSection() }
    ),
    OurValues(
        id = "ourValues",
        titleRes = StringRes.OurValues,
        subtitleRes = StringRes.EmptyString,
        content = { OurValuesSection() }
    ),
    Service(
        id = "service",
        titleRes = StringRes.OurServices,
        subtitleRes = StringRes.PreparingAndEquippingLaboratories,
        content = { ServiceSection() }
    ),
    Assistance(
        id = "assistance",
        titleRes = StringRes.TechnicalServicesAndAfterSalesSupport,
        subtitleRes = StringRes.MedicalAssistance,
        content = { AssistanceSection() }
    ),
    QualityPolicy(
        id = "qualityPolicy",
        titleRes = StringRes.QualityPolicy,
        subtitleRes = StringRes.EmptyString,
        content = { QualityPolicySection() }
    ),
    OurSuppliers(
        id = "ourSuppliers",
        titleRes = StringRes.OurSuppliers,
        subtitleRes = StringRes.EmptyString,
        content = { OurSuppliersSection() }
    ),
    OurCustomers(
        id = "ourCustomers",
        titleRes = StringRes.OurCustomers,
        subtitleRes = StringRes.EmptyString,
        content = { OurCustomersSection() }
    ),
    Devices(
        id = "devices",
        titleRes = StringRes.Devices,
        subtitleRes = StringRes.EmptyString,
        content = { DevicesSection() }
    ),
    Portfolio(
        id = "portfolio",
        titleRes = StringRes.Portfolio,
        subtitleRes = StringRes.OurProjects,
        content = { PortfolioSection() }
    ),
    Achievements(
        id = "achievements",
        titleRes = StringRes.Achievements,
        subtitleRes = StringRes.EmptyString,
        content = { AchievementSection() }
    ),
    Testimonial(
        id = "testimonial",
        titleRes = StringRes.Testimonial,
        subtitleRes = StringRes.CustomerReviews,
        content = { TestimonialSection() }
    ),
    Experience(
        id = "experience",
        titleRes = StringRes.Experience,
        subtitleRes = StringRes.WorkExperience,
        content = { ExperienceSection() }
    ),
    Products(
        id = "products",
        titleRes = StringRes.Products,
        subtitleRes = StringRes.CompanyProducts,
        content = { ProductsSection() }
    ),
    MobileApp(
        id = "mobileApp",
        titleRes = StringRes.MobileApp,
        subtitleRes = StringRes.DownloadTheApp,
        content = { MobileAppSection() }
    ),
    Location(
        id = "location",
        titleRes = StringRes.Location,
        subtitleRes = StringRes.OurLocation,
        content = { LocationSection() }
    ),
    Contact(
        id = "contact",
        titleRes = StringRes.Contact,
        subtitleRes = StringRes.GetInTouch,
        content = { ContactSection() }
    );

    companion object {

        // In header
        val navigationItems: List<NavigationLink> = listOf(
            NavigationLink.HomePageSection(Home),
            NavigationLink.HomePageSection(About),
            NavigationLink.HomePageSectionWithAlternativeTitle(Service, StringRes.Services),
            NavigationLink.HomePageSection(Portfolio),
            NavigationLink.HomePageSection(Experience),
            NavigationLink.HomePageSection(Products),
            NavigationLink.Page(
                StringRes.Privacy,
                AppRouter.PRIVACY_POLICY
            )
        )
    }
}