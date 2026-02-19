package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Nutriments(
    @SerializedName("added-sugars")
    val addedSugars: Int = 0,
    @SerializedName("added-sugars_100g")
    val addedSugars100g: Int = 0,
    @SerializedName("added-sugars_modifier")
    val addedSugarsModifier: String = "",
    @SerializedName("added-sugars_serving")
    val addedSugarsServing: Int = 0,
    @SerializedName("added-sugars_unit")
    val addedSugarsUnit: String = "",
    @SerializedName("added-sugars_value")
    val addedSugarsValue: Int = 0,
    @SerializedName("bicarbonate")
    val bicarbonate: Double = 0.0,
    @SerializedName("bicarbonate_100g")
    val bicarbonate100g: Double = 0.0,
    @SerializedName("bicarbonate_serving")
    val bicarbonateServing: Double = 0.0,
    @SerializedName("bicarbonate_unit")
    val bicarbonateUnit: String = "",
    @SerializedName("bicarbonate_value")
    val bicarbonateValue: Double = 0.0,
    @SerializedName("calcium")
    val calcium: Double = 0.0,
    @SerializedName("calcium_100g")
    val calcium100g: Double = 0.0,
    @SerializedName("calcium_serving")
    val calciumServing: Double = 0.0,
    @SerializedName("calcium_unit")
    val calciumUnit: String = "",
    @SerializedName("calcium_value")
    val calciumValue: Double = 0.0,
    @SerializedName("chloride")
    val chloride: Double = 0.0,
    @SerializedName("chloride_100g")
    val chloride100g: Double = 0.0,
    @SerializedName("chloride_serving")
    val chlorideServing: Double = 0.0,
    @SerializedName("chloride_unit")
    val chlorideUnit: String = "",
    @SerializedName("chloride_value")
    val chlorideValue: Double = 0.0,
    @SerializedName("fluoride")
    val fluoride: Double = 0.0,
    @SerializedName("fluoride_100g")
    val fluoride100g: Double = 0.0,
    @SerializedName("fluoride_serving")
    val fluorideServing: Double = 0.0,
    @SerializedName("fluoride_unit")
    val fluorideUnit: String = "",
    @SerializedName("fluoride_value")
    val fluorideValue: Double = 0.0,
    @SerializedName("fruits-vegetables-legumes-estimate-from-ingredients_100g")
    val fruitsVegetablesLegumesEstimateFromIngredients100g: Int = 0,
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_100g")
    val fruitsVegetablesNutsEstimateFromIngredients100g: Int = 0,
    @SerializedName("magnesium")
    val magnesium: Double = 0.0,
    @SerializedName("magnesium_100g")
    val magnesium100g: Double = 0.0,
    @SerializedName("magnesium_serving")
    val magnesiumServing: Double = 0.0,
    @SerializedName("magnesium_unit")
    val magnesiumUnit: String = "",
    @SerializedName("magnesium_value")
    val magnesiumValue: Double = 0.0,
    @SerializedName("nitrate")
    val nitrate: Double = 0.0,
    @SerializedName("nitrate_100g")
    val nitrate100g: Double = 0.0,
    @SerializedName("nitrate_modifier")
    val nitrateModifier: String = "",
    @SerializedName("nitrate_serving")
    val nitrateServing: Double = 0.0,
    @SerializedName("nitrate_unit")
    val nitrateUnit: String = "",
    @SerializedName("nitrate_value")
    val nitrateValue: Double = 0.0,
    @SerializedName("nova-group")
    val novaGroup: Int = 0,
    @SerializedName("nova-group_100g")
    val novaGroup100g: Int = 0,
    @SerializedName("nova-group_serving")
    val novaGroupServing: Int = 0,
    @SerializedName("nova-group_unit")
    val novaGroupUnit: String = "",
    @SerializedName("nova-group_value")
    val novaGroupValue: Int = 0,
    @SerializedName("potassium")
    val potassium: Double = 0.0,
    @SerializedName("potassium_100g")
    val potassium100g: Double = 0.0,
    @SerializedName("potassium_serving")
    val potassiumServing: Double = 0.0,
    @SerializedName("potassium_unit")
    val potassiumUnit: String = "",
    @SerializedName("potassium_value")
    val potassiumValue: Double = 0.0,
    @SerializedName("salt")
    val salt: Double = 0.0,
    @SerializedName("salt_100g")
    val salt100g: Double = 0.0,
    @SerializedName("salt_modifier")
    val saltModifier: String = "",
    @SerializedName("salt_serving")
    val saltServing: Double = 0.0,
    @SerializedName("salt_unit")
    val saltUnit: String = "",
    @SerializedName("salt_value")
    val saltValue: Double = 0.0,
    @SerializedName("silica")
    val silica: Double = 0.0,
    @SerializedName("silica_100g")
    val silica100g: Double = 0.0,
    @SerializedName("silica_serving")
    val silicaServing: Double = 0.0,
    @SerializedName("silica_unit")
    val silicaUnit: String = "",
    @SerializedName("silica_value")
    val silicaValue: Double = 0.0,
    @SerializedName("sodium")
    val sodium: Double = 0.0,
    @SerializedName("sodium_100g")
    val sodium100g: Double = 0.0,
    @SerializedName("sodium_serving")
    val sodiumServing: Double = 0.0,
    @SerializedName("sodium_unit")
    val sodiumUnit: String = "",
    @SerializedName("sodium_value")
    val sodiumValue: Double = 0.0,
    @SerializedName("sulphate")
    val sulphate: Double = 0.0,
    @SerializedName("sulphate_100g")
    val sulphate100g: Double = 0.0,
    @SerializedName("sulphate_serving")
    val sulphateServing: Double = 0.0,
    @SerializedName("sulphate_unit")
    val sulphateUnit: String = "",
    @SerializedName("sulphate_value")
    val sulphateValue: Double = 0.0
)