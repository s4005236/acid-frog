package ajahn.dhsn.acid_frog

import ajahn.dhsn.acid_frog.ui.theme.AcidFrogTheme
import ajahn.dhsn.acid_frog.ui.views.MainScreenView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AcidFrogTheme {
                MainLayout()
            }
        }
    }
}

@Composable
fun MainLayout() {
    MainScreenView()
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    AcidFrogTheme {
        MainLayout()
    }
}