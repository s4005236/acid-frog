package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DataQualityDimensions(
    @SerializedName("accuracy")
    val accuracy: Accuracy = Accuracy(),
    @SerializedName("completeness")
    val completeness: Completeness = Completeness()
)