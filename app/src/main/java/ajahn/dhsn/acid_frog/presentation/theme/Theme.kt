package ajahn.dhsn.acid_frog.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFCADCAE),
    secondary = Color(0xFFE1E9C9),
    tertiary = Color(0xFFEDA35A),
    background = Color(0xFF1B211A),
    surface = Color(0xFFC63C51),

    onPrimary = Color(0xFF1B211A),
    onSecondary = Color(0xFF42523C),
    onTertiary = Color(0xFF64865F),
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF255F38),
    secondary = Color(0xFF3F4F44),
    tertiary = Color(0xFF901E3E),
    background = Color(0xFFF1E7D8),
    surface = Color(0xFFECDFCC),

    onPrimary = Color(0xFFFCF8F8),
    onSecondary = Color(0xFFFAE8E8),
    onTertiary = Color(0xFFF5D1D1),

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun AcidFrogTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            //if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            if (darkTheme) DarkColorScheme else LightColorScheme
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}