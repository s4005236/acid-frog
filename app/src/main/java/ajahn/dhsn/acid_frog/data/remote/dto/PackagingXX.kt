package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PackagingXX(
    @SerializedName("food_contact")
    val foodContact: Int,
    @SerializedName("material")
    val material: String,
    @SerializedName("number_of_units")
    val numberOfUnits: Int,
    @SerializedName("quantity_per_unit")
    val quantityPerUnit: String,
    @SerializedName("quantity_per_unit_unit")
    val quantityPerUnitUnit: String,
    @SerializedName("quantity_per_unit_value")
    val quantityPerUnitValue: Double,
    @SerializedName("recycling")
    val recycling: String,
    @SerializedName("shape")
    val shape: String,
    @SerializedName("weight_measured")
    val weightMeasured: Double
)