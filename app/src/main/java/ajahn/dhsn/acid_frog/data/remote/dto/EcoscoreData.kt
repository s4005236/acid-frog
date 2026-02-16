package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class EcoscoreData(
    @SerializedName("adjustments")
    val adjustments: Adjustments,
    @SerializedName("environmental_score_not_applicable_for_category")
    val environmentalScoreNotApplicableForCategory: String,
    @SerializedName("grade")
    val grade: String,
    @SerializedName("missing")
    val missing: Missing,
    @SerializedName("scores")
    val scores: Scores,
    @SerializedName("status")
    val status: String
)