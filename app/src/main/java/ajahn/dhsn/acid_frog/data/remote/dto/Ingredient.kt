package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("ciqual_food_code")
    val ciqualFoodCode: String = "",
    @SerializedName("ecobalyse_code")
    val ecobalyseCode: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("is_in_taxonomy")
    val isInTaxonomy: Int = 0,
    @SerializedName("percent_estimate")
    val percentEstimate: Int = 0,
    @SerializedName("percent_max")
    val percentMax: Int = 0,
    @SerializedName("percent_min")
    val percentMin: Int = 0,
    @SerializedName("text")
    val text: String = "",
    @SerializedName("vegan")
    val vegan: String = "",
    @SerializedName("vegetarian")
    val vegetarian: String = ""
)