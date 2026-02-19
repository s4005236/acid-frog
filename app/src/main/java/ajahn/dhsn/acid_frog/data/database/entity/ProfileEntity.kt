package ajahn.dhsn.acid_frog.data.database.entity

import ajahn.dhsn.acid_frog.domain.model.AppProfile
import androidx.compose.runtime.mutableStateOf
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profiles")
data class ProfileEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val allergens: List<String>,
    val isActive: Boolean
) {
    companion object {
        fun fromAppProfile(
            appProfile: AppProfile
        ): ProfileEntity {
            return ProfileEntity(
                id = appProfile.id.value,
                name = appProfile.name.value,
                allergens = appProfile.allergens,
                isActive = appProfile.isActive.value,
            )
        }
    }
}

fun ProfileEntity.toAppProfile(
): AppProfile {
    return AppProfile(
        id = mutableStateOf(this.id),
        name = mutableStateOf(this.name),
        allergens = this.allergens.toMutableList(),
        isActive = mutableStateOf(this.isActive),
    )
}