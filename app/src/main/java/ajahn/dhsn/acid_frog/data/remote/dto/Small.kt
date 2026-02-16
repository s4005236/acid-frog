package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Small(
    @SerializedName("ar")
    val ar: String,
    @SerializedName("de")
    val de: String,
    @SerializedName("en")
    val en: String,
    @SerializedName("fr")
    val fr: String,
    @SerializedName("nl")
    val nl: String,
    @SerializedName("ro")
    val ro: String
)