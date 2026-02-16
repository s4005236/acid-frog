package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LanguagesCodes(
    @SerializedName("ar")
    val ar: Int,
    @SerializedName("de")
    val de: Int,
    @SerializedName("en")
    val en: Int,
    @SerializedName("fr")
    val fr: Int,
    @SerializedName("it")
    val `it`: Int,
    @SerializedName("nl")
    val nl: Int,
    @SerializedName("ro")
    val ro: Int
)