package ajahn.dhsn.acid_frog.domain.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf

data class AppProfile (
    val id: Long = 0L,
    var name: String = "",
    var allergens: List<String> = emptyList<String>(),
    var isActive : Boolean = false
)