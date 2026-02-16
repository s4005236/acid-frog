package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("components")
    val components: Components,
    @SerializedName("count_proteins")
    val countProteins: Int,
    @SerializedName("count_proteins_reason")
    val countProteinsReason: String,
    @SerializedName("is_beverage")
    val isBeverage: Int,
    @SerializedName("is_cheese")
    val isCheese: Int,
    @SerializedName("is_fat_oil_nuts_seeds")
    val isFatOilNutsSeeds: Int,
    @SerializedName("is_red_meat_product")
    val isRedMeatProduct: Int,
    @SerializedName("is_water")
    val isWater: Int,
    @SerializedName("negative_points")
    val negativePoints: Int,
    @SerializedName("negative_points_max")
    val negativePointsMax: Int,
    @SerializedName("positive_nutrients")
    val positiveNutrients: List<String>,
    @SerializedName("positive_points")
    val positivePoints: Int,
    @SerializedName("positive_points_max")
    val positivePointsMax: Int
)