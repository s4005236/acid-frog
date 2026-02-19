package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class FrontNl(
    @SerializedName("imgid")
    val imgid: String = "",
    @SerializedName("rev")
    val rev: String = "",
    @SerializedName("sizes")
    val sizes: Sizes = Sizes()
)