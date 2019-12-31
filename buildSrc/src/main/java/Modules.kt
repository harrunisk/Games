/*
 * App Modules
 */
object Modules {

    private const val BASE_DIRECTORY = ":base"

    /*
     * App
     */
    const val app = ":app"

    /*
     * Base
     */
    const val core = "$BASE_DIRECTORY:core"
    const val corePresentation = "$BASE_DIRECTORY:core_presentation"
    const val coreDomain = "$BASE_DIRECTORY:core_domain"
    const val coreData = "$BASE_DIRECTORY:core_data"
    const val coreNavigation = "$BASE_DIRECTORY:core_navigation"
}