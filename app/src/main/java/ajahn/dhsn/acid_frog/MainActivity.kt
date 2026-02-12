package ajahn.dhsn.acid_frog

import ajahn.dhsn.acid_frog.presentation.screens.home.HomeScreen
import ajahn.dhsn.acid_frog.presentation.screens.profile_detail.ProfileDetailScreen
import ajahn.dhsn.acid_frog.presentation.screens.profile_list.ProfileListScreen
import ajahn.dhsn.acid_frog.presentation.screens.scan.BarcodeScanScreen
import ajahn.dhsn.acid_frog.presentation.screens.scan.ScanResultScreen
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

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AcidFrogTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = HomeScreen
                ){
                    composable<HomeScreen>{
                        HomeScreen(navController = navController)
                    }
                    composable<ProfileListScreen>{
                        ProfileListScreen(navController = navController)
                    }
                    composable<ProfileDetailScreen>{ backStackEntry ->
                        val args = backStackEntry.toRoute<ProfileDetailScreen>()

                        ProfileDetailScreen(navController = navController, profileId = args.profileId)
                    }
                    composable<BarcodeScanScreen>{
                        BarcodeScanScreen(navController = navController)
                    }
                    composable<ScanResultScreen>{
                        ScanResultScreen(navController = navController)
                    }
                }
            }
        }
    }
}

@Serializable
object HomeScreen
@Serializable
object ProfileListScreen
@Serializable
data class ProfileDetailScreen(
    val profileId: String
)
@Serializable
object BarcodeScanScreen
@Serializable
object ScanResultScreen