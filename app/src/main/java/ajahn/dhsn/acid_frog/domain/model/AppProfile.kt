package ajahn.dhsn.acid_frog.domain.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf

data class AppProfile (
    val id: MutableState<Long> = mutableStateOf(0L),
    var name: MutableState<String> = mutableStateOf(""),
    var allergens: MutableList<String> = mutableListOf<String>(),
    var isActive : MutableState<Boolean> = mutableStateOf(false),
)