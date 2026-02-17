package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class SelectedImages(
    @SerializedName("front")
    val front: Front = Front(),
    @SerializedName("ingredients")
    val ingredients: Ingredients = Ingredients(),
    @SerializedName("nutrition")
    val nutrition: Nutrition = Nutrition(),
    @SerializedName("packaging")
    val packaging: PackagingXXX = PackagingXXX()
)