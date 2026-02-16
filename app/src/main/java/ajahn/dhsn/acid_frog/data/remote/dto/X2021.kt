package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class X2021(
    @SerializedName("category_available")
    val categoryAvailable: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("estimated")
    val estimated: Int,
    @SerializedName("grade")
    val grade: String,
    @SerializedName("nutrients_available")
    val nutrientsAvailable: Int,
    @SerializedName("nutriscore_applicable")
    val nutriscoreApplicable: Int,
    @SerializedName("nutriscore_computed")
    val nutriscoreComputed: Int,
    @SerializedName("preparation")
    val preparation: String,
    @SerializedName("score")
    val score: Int
)