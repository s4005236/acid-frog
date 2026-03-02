package ajahn.dhsn.acid_frog

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Main application class for the Acid Frog app.
 *
 * This class serves as the entry point for the application and is annotated with [HiltAndroidApp]
 * to enable dependency injection using Hilt.
 */
@HiltAndroidApp
class AcidFrogApp : Application()