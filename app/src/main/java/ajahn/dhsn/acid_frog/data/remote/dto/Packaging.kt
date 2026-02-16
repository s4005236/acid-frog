package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Packaging(
    @SerializedName("non_recyclable_and_non_biodegradable_materials")
    val nonRecyclableAndNonBiodegradableMaterials: Int,
    @SerializedName("packagings")
    val packagings: List<PackagingX>,
    @SerializedName("score")
    val score: Int,
    @SerializedName("value")
    val value: Int
)