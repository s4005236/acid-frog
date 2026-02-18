package ajahn.dhsn.acid_frog.data.database.entity

import ajahn.dhsn.acid_frog.domain.model.AppProfile
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
                id = appProfile.id,
                name = appProfile.name ?: "",
                allergens = appProfile.allergens,
                isActive = appProfile.isActive,
            )
        }
    }
}

fun ProfileEntity.toAppProfile(
): AppProfile {
    return AppProfile(
        id = this.id,
        name = this.name,
        allergens = this.allergens,
        isActive = this.isActive,
    )
}