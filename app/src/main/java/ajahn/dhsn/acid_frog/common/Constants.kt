package ajahn.dhsn.acid_frog.common

/**
 * Class for keeping global constants. This is to ensure their consistency.
 */
object Constants {

    // ### OPENFOODFACTS API ###
    /**production base url for running in production*/
    private const val PRODUCTION_DEPLOYMENT = "world.openfoodfacts.org"

    /**staging base url for running in developement*/
    private const val STAGING_DEPLOYMENT = "world.openfoodfacts.net"

    /**
     * The ApiBaseUrl for connecting to OpenFoodFacts.
     *
     * For more information about the API visit the [documentation](https://openfoodfacts.github.io/openfoodfacts-server/api/).
     *
     * @see ajahn.dhsn.acid_frog.data.remote.OpenFoodFactsApi
     * */
    const val API_BASE_URL = "https://${STAGING_DEPLOYMENT}/"


}