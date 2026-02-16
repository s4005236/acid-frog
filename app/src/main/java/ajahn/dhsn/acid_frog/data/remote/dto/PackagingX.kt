package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class PackagingX(
    @SerializedName("environmental_score_material_score")
    val environmentalScoreMaterialScore: Int,
    @SerializedName("environmental_score_shape_ratio")
    val environmentalScoreShapeRatio: Double,
    @SerializedName("material")
    val material: String,
    @SerializedName("material_shape")
    val materialShape: String,
    @SerializedName("non_recyclable_and_non_biodegradable")
    val nonRecyclableAndNonBiodegradable: String,
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