package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class OriginsOfIngredients(
    @SerializedName("aggregated_origins")
    val aggregatedOrigins: List<AggregatedOrigin>,
    @SerializedName("epi_score")
    val epiScore: Int,
    @SerializedName("epi_value")
    val epiValue: Int,
    @SerializedName("origins_from_categories")
    val originsFromCategories: List<String>,
    @SerializedName("origins_from_origins_field")
    val originsFromOriginsField: List<String>,
    @SerializedName("transportation_score")
    val transportationScore: Int,
    @SerializedName("transportation_scores")
    val transportationScores: TransportationScores,
    @SerializedName("transportation_value")
    val transportationValue: Int,
    @SerializedName("transportation_values")
    val transportationValues: TransportationValues,
    @SerializedName("value")
    val value: Int,
    @SerializedName("values")
    val values: Values
)