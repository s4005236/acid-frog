package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Ingredients(
    @SerializedName("display")
    val display: DisplayX,
    @SerializedName("small")
    val small: SmallX,
    @SerializedName("thumb")
    val thumb: ThumbX
)