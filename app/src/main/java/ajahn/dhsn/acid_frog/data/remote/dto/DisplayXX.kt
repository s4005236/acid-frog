package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DisplayXX(
    @SerializedName("en")
    val en: String = "",
    @SerializedName("fr")
    val fr: String = "",
    @SerializedName("it")
    val `it`: String = "",
    @SerializedName("nl")
    val nl: String = "",
    @SerializedName("ro")
    val ro: String = ""
)