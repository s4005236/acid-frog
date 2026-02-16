package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ProductionSystem(
    @SerializedName("labels")
    val labels: List<Any>,
    @SerializedName("value")
    val value: Int,
    @SerializedName("warning")
    val warning: String
)