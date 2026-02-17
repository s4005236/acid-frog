package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LanguagesCodes(
    @SerializedName("ar")
    val ar: Int = 0,
    @SerializedName("de")
    val de: Int = 0,
    @SerializedName("en")
    val en: Int = 0,
    @SerializedName("fr")
    val fr: Int = 0,
    @SerializedName("it")
    val `it`: Int = 0,
    @SerializedName("nl")
    val nl: Int = 0,
    @SerializedName("ro")
    val ro: Int = 0
)