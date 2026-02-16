package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Sizes(
    @SerializedName("full")
    val full: Full,
    @SerializedName("100")
    val x100: X100,
    @SerializedName("200")
    val x200: X100,
    @SerializedName("400")
    val x400: X100
)