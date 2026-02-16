package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Positive(
    @SerializedName("id")
    val id: String,
    @SerializedName("points")
    val points: Int,
    @SerializedName("points_max")
    val pointsMax: Int,
    @SerializedName("unit")
    val unit: String,
    @SerializedName("value")
    val value: Int
)