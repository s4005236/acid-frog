package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Ingredients(
    @SerializedName("display")
    val display: DisplayX = DisplayX(),
    @SerializedName("small")
    val small: SmallX = SmallX(),
    @SerializedName("thumb")
    val thumb: ThumbX = ThumbX()
)