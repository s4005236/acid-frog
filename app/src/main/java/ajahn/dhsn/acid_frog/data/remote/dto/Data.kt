package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("energy")
    val energy: Int,
    @SerializedName("energy_points")
    val energyPoints: Int,
    @SerializedName("energy_value")
    val energyValue: Int,
    @SerializedName("fiber")
    val fiber: Int,
    @SerializedName("fiber_points")
    val fiberPoints: Int,
    @SerializedName("fiber_value")
    val fiberValue: Int,
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils")
    val fruitsVegetablesNutsColzaWalnutOliveOils: Int,
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils_points")
    val fruitsVegetablesNutsColzaWalnutOliveOilsPoints: Int,
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils_value")
    val fruitsVegetablesNutsColzaWalnutOliveOilsValue: Int,
    @SerializedName("is_beverage")
    val isBeverage: Int,
    @SerializedName("is_cheese")
    val isCheese: Int,
    @SerializedName("is_fat")
    val isFat: Int,
    @SerializedName("is_water")
    val isWater: Int,
    @SerializedName("negative_points")
    val negativePoints: Int,
    @SerializedName("positive_points")
    val positivePoints: Int,
    @SerializedName("proteins")
    val proteins: Int,
    @SerializedName("proteins_points")
    val proteinsPoints: Int,
    @SerializedName("proteins_value")
    val proteinsValue: Int,
    @SerializedName("saturated_fat")
    val saturatedFat: Int,
    @SerializedName("saturated_fat_points")
    val saturatedFatPoints: Int,
    @SerializedName("saturated_fat_value")
    val saturatedFatValue: Int,
    @SerializedName("sodium")
    val sodium: Double,
    @SerializedName("sodium_points")
    val sodiumPoints: Int,
    @SerializedName("sodium_value")
    val sodiumValue: Double,
    @SerializedName("sugars")
    val sugars: Int,
    @SerializedName("sugars_points")
    val sugarsPoints: Int,
    @SerializedName("sugars_value")
    val sugarsValue: Int
)