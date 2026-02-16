package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class NutrimentsEstimated(
    @SerializedName("alcohol_100g")
    val alcohol100g: Int,
    @SerializedName("beta-carotene_100g")
    val betaCarotene100g: Int,
    @SerializedName("carbohydrates_100g")
    val carbohydrates100g: Int,
    @SerializedName("cholesterol_100g")
    val cholesterol100g: Int,
    @SerializedName("copper_100g")
    val copper100g: Double,
    @SerializedName("energy_100g")
    val energy100g: Int,
    @SerializedName("energy-kcal_100g")
    val energyKcal100g: Int,
    @SerializedName("energy-kj_100g")
    val energyKj100g: Int,
    @SerializedName("fat_100g")
    val fat100g: Int,
    @SerializedName("fiber_100g")
    val fiber100g: Int,
    @SerializedName("fructose_100g")
    val fructose100g: Int,
    @SerializedName("galactose_100g")
    val galactose100g: Int,
    @SerializedName("glucose_100g")
    val glucose100g: Int,
    @SerializedName("iodine_100g")
    val iodine100g: Int,
    @SerializedName("iron_100g")
    val iron100g: Double,
    @SerializedName("lactose_100g")
    val lactose100g: Int,
    @SerializedName("maltose_100g")
    val maltose100g: Int,
    @SerializedName("manganese_100g")
    val manganese100g: Double,
    @SerializedName("pantothenic-acid_100g")
    val pantothenicAcid100g: Int,
    @SerializedName("phosphorus_100g")
    val phosphorus100g: Int,
    @SerializedName("phylloquinone_100g")
    val phylloquinone100g: Int,
    @SerializedName("polyols_100g")
    val polyols100g: Int,
    @SerializedName("proteins_100g")
    val proteins100g: Int,
    @SerializedName("saturated-fat_100g")
    val saturatedFat100g: Int,
    @SerializedName("selenium_100g")
    val selenium100g: Int,
    @SerializedName("starch_100g")
    val starch100g: Int,
    @SerializedName("sucrose_100g")
    val sucrose100g: Int,
    @SerializedName("sugars_100g")
    val sugars100g: Int,
    @SerializedName("vitamin-a_100g")
    val vitaminA100g: Int,
    @SerializedName("vitamin-b1_100g")
    val vitaminB1100g: Int,
    @SerializedName("vitamin-b12_100g")
    val vitaminB12100g: Int,
    @SerializedName("vitamin-b2_100g")
    val vitaminB2100g: Int,
    @SerializedName("vitamin-b6_100g")
    val vitaminB6100g: Int,
    @SerializedName("vitamin-b9_100g")
    val vitaminB9100g: Int,
    @SerializedName("vitamin-c_100g")
    val vitaminC100g: Int,
    @SerializedName("vitamin-d_100g")
    val vitaminD100g: Int,
    @SerializedName("vitamin-e_100g")
    val vitaminE100g: Int,
    @SerializedName("vitamin-pp_100g")
    val vitaminPp100g: Int,
    @SerializedName("water_100g")
    val water100g: Int,
    @SerializedName("zinc_100g")
    val zinc100g: Double
)