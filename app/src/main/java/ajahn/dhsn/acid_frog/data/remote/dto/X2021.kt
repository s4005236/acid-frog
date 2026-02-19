package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class X2021(
    @SerializedName("category_available")
    val categoryAvailable: Int = 0,
    @SerializedName("data")
    val `data`: Data = Data(),
    @SerializedName("estimated")
    val estimated: Int = 0,
    @SerializedName("grade")
    val grade: String = "",
    @SerializedName("nutrients_available")
    val nutrientsAvailable: Int = 0,
    @SerializedName("nutriscore_applicable")
    val nutriscoreApplicable: Int = 0,
    @SerializedName("nutriscore_computed")
    val nutriscoreComputed: Int = 0,
    @SerializedName("preparation")
    val preparation: String = "",
    @SerializedName("score")
    val score: Int = 0
)