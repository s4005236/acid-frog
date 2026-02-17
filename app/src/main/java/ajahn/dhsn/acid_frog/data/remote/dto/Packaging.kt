package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Packaging(
    @SerializedName("non_recyclable_and_non_biodegradable_materials")
    val nonRecyclableAndNonBiodegradableMaterials: Int = 0,
    @SerializedName("packagings")
    val packagings: List<PackagingX> = listOf(),
    @SerializedName("score")
    val score: Int = 0,
    @SerializedName("value")
    val value: Int = 0
)