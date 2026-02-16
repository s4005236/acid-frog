package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Nutriments(
    @SerializedName("added-sugars")
    val addedSugars: Int,
    @SerializedName("added-sugars_100g")
    val addedSugars100g: Int,
    @SerializedName("added-sugars_modifier")
    val addedSugarsModifier: String,
    @SerializedName("added-sugars_serving")
    val addedSugarsServing: Int,
    @SerializedName("added-sugars_unit")
    val addedSugarsUnit: String,
    @SerializedName("added-sugars_value")
    val addedSugarsValue: Int,
    @SerializedName("bicarbonate")
    val bicarbonate: Double,
    @SerializedName("bicarbonate_100g")
    val bicarbonate100g: Double,
    @SerializedName("bicarbonate_serving")
    val bicarbonateServing: Double,
    @SerializedName("bicarbonate_unit")
    val bicarbonateUnit: String,
    @SerializedName("bicarbonate_value")
    val bicarbonateValue: Double,
    @SerializedName("calcium")
    val calcium: Double,
    @SerializedName("calcium_100g")
    val calcium100g: Double,
    @SerializedName("calcium_serving")
    val calciumServing: Double,
    @SerializedName("calcium_unit")
    val calciumUnit: String,
    @SerializedName("calcium_value")
    val calciumValue: Double,
    @SerializedName("chloride")
    val chloride: Double,
    @SerializedName("chloride_100g")
    val chloride100g: Double,
    @SerializedName("chloride_serving")
    val chlorideServing: Double,
    @SerializedName("chloride_unit")
    val chlorideUnit: String,
    @SerializedName("chloride_value")
    val chlorideValue: Double,
    @SerializedName("fluoride")
    val fluoride: Double,
    @SerializedName("fluoride_100g")
    val fluoride100g: Double,
    @SerializedName("fluoride_serving")
    val fluorideServing: Double,
    @SerializedName("fluoride_unit")
    val fluorideUnit: String,
    @SerializedName("fluoride_value")
    val fluorideValue: Double,
    @SerializedName("fruits-vegetables-legumes-estimate-from-ingredients_100g")
    val fruitsVegetablesLegumesEstimateFromIngredients100g: Int,
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_100g")
    val fruitsVegetablesNutsEstimateFromIngredients100g: Int,
    @SerializedName("magnesium")
    val magnesium: Double,
    @SerializedName("magnesium_100g")
    val magnesium100g: Double,
    @SerializedName("magnesium_serving")
    val magnesiumServing: Double,
    @SerializedName("magnesium_unit")
    val magnesiumUnit: String,
    @SerializedName("magnesium_value")
    val magnesiumValue: Double,
    @SerializedName("nitrate")
    val nitrate: Double,
    @SerializedName("nitrate_100g")
    val nitrate100g: Double,
    @SerializedName("nitrate_modifier")
    val nitrateModifier: String,
    @SerializedName("nitrate_serving")
    val nitrateServing: Double,
    @SerializedName("nitrate_unit")
    val nitrateUnit: String,
    @SerializedName("nitrate_value")
    val nitrateValue: Double,
    @SerializedName("nova-group")
    val novaGroup: Int,
    @SerializedName("nova-group_100g")
    val novaGroup100g: Int,
    @SerializedName("nova-group_serving")
    val novaGroupServing: Int,
    @SerializedName("nova-group_unit")
    val novaGroupUnit: String,
    @SerializedName("nova-group_value")
    val novaGroupValue: Int,
    @SerializedName("potassium")
    val potassium: Double,
    @SerializedName("potassium_100g")
    val potassium100g: Double,
    @SerializedName("potassium_serving")
    val potassiumServing: Double,
    @SerializedName("potassium_unit")
    val potassiumUnit: String,
    @SerializedName("potassium_value")
    val potassiumValue: Double,
    @SerializedName("salt")
    val salt: Double,
    @SerializedName("salt_100g")
    val salt100g: Double,
    @SerializedName("salt_modifier")
    val saltModifier: String,
    @SerializedName("salt_serving")
    val saltServing: Double,
    @SerializedName("salt_unit")
    val saltUnit: String,
    @SerializedName("salt_value")
    val saltValue: Double,
    @SerializedName("silica")
    val silica: Double,
    @SerializedName("silica_100g")
    val silica100g: Double,
    @SerializedName("silica_serving")
    val silicaServing: Double,
    @SerializedName("silica_unit")
    val silicaUnit: String,
    @SerializedName("silica_value")
    val silicaValue: Double,
    @SerializedName("sodium")
    val sodium: Double,
    @SerializedName("sodium_100g")
    val sodium100g: Double,
    @SerializedName("sodium_serving")
    val sodiumServing: Double,
    @SerializedName("sodium_unit")
    val sodiumUnit: String,
    @SerializedName("sodium_value")
    val sodiumValue: Double,
    @SerializedName("sulphate")
    val sulphate: Double,
    @SerializedName("sulphate_100g")
    val sulphate100g: Double,
    @SerializedName("sulphate_serving")
    val sulphateServing: Double,
    @SerializedName("sulphate_unit")
    val sulphateUnit: String,
    @SerializedName("sulphate_value")
    val sulphateValue: Double
)