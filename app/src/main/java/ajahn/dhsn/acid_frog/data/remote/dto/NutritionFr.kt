package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class NutritionFr(
    @SerializedName("coordinates_image_size")
    val coordinatesImageSize: String = "",
    @SerializedName("imgid")
    val imgid: Int = 0,
    @SerializedName("rev")
    val rev: Int = 0,
    @SerializedName("sizes")
    val sizes: Sizes = Sizes(),
    @SerializedName("x1")
    val x1: Int = 0,
    @SerializedName("x2")
    val x2: Int = 0,
    @SerializedName("y1")
    val y1: Int = 0,
    @SerializedName("y2")
    val y2: Int = 0
)