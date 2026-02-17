package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class All(
    @SerializedName("weight")
    val weight: Double = 0.0,
    @SerializedName("weight_100g")
    val weight100g: Double = 0.0,
    @SerializedName("weight_percent")
    val weightPercent: Int = 0
)