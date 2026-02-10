package ajahn.dhsn.acid_frog.presentation.screens

/**
 * Class, containing the routes to all screens of the application.
 */
sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object BarcodeScanScreen: Screen("barcode_scan_screen")
    object ScanResultScreen: Screen("scan_result_screen")
    object ProfileManagementScreen: Screen("profile_management_screen")
    object ProfileEditScreen: Screen("profile_edit_screen")
}