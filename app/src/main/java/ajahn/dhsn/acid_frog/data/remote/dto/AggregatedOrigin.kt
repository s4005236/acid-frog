package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class AggregatedOrigin(
    @SerializedName("epi_score")
    val epiScore: Int,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("percent")
    val percent: Int,
    @SerializedName("transportation_score")
    val transportationScore: Int
)