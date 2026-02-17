package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("energy")
    val energy: Int = 0,
    @SerializedName("energy_points")
    val energyPoints: Int = 0,
    @SerializedName("energy_value")
    val energyValue: Int = 0,
    @SerializedName("fiber")
    val fiber: Int = 0,
    @SerializedName("fiber_points")
    val fiberPoints: Int = 0,
    @SerializedName("fiber_value")
    val fiberValue: Int = 0,
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils")
    val fruitsVegetablesNutsColzaWalnutOliveOils: Int = 0,
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils_points")
    val fruitsVegetablesNutsColzaWalnutOliveOilsPoints: Int = 0,
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils_value")
    val fruitsVegetablesNutsColzaWalnutOliveOilsValue: Int = 0,
    @SerializedName("is_beverage")
    val isBeverage: Int = 0,
    @SerializedName("is_cheese")
    val isCheese: Int = 0,
    @SerializedName("is_fat")
    val isFat: Int = 0,
    @SerializedName("is_water")
    val isWater: Int = 0,
    @SerializedName("negative_points")
    val negativePoints: Int = 0,
    @SerializedName("positive_points")
    val positivePoints: Int = 0,
    @SerializedName("proteins")
    val proteins: Int = 0,
    @SerializedName("proteins_points")
    val proteinsPoints: Int = 0,
    @SerializedName("proteins_value")
    val proteinsValue: Int = 0,
    @SerializedName("saturated_fat")
    val saturatedFat: Int = 0,
    @SerializedName("saturated_fat_points")
    val saturatedFatPoints: Int = 0,
    @SerializedName("saturated_fat_value")
    val saturatedFatValue: Int = 0,
    @SerializedName("sodium")
    val sodium: Double = 0.0,
    @SerializedName("sodium_points")
    val sodiumPoints: Int = 0,
    @SerializedName("sodium_value")
    val sodiumValue: Double = 0.0,
    @SerializedName("sugars")
    val sugars: Int = 0,
    @SerializedName("sugars_points")
    val sugarsPoints: Int = 0,
    @SerializedName("sugars_value")
    val sugarsValue: Int = 0
)