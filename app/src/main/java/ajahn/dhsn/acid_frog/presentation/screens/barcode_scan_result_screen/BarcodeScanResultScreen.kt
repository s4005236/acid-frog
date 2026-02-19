package ajahn.dhsn.acid_frog.presentation.screens.barcode_scan_result_screen

import ajahn.dhsn.acid_frog.presentation.theme.Typography
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun BarcodeScanResultScreen(
    navController: NavController,
    viewModel: BarcodeScanResultViewModel = hiltViewModel(),
    barcode: String
) {
    if (viewModel.state.value.scanResult == null) {
        viewModel.getAppScanResult(barcode)
    }

    val context = LocalContext.current

    Scaffold() { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 60.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                //overview row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    val boxSize = 108

                    Box(
                        modifier = Modifier
                            .size(boxSize.dp)
                            .background(
                                color = if ((viewModel.state.value.scanResult?.profileCount
                                        ?: 0) > 0
                                )
                                    MaterialTheme.colorScheme.error
                                else MaterialTheme.colorScheme.primary,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = viewModel.state.value.scanResult?.profileCount.toString(),
                            fontSize = (boxSize * 0.5).sp,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }

                    if ((viewModel.state.value.scanResult?.profileCount ?: 0) > 0) {
                        Text(text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.error,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = Typography.headlineMedium.fontSize
                                )
                            ) {
                                append("Warnung!\n")
                            }
                            append("Das Produkt\n")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(viewModel.state.value.scanResult?.appProduct?.name)
                            }
                            append("\nenthält kritische Zutaten!")
                        })
                    } else {
                        Text(text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = Typography.headlineMedium.fontSize
                                )
                            ) {
                                append("In Ordnung\n")
                            }
                            append("Das Produkt enthält keine kritische Zutaten!")
                        })
                    }

                }

                //detail row
                if ((viewModel.state.value.scanResult?.profileCount ?: 0) > 0) {

                    Box(
                        modifier = Modifier
                            .border(
                                2.dp,
                                MaterialTheme.colorScheme.primary,
                                RoundedCornerShape(16.dp)
                            )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(text = "Folgende Zutaten wurden gefunden:")

                            HorizontalDivider()

                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.spacedBy(5.dp)
                            ) {
                                viewModel.state.value.scanResult?.scanResultMap?.forEach { scanResult ->
                                    stickyHeader(key = scanResult.key) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column{
                                                Text(
                                                    text = scanResult.key,
                                                    style = Typography.headlineSmall
                                                )
                                                Text (
                                                    text = "enthalten in:",
                                                    style = Typography.bodyMedium
                                                )
                                            }
                                        }
                                    }

                                    items(
                                        items = scanResult.value,
                                        key = { "${scanResult.key}_${it.hashCode()}" }
                                    ) { obj ->
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)
                                        ) {
                                            Icon(
                                                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                                contentDescription = "Info Icon"
                                            )
                                            Text(
                                                text = obj.name.value
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }








            if (viewModel.state.value.error.isNotBlank()) {
                Text(
                    text = viewModel.state.value.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }

            if (viewModel.state.value.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }
    }
}