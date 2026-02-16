package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Languages(
    @SerializedName("en:arabic")
    val enArabic: Int,
    @SerializedName("en:dutch")
    val enDutch: Int,
    @SerializedName("en:english")
    val enEnglish: Int,
    @SerializedName("en:french")
    val enFrench: Int,
    @SerializedName("en:german")
    val enGerman: Int,
    @SerializedName("en:italian")
    val enItalian: Int,
    @SerializedName("en:romanian")
    val enRomanian: Int
)