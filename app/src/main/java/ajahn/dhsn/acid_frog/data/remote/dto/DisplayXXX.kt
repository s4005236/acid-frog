package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DisplayXXX(
    @SerializedName("en")
    val en: String = "",
    @SerializedName("fr")
    val fr: String = "",
    @SerializedName("nl")
    val nl: String = ""
)