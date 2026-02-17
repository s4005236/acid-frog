package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class OriginsOfIngredients(
    @SerializedName("aggregated_origins")
    val aggregatedOrigins: List<AggregatedOrigin> = listOf(),
    @SerializedName("epi_score")
    val epiScore: Int = 0,
    @SerializedName("epi_value")
    val epiValue: Int = 0,
    @SerializedName("origins_from_categories")
    val originsFromCategories: List<String> = listOf(),
    @SerializedName("origins_from_origins_field")
    val originsFromOriginsField: List<String> = listOf(),
    @SerializedName("transportation_score")
    val transportationScore: Int = 0,
    @SerializedName("transportation_scores")
    val transportationScores: TransportationScores = TransportationScores(),
    @SerializedName("transportation_value")
    val transportationValue: Int = 0,
    @SerializedName("transportation_values")
    val transportationValues: TransportationValues = TransportationValues(),
    @SerializedName("value")
    val value: Int = 0,
    @SerializedName("values")
    val values: Values = Values()
)