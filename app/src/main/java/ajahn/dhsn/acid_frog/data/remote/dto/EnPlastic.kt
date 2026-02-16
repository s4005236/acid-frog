package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class EnPlastic(
    @SerializedName("weight")
    val weight: Double,
    @SerializedName("weight_100g")
    val weight100g: Double,
    @SerializedName("weight_percent")
    val weightPercent: Int
)