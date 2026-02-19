package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Front(
    @SerializedName("display")
    val display: Display = Display(),
    @SerializedName("small")
    val small: Small = Small(),
    @SerializedName("thumb")
    val thumb: Thumb = Thumb()
)