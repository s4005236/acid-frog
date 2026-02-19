package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class NutrimentsEstimated(
    @SerializedName("alcohol_100g")
    val alcohol100g: Int = 0,
    @SerializedName("beta-carotene_100g")
    val betaCarotene100g: Int = 0,
    @SerializedName("carbohydrates_100g")
    val carbohydrates100g: Int = 0,
    @SerializedName("cholesterol_100g")
    val cholesterol100g: Int = 0,
    @SerializedName("copper_100g")
    val copper100g: Double = 0.0,
    @SerializedName("energy_100g")
    val energy100g: Int = 0,
    @SerializedName("energy-kcal_100g")
    val energyKcal100g: Int = 0,
    @SerializedName("energy-kj_100g")
    val energyKj100g: Int = 0,
    @SerializedName("fat_100g")
    val fat100g: Int = 0,
    @SerializedName("fiber_100g")
    val fiber100g: Int = 0,
    @SerializedName("fructose_100g")
    val fructose100g: Int = 0,
    @SerializedName("galactose_100g")
    val galactose100g: Int = 0,
    @SerializedName("glucose_100g")
    val glucose100g: Int = 0,
    @SerializedName("iodine_100g")
    val iodine100g: Int = 0,
    @SerializedName("iron_100g")
    val iron100g: Double = 0.0,
    @SerializedName("lactose_100g")
    val lactose100g: Int = 0,
    @SerializedName("maltose_100g")
    val maltose100g: Int = 0,
    @SerializedName("manganese_100g")
    val manganese100g: Double = 0.0,
    @SerializedName("pantothenic-acid_100g")
    val pantothenicAcid100g: Int = 0,
    @SerializedName("phosphorus_100g")
    val phosphorus100g: Int = 0,
    @SerializedName("phylloquinone_100g")
    val phylloquinone100g: Int = 0,
    @SerializedName("polyols_100g")
    val polyols100g: Int = 0,
    @SerializedName("proteins_100g")
    val proteins100g: Int = 0,
    @SerializedName("saturated-fat_100g")
    val saturatedFat100g: Int = 0,
    @SerializedName("selenium_100g")
    val selenium100g: Int = 0,
    @SerializedName("starch_100g")
    val starch100g: Int = 0,
    @SerializedName("sucrose_100g")
    val sucrose100g: Int = 0,
    @SerializedName("sugars_100g")
    val sugars100g: Int = 0,
    @SerializedName("vitamin-a_100g")
    val vitaminA100g: Int = 0,
    @SerializedName("vitamin-b1_100g")
    val vitaminB1100g: Int = 0,
    @SerializedName("vitamin-b12_100g")
    val vitaminB12100g: Int = 0,
    @SerializedName("vitamin-b2_100g")
    val vitaminB2100g: Int = 0,
    @SerializedName("vitamin-b6_100g")
    val vitaminB6100g: Int = 0,
    @SerializedName("vitamin-b9_100g")
    val vitaminB9100g: Int = 0,
    @SerializedName("vitamin-c_100g")
    val vitaminC100g: Int = 0,
    @SerializedName("vitamin-d_100g")
    val vitaminD100g: Int = 0,
    @SerializedName("vitamin-e_100g")
    val vitaminE100g: Int = 0,
    @SerializedName("vitamin-pp_100g")
    val vitaminPp100g: Int = 0,
    @SerializedName("water_100g")
    val water100g: Int = 0,
    @SerializedName("zinc_100g")
    val zinc100g: Double = 0.0
)