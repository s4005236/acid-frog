package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ProductionSystem(
    @SerializedName("labels")
    val labels: List<Any> = listOf(),
    @SerializedName("value")
    val value: Int = 0,
    @SerializedName("warning")
    val warning: String = ""
)