package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AggregatedOrigin(
    @SerializedName("epi_score")
    val epiScore: Int = 0,
    @SerializedName("origin")
    val origin: String = "",
    @SerializedName("percent")
    val percent: Int = 0,
    @SerializedName("transportation_score")
    val transportationScore: Int = 0
)