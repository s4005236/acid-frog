package ajahn.dhsn.acid_frog.common

object Constants {

    // ### OPENFOODFACTS API ###
    //for running in prod
    private const val PRODUCTION_DEPLOYMENT = "world.openfoodfacts.org"
    //for running in development, testing
    private const val STAGING_DEPLOYMENT = "world.openfoodfacts.net"

    const val API_BASE_URL = "https://${STAGING_DEPLOYMENT}/"


}