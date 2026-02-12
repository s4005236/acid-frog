package ajahn.dhsn.acid_frog.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFCADCAE),
    onPrimary = Color(0xFF1B211A),
    primaryContainer = Color(0xFF3A4732),
    onPrimaryContainer = Color(0xFFE3F6D5),

    secondary = Color(0xFFE1E9C9),
    onSecondary = Color(0xFF42523C),
    secondaryContainer = Color(0xFF5F6955),
    onSecondaryContainer = Color(0xFFFBFCE9),

    tertiary = Color(0xFFEDA35A),
    onTertiary = Color(0xFF64865F),
    tertiaryContainer = Color(0xFF9D6D2E),
    onTertiaryContainer = Color(0xFFFFDDB0),

    background = Color(0xFF1B211A),
    onBackground = Color(0xFFE4E2DB),

    surface = Color(0xFFC63C51),
    onSurface = Color(0xFFFBF8F0),

    surfaceVariant = Color(0xFF4A4D43),
    onSurfaceVariant = Color(0xFFC6C8B9),

    surfaceTint = Color(0xFFCADCAE),

    inverseSurface = Color(0xFFE4E2DB),
    inverseOnSurface = Color(0xFF332E26),
    inversePrimary = Color(0xFF5B6E4F),

    outline = Color(0xFF908983),
    outlineVariant = Color(0xFF4A4D43),

    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),

    scrim = Color(0xFF000000)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF255F38),
    onPrimary = Color(0xFFFCF8F8),
    primaryContainer = Color(0xFFB7D2C0),
    onPrimaryContainer = Color(0xFF102017),

    secondary = Color(0xFF3F4F44),
    onSecondary = Color(0xFFFAE8E8),
    secondaryContainer = Color(0xFFC5D0C8),
    onSecondaryContainer = Color(0xFF1A241E),

    tertiary = Color(0xFF901E3E),
    onTertiary = Color(0xFFF5D1D1),
    tertiaryContainer = Color(0xFFF2B4C5),
    onTertiaryContainer = Color(0xFF400015),

    background = Color(0xFFF1E7D8),
    onBackground = Color(0xFF201B13),

    surface = Color(0xFFECDFCC),
    onSurface = Color(0xFF201B13),

    surfaceVariant = Color(0xFFD7CEC0),
    onSurfaceVariant = Color(0xFF4D463A),

    surfaceTint = Color(0xFF255F38),

    inverseSurface = Color(0xFF352F26),
    inverseOnSurface = Color(0xFFF5EDE0),
    inversePrimary = Color(0xFF8CCC9B),

    outline = Color(0xFF7B7366),
    outlineVariant = Color(0xFFCAC1B3),

    error = Color(0xFFBA1A1A),
    onError = Color(0xFFFFFFFF.toInt()),
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),

    scrim = Color(0xFF000000)

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