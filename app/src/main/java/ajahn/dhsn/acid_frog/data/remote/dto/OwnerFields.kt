package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class OwnerFields(
    @SerializedName("abbreviated_product_name_fr")
    val abbreviatedProductNameFr: Int,
    @SerializedName("brands")
    val brands: Int,
    @SerializedName("categories")
    val categories: Int,
    @SerializedName("conservation_conditions_fr")
    val conservationConditionsFr: Int,
    @SerializedName("countries")
    val countries: Int,
    @SerializedName("customer_service_fr")
    val customerServiceFr: Int,
    @SerializedName("data_sources")
    val dataSources: Int,
    @SerializedName("generic_name_fr")
    val genericNameFr: Int,
    @SerializedName("ingredients_text_fr")
    val ingredientsTextFr: Int,
    @SerializedName("lang")
    val lang: Int,
    @SerializedName("lc")
    val lc: Int,
    @SerializedName("nutrition_data_per")
    val nutritionDataPer: Int,
    @SerializedName("nutrition_data_prepared_per")
    val nutritionDataPreparedPer: Int,
    @SerializedName("obsolete")
    val obsolete: Int,
    @SerializedName("origin_fr")
    val originFr: Int,
    @SerializedName("owner")
    val owner: Int,
    @SerializedName("product_name_fr")
    val productNameFr: Int,
    @SerializedName("quantity")
    val quantity: Int
)