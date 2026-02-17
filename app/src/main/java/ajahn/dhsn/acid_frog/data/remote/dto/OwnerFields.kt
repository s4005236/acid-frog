package ajahn.dhsn.acid_frog.data.remote.dto


import com.google.gson.annotations.SerializedName

data class OwnerFields(
    @SerializedName("abbreviated_product_name_fr")
    val abbreviatedProductNameFr: Int = 0,
    @SerializedName("brands")
    val brands: Int = 0,
    @SerializedName("categories")
    val categories: Int = 0,
    @SerializedName("conservation_conditions_fr")
    val conservationConditionsFr: Int = 0,
    @SerializedName("countries")
    val countries: Int = 0,
    @SerializedName("customer_service_fr")
    val customerServiceFr: Int = 0,
    @SerializedName("data_sources")
    val dataSources: Int = 0,
    @SerializedName("generic_name_fr")
    val genericNameFr: Int = 0,
    @SerializedName("ingredients_text_fr")
    val ingredientsTextFr: Int = 0,
    @SerializedName("lang")
    val lang: Int = 0,
    @SerializedName("lc")
    val lc: Int = 0,
    @SerializedName("nutrition_data_per")
    val nutritionDataPer: Int = 0,
    @SerializedName("nutrition_data_prepared_per")
    val nutritionDataPreparedPer: Int = 0,
    @SerializedName("obsolete")
    val obsolete: Int = 0,
    @SerializedName("origin_fr")
    val originFr: Int = 0,
    @SerializedName("owner")
    val owner: Int = 0,
    @SerializedName("product_name_fr")
    val productNameFr: Int = 0,
    @SerializedName("quantity")
    val quantity: Int = 0
)