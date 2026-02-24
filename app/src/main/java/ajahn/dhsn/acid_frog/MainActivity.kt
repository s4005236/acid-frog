package ajahn.dhsn.acid_frog

import ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen.BarcodeScanResultScreen
import ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_screen.BarcodeScanScreen
import ajahn.dhsn.acid_frog.presentation.screens.home.HomeScreen
import ajahn.dhsn.acid_frog.presentation.screens.profile_detail.ProfileDetailScreen
import ajahn.dhsn.acid_frog.presentation.screens.profile_import.ProfileImportScreen
import ajahn.dhsn.acid_frog.presentation.screens.profile_list.ProfileListScreen
import ajahn.dhsn.acid_frog.presentation.theme.AcidFrogTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

/**
 * Main activity for the Acid Frog application.
 *
 * This activity is the entry point for the app's UI and is annotated with [AndroidEntryPoint]
 * to enable Hilt dependency injection. It sets up the navigation graph and handles the app's
 * main content using Jetpack Compose.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /**
     * Called when the activity is starting.
     *
     * This method initializes the activity, enables edge-to-edge display, and sets up the
     * navigation graph using Jetpack Compose Navigation. The start destination is determined
     * based on whether the app was launched with an intent containing a data string.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     * this Bundle contains the data it most recently supplied in [onSaveInstanceState].
     * Otherwise, it is null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AcidFrogTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = if (intent.dataString != null) ProfileImportScreen else HomeScreen
                ) {
                    /**
                     * Navigation destination for importing a profile from a shared link.
                     */
                    composable<ProfileImportScreen> {
                        val dataString = intent.dataString ?: ""
                        ProfileImportScreen(navController = navController, dataString = dataString)
                    }

                    /**
                     * Navigation destination for the home screen.
                     */
                    composable<HomeScreen> {
                        HomeScreen(navController = navController)
                    }

                    /**
                     * Navigation destination for the profile list screen.
                     */
                    composable<ProfileListScreen> {
                        ProfileListScreen(navController = navController)
                    }

                    /**
                     * Navigation destination for the profile detail screen.
                     */
                    composable<ProfileDetailScreen> { backStackEntry ->
                        val args = backStackEntry.toRoute<ProfileDetailScreen>()
                        ProfileDetailScreen(navController = navController, profileId = args.profileId)
                    }

                    /**
                     * Navigation destination for the barcode scan screen.
                     */
                    composable<BarcodeScanScreen> {
                        BarcodeScanScreen(navController = navController)
                    }

                    /**
                     * Navigation destination for the barcode scan result screen.
                     */
                    composable<BarcodeScanResultScreen> { backStackEntry ->
                        val args = backStackEntry.toRoute<BarcodeScanResultScreen>()
                        BarcodeScanResultScreen(navController = navController, barcode = args.barcode)
                    }
                }
            }
        }
    }
}

/**
 * Serializable object representing the profile import screen destination.
 *
 * This destination is used when the app is launched with a data string, typically from a shared link.
 */
@Serializable
object ProfileImportScreen

/**
 * Serializable object representing the home screen destination.
 *
 * This is the default start destination when no data string is provided in the intent.
 */
@Serializable
object HomeScreen

/**
 * Serializable object representing the profile list screen destination.
 */
@Serializable
object ProfileListScreen

/**
 * Serializable data class representing the profile detail screen destination.
 *
 * @property profileId The ID of the profile to display or edit.
 */
@Serializable
data class ProfileDetailScreen(
    val profileId: Long
)

/**
 * Serializable object representing the barcode scan screen destination.
 */
@Serializable
object BarcodeScanScreen

/**
 * Serializable data class representing the barcode scan result screen destination.
 *
 * @property barcode The barcode string to display results for.
 */
@Serializable
data class BarcodeScanResultScreen(
    val barcode: String
)
