package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Positive(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("points")
    val points: Int = 0,
    @SerializedName("points_max")
    val pointsMax: Int = 0,
    @SerializedName("unit")
    val unit: String = "",
    @SerializedName("value")
    val value: Int = 0
)