package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PackagingXXX(
    @SerializedName("display")
    val display: DisplayXXX,
    @SerializedName("small")
    val small: SmallXXX,
    @SerializedName("thumb")
    val thumb: ThumbXXX
)