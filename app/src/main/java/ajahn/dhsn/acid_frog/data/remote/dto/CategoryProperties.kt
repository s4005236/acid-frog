package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CategoryProperties(
    @SerializedName("ciqual_food_name:en")
    val ciqualFoodNameEn: String,
    @SerializedName("ciqual_food_name:fr")
    val ciqualFoodNameFr: String
)