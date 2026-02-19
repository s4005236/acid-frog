package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("components")
    val components: Components = Components(),
    @SerializedName("count_proteins")
    val countProteins: Int = 0,
    @SerializedName("count_proteins_reason")
    val countProteinsReason: String = "",
    @SerializedName("is_beverage")
    val isBeverage: Int = 0,
    @SerializedName("is_cheese")
    val isCheese: Int = 0,
    @SerializedName("is_fat_oil_nuts_seeds")
    val isFatOilNutsSeeds: Int = 0,
    @SerializedName("is_red_meat_product")
    val isRedMeatProduct: Int = 0,
    @SerializedName("is_water")
    val isWater: Int = 0,
    @SerializedName("negative_points")
    val negativePoints: Int = 0,
    @SerializedName("negative_points_max")
    val negativePointsMax: Int = 0,
    @SerializedName("positive_nutrients")
    val positiveNutrients: List<String> = listOf(),
    @SerializedName("positive_points")
    val positivePoints: Int = 0,
    @SerializedName("positive_points_max")
    val positivePointsMax: Int = 0
)