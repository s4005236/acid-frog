package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class OrgGs1(
    @SerializedName("gln")
    val gln: String,
    @SerializedName("gpcCategoryCode")
    val gpcCategoryCode: String,
    @SerializedName("gpcCategoryName")
    val gpcCategoryName: String,
    @SerializedName("isAllergenRelevantDataProvided")
    val isAllergenRelevantDataProvided: String,
    @SerializedName("lastChangeDateTime")
    val lastChangeDateTime: String,
    @SerializedName("partyName")
    val partyName: String,
    @SerializedName("publicationDateTime")
    val publicationDateTime: String
)