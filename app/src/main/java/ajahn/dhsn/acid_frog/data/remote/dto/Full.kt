package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Full(
    @SerializedName("h")
    val h: Int,
    @SerializedName("w")
    val w: Int
)