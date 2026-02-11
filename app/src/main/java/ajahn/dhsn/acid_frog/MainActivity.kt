package ajahn.dhsn.acid_frog

import ajahn.dhsn.acid_frog.presentation.screens.Screen
import ajahn.dhsn.acid_frog.presentation.screens.home.HomeScreen
import ajahn.dhsn.acid_frog.presentation.screens.profile_detail.ProfileEditScreen
import ajahn.dhsn.acid_frog.presentation.screens.profile_list.ProfileManagementScreen
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
import dagger.hilt.android.AndroidEntryPoint

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
                    startDestination = Screen.HomeScreen.route
                ) {
                    composable(route = Screen.HomeScreen.route){
                        HomeScreen(navController = navController)
                    }
                    composable(route = Screen.BarcodeScanScreen.route){
                        BarcodeScanScreen(navController = navController)
                    }
                    composable (route = Screen.ScanResultScreen.route ){
                        ScanResultScreen(navController = navController)
                    }
                    composable (route = Screen.ProfileManagementScreen.route ){
                        ProfileManagementScreen(navController = navController)
                    }
                    composable (route = Screen.ProfileEditScreen.route ){
                        ProfileEditScreen(navController = navController)
                    }
                }
            }
        }
    }
}
