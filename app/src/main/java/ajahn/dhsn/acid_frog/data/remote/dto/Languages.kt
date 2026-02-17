package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Languages(
    @SerializedName("en:arabic")
    val enArabic: Int = 0,
    @SerializedName("en:dutch")
    val enDutch: Int = 0,
    @SerializedName("en:english")
    val enEnglish: Int = 0,
    @SerializedName("en:french")
    val enFrench: Int = 0,
    @SerializedName("en:german")
    val enGerman: Int = 0,
    @SerializedName("en:italian")
    val enItalian: Int = 0,
    @SerializedName("en:romanian")
    val enRomanian: Int = 0
)