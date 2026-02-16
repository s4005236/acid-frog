package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class NutritionFr(
    @SerializedName("coordinates_image_size")
    val coordinatesImageSize: String,
    @SerializedName("imgid")
    val imgid: Int,
    @SerializedName("rev")
    val rev: Int,
    @SerializedName("sizes")
    val sizes: Sizes,
    @SerializedName("x1")
    val x1: Int,
    @SerializedName("x2")
    val x2: Int,
    @SerializedName("y1")
    val y1: Int,
    @SerializedName("y2")
    val y2: Int
)