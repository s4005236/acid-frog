package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PackagingsMaterials(
    @SerializedName("all")
    val all: All,
    @SerializedName("en:plastic")
    val enPlastic: EnPlastic
)