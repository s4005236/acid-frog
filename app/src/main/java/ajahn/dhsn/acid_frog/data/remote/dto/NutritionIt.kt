package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class NutritionIt(
    @SerializedName("imgid")
    val imgid: String,
    @SerializedName("rev")
    val rev: String,
    @SerializedName("sizes")
    val sizes: Sizes
)