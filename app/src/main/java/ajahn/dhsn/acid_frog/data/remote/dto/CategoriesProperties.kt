package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CategoriesProperties(
    @SerializedName("agribalyse_food_code:en")
    val agribalyseFoodCodeEn: String = "",
    @SerializedName("ciqual_food_code:en")
    val ciqualFoodCodeEn: String = ""
)